<template>
  <main class="container">
    <div v-if="promotionData" class="promo">
      <swiper class="mt-2 rounded-2" :navigation="true" :modules="modules">
        <swiper-slide v-for="promo in promotionData" :key="promo.id">
          <router-link :to="'/promotion/' + promo.id">
            <img
              :src="'http://localhost:9000/api/image/' + promo?.banner?.id"
              alt=""
              style="width: 100%; height: 455px"
            />
          </router-link>
        </swiper-slide>
      </swiper>
    </div>
    <h2 style="">Категории</h2>
    <div v-if="categoriesData" class="categories">
      <swiper
        :breakpoints="breakpoints"
        :navigation="true"
        :modules="modules"
        class="mySwiper"
      >
        <swiper-slide v-for="categories in categoriesData" :key="categories.id">
          <CategoriesCard v-bind:categories="categories" />
        </swiper-slide>
      </swiper>
    </div>
    <div
      v-if="productPromotion?.content.length"
      class="product row justify-content-center"
    >
      <h2>Акции</h2>
      <swiper :breakpoints="breakpoints" :navigation="true" :modules="modules">
        <swiper-slide
          :slidesPerView="'auto'"
          :centeredSlides="true"
          v-for="product in productPromotion?.content"
          :key="product.id"
        >
          <ProductCard
            v-bind:product="product"
            v-bind:typeCard="false"
            v-bind:likes="userStore.isLikedProduct(product.id)"
            v-bind:isBasketItem="userStore.isInBasketProduct(product.id)"
            v-on:addToFavorite="userStore.toFavorite(product)"
            v-on:removeFromBasket="userStore.removeBasket"
            v-on:addToBasket="userStore.addBasket"
          />
        </swiper-slide>
      </swiper>
    </div>
    <div
      v-if="productTopSales?.content.length"
      class="product row justify-content-center"
    >
      <h2>Самые продоваемые товары</h2>
      <swiper :breakpoints="breakpoints" :navigation="true" :modules="modules">
        <swiper-slide
          :slidesPerView="'auto'"
          :centeredSlides="true"
          v-for="product in productTopSales?.content"
          :key="product.id"
        >
          <ProductCard
            v-bind:product="product"
            v-bind:typeCard="false"
            v-bind:likes="userStore.isLikedProduct(product.id)"
            v-bind:isBasketItem="userStore.isInBasketProduct(product.id)"
            v-on:addToFavorite="userStore.toFavorite(product)"
            v-on:removeFromBasket="userStore.removeBasket"
            v-on:addToBasket="userStore.addBasket"
          />
        </swiper-slide>
      </swiper>
    </div>
  </main>
</template>

<script setup lang="ts">
import { onMounted, ref } from "vue";
import CategoriesCard from "@/entities/categories/ui/CategoriesCard.vue";
import { ProductActions } from "@/entities/product/api/model/Actions";
import { CategoriesAction } from "@/entities/categories/api/model/actions";
import { Product } from "@/entities/product/model/Product";
import { PageableType } from "@/shared/pageable/pageableType";
import { Categories } from "@/entities/categories/model/Categories";
import { userStoreModule } from "@/entities/user/api/index.js";
import ProductCard from "@/entities/product/ui/ProductCard.vue";

import { Swiper, SwiperSlide } from "swiper/vue";
import { Navigation } from "swiper/modules";
// Import Swiper styles
import "swiper/css";
import "swiper/css/navigation";
import { Promotion } from "@/entities/promotion/model/promotion";
import { PromotionAction } from "@/entities/promotion/api/PromotionAction";

const modules = [Navigation];

const breakpoints = {
  320: {
    slidesPerView: 1,
    spaceBetween: 10,
    centeredSlides: true,
  },
  480: {
    slidesPerView: 2,
    spaceBetween: 10,
  },
  1024: {
    slidesPerView: 3,
    spaceBetween: 10,
  },
  1200: {
    slidesPerView: 5,
    spaceBetween: 10,
  },
};

const productPromotion = ref<PageableType<Product>>();
const productTopSales = ref<PageableType<Product>>();
const categoriesData = ref<Categories[]>();
const promotionData = ref<Promotion[]>();

const userStore = userStoreModule();

onMounted(async () => {
  productPromotion.value = await ProductActions.loadProductInPromotion(0, 10);
  productTopSales.value = await ProductActions.loadTopSales(0, 10);
  categoriesData.value = await CategoriesAction.loadCategories();
  promotionData.value = await PromotionAction.loadPromo();

  return { productPromotion, categoriesData, productTopSales, promotionData };
});
</script>
