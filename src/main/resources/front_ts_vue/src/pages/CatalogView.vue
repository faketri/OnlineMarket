<template>
  <div class="container">
    <div class="row">
      <div class="col-md-3">
        <div id="filterMenu">
          <!-- Фильтры товаров -->
          <h4>Фильтр</h4>
          <CharacteristicsList
            v-if="characteristics"
            v-bind:characteristics="characteristics"
            v-on:useFiltered="useFiltered"
          />
        </div>
      </div>
      <div class="col-lg-9" v-if="pages[currentPages]">
        <ProductCard
          v-for="product in pages[currentPages].content"
          v-bind:product="product"
          v-bind:likes="userStore.isLikedProduct(product.id)"
          v-on:addToFavorite="userStore.likeProduct(product)"
          v-on:toBasket="userStore.addToBasket(product)"
          :key="product.id"
        ></ProductCard>
        <div class="row">
          <div class="col-12">
            <nav aria-label="Page navigation">
              <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <!-- Add more page numbers here -->
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from "vue";
import { ProductActions } from "@/entities/product/api/model/Actions";
import { useRoute } from "vue-router";
import ProductCard from "@/entities/product/ui/ProductCard.vue";
import CharacteristicsList from "@/entities/characteristics/ui/CharacteristicsList.vue";
import { PageableType } from "@/shared/pageable/pageableType";
import { Product } from "@/entities/product/model/Product";
import { CharacteristicsAction } from "@/entities/characteristics/api/model/actions";
import { Characteristics } from "@/entities/characteristics/model/Characteristics";
import { userStoreModule } from "@/entities/user/api/index.js";

const route = useRoute();

const currentPages = ref(0);
const pageSize = 20;
const categoriesId: string = route.params.id.toString();
const userStore = userStoreModule();

const pages = ref<PageableType<Product>[]>([]);
const characteristics = ref<Characteristics[]>();

const filter = ref<Characteristics[]>([]);

const useFiltered = async (selectedValues: Characteristics[]) => {
  filter.value = selectedValues;
  pages.value = [];
  const res = await loadPages();
  pages.value.push(res);
};

const loadPages = async (): Promise<PageableType<Product>> => {
  console.log(filter.value);
  return filter.value.length > 0
    ? await ProductActions.loadProductByCategories(
        currentPages.value,
        pageSize,
        categoriesId,
        filter.value
      )
    : await ProductActions.loadProductByCategories(
        currentPages.value,
        pageSize,
        categoriesId
      );
};

document.addEventListener("DOMContentLoaded", function () {
  const filterMenuBtn = document.getElementById("filterMenuBtn");
  const filterMenu = document.getElementById("filterMenu");
  filterMenuBtn?.addEventListener("click", function () {
    filterMenu?.classList.toggle("show");
  });
});

onMounted(async () => {
  const res = await loadPages();
  characteristics.value =
    await CharacteristicsAction.loadCharacteristicsByProductCategories(
      categoriesId
    );
  pages.value.push(res);
  return { pages, characteristics };
});
</script>

<style scoped></style>
