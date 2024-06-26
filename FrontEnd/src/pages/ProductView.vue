<template>
  <div class="container mt-2">
    <h1 v-if="product">
      {{ product.brand.name + " " + product.nameModel }}
    </h1>
    <div v-if="product" class="wrapper row rounded-2 ps-2 shadow">
      <div class="col-12 col-sm-6 col-md-5 pt-2 img">
        <swiper
          :slides-per-view="1"
          :centered-slides="true"
          :space-between="10"
          :thumbs="{ swiper: thumbsSwiper }"
          :modules="modules"
          class="mainSwiper"
        >
          <swiper-slide
            class="text-center border"
            v-for="image in product.image"
            :key="image.id"
          >
            <img
              :src="'http://localhost:9000/api/image/' + image.id"
              alt=""
              style="max-height: 220px"
            />
          </swiper-slide>
        </swiper>
        <swiper
          @swiper="setThumbsSwiper"
          :space-between="10"
          :slides-per-view="3"
          :free-mode="true"
          :navigation="true"
          :watch-slides-progress="true"
          :modules="modules"
          class="mySwiper"
        >
          <swiper-slide v-for="image in product.image" :key="image.id">
            <img
              :src="'http://localhost:9000/api/image/' + image.id"
              alt=""
              style="max-height: 120px"
            />
          </swiper-slide>
        </swiper>
      </div>
      <div class="characteristics col-12 col-sm-6 col-md-4 pt-2">
        <div class="characteristics">
          <h4>Характеристики</h4>
          <CharacteristicsToProductPage
            :characteristics="product.characteristics"
          ></CharacteristicsToProductPage>
        </div>
      </div>
      <div
        class="info col-11 col-sm-8 col-md-3 col-lg-3 info d-flex flex-column justify-content-center align-items-center"
      >
        <div class="price d-flex flex-column justify-content-around">
          <h2 v-if="product.promoItem">{{ product.promoPrice }} руб.</h2>
          <h2
            :class="
              product.promoItem ? 'text-decoration-line-through opacity-50' : ''
            "
          >
            {{ product.price }} руб.
          </h2>
        </div>
        <div class="actions w-100 d-flex">
          <button
            class="btn shadow me-2"
            @click="userStore.toFavorite(product)"
          >
            <img
              :src="
                userStore.isLikedProduct(product.id)
                  ? '/red.svg'
                  : '/Vector.svg'
              "
              alt=""
            />
          </button>
          <button
            @click="
              userStore.isInBasketProduct(product.id)
                ? userStore.removeBasket(product.id)
                : userStore.addBasket(product.id)
            "
            class="btn btn-primary w-100"
          >
            {{
              userStore.isInBasketProduct(product.id)
                ? "Удалить из корзины"
                : "В корзину"
            }}
          </button>
        </div>
      </div>
      <div class="additional-information mt-5">
        <div class="additional-information-body border-top">
          <div class="description">
            <h1>Описание</h1>
            <p>
              {{ product.description }}
            </p>
          </div>
          <div class="rating border-top">
            <h1>Отзывы</h1>
            <div class="rating-add">
              <button
                type="button"
                class="btn btn-outline-primary"
                @click="showModal = true"
              >
                Добавить отзыв
              </button>
              <div>
                <!-- Модальное окно -->
                <ModelView v-bind:show="showModal" @close="showModal = false">
                  <form
                    class="d-flex flex-column gap-2"
                    @submit.prevent="addRating"
                  >
                    <label for="grade">Рейтинг</label>
                    <input
                      type="number"
                      min="1"
                      max="5"
                      id="grade"
                      v-model="review.grade"
                    />

                    <label for="description">Описание</label>
                    <input
                      type="text"
                      id="description"
                      v-model="review.description"
                    />

                    <button class="btn btn-success" type="submit">
                      Отправить
                    </button>
                  </form>
                </ModelView>
              </div>
            </div>
            <div v-if="productRating[ratingPage]" class="wrapper">
              <RatingComp
                v-for="(item, index) in productRating[ratingPage].content"
                :key="index"
                v-bind:rating="item"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref, watch } from "vue";
import { ProductActions } from "@/entities/product/api/model/Actions";
import { useRoute } from "vue-router";
import { Swiper, SwiperSlide } from "swiper/vue";
import { FreeMode, Pagination, Navigation, Thumbs } from "swiper/modules";
import CharacteristicsToProductPage from "@/entities/characteristics/ui/CharacteristicsToProductPage.vue";
import RatingComp from "@/entities/rating/ui/RatingComp.vue";
import { RatingAction } from "@/entities/rating/api/actions";
import { userStoreModule } from "@/entities/user/api/index.js";
import ModelView from "@/widgets/ModelView.vue";

import "swiper/css/navigation";
import "swiper/css/thumbs";
import "swiper/css";

const route = useRoute();
const userStore = userStoreModule();

const dataLoading = ref(true);
const product = ref(null);
const productRating = ref([]);
const ratingPage = 0;

const thumbsSwiper = ref();

const setThumbsSwiper = (swiper) => {
  thumbsSwiper.value = swiper;
};

const modules = [FreeMode, Navigation, Thumbs, Pagination];

const showModal = ref(false);

const review = ref({
  grade: 0,
  description: "",
});

watch(
  () => route.params.id,
  async () => {
    console.log(route.params.id);
    await loadProduct();
  }
);

const loadProduct = async () => {
  const productId = route.params.id.toString();
  product.value = await ProductActions.loadProductById(productId);
  productRating.value = [];
  dataLoading.value = false;
};

const loadRating = async () => {
  const productId = route.params.id.toString();
  const response = await RatingAction.loadByProductId(
    ratingPage,
    20,
    productId
  );
  productRating.value[ratingPage] = response;
};

const addRating = async () => {
  try {
    if (!userStore.isLogin) {
      alert("Вы не авторизованы.");
      return;
    }
    const productId = route.params.id.toString();
    const response = await userStore.addRating(productId, review.value);
    if (productRating.value) productRating.value[0] = { content: [] };
    productRating.value[ratingPage].content.push(response);
  } catch (err) {
    alert("Неудалось добавить отзыв.");
    console.log(err.message);
  }
};

onMounted(async () => {
  await loadProduct();
  await loadRating();
});
</script>

<style scoped>
.img {
  position: relative;
}

.swiper-slide {
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  overflow: hidden;
}

.swiper-slide img {
  height: auto;
  margin-top: 40px;
  margin-bottom: 40px;
  transition: transform 0.3s ease;
}

.swiper-slide img:hover {
  transform: scale(1.1);
}

.mySwiper {
  margin-top: 20px;
}

.mySwiper .swiper-slide {
  opacity: 0.4;
  transition: opacity 0.3s ease;
}

.mySwiper .swiper-slide-thumb-active {
  opacity: 1;
}

.swiper-button-next,
.swiper-button-prev {
  color: #000;
  transition: color 0.3s ease;
}

.swiper-button-next:hover,
.swiper-button-prev:hover {
  color: #007bff;
}

.swiper-pagination-bullet {
  background: #007bff;
}

.swiper-pagination-bullet-active {
  background: #000;
}

@media screen and (max-width: 768px) {
  .info {
    position: fixed;
    bottom: 60px;
    z-index: 999;
    background-color: white;
    padding: 0;
  }
  .container {
    margin: 0 auto 150px;
  }
}
</style>
