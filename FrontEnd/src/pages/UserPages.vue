<template>
  <div class="root container mt-5">
    <div v-if="userStore.user" class="user-profile shadow border p-4 rounded-2">
      <div class="wrapper row">
        <div class="col-12 col-md-4 col-lg-3 img text-center position-relative">
          <img
            class="border rounded-5 profile-image"
            :src="
              'http://localhost:9000/api/image/' +
              userStore.getUser?.profileImage?.id
            "
            alt="Изображение профиля"
            style="max-width: 200px"
          />
          <div class="upload-overlay rounded m-auto" @click="triggerFileInput">
            <img
              src="/upload-solid.svg"
              alt="Upload Icon"
              class="upload-icon"
            />
            <input
              type="file"
              class="file-input"
              accept="image/jpeg, image/gif, image/png"
              @change="handleFileChange"
              ref="fileInput"
            />
          </div>
        </div>
        <div class="col mt-5">
          <div class="info flex-column ms-3">
            <h3 v-text="userStore.getUser.login"></h3>
            <h6 class="text-muted" v-text="userStore.getUser.email"></h6>
            <RouterLink
              v-if="userStore.getUser?.role?.some((r) => r === 'EMPLOYEE')"
              :to="'/user/workspace/orders/list'"
              >Кабинет работника</RouterLink
            >
          </div>
        </div>
      </div>
      <h1 class="mt-3">Данные пользователя</h1>
      <form
        class="d-flex border p-3 flex-column col-12 col-sm-9 col-md-6 gap-3 mt-5"
        @submit.prevent="userStore.uploadProfileData()"
      >
        <input
          class="input-group-text"
          :placeholder="userStore.getUser.name || 'Имя'"
          v-model="userStore.user.name"
          @input="filterInput"
        />
        <input
          class="input-group-text"
          :placeholder="userStore.getUser.surname || 'Фамилия'"
          v-model="userStore.user.surname"
          @input="filterInput"
        />
        <input
          type="date"
          class="input-group"
          :placeholder="userStore.getUser.dateOfBirthday || 'День рождения'"
          v-model="userStore.user.dateOfBirthday"
        />
        <input
          class="input-group-text"
          :placeholder="userStore.getUser.city || 'Город'"
          v-model="userStore.user.city"
          @input="filterInput"
        />
        <input
          type="email"
          class="input-group-text"
          :placeholder="userStore.getUser.email"
          v-model="userStore.user.email"
        />
        <button class="btn btn-success">Сохранить</button>
      </form>

      <div class="">
        <RouterLink :to="'/user/' + userStore?.user?.id + '/orders/'"
          >Заказы</RouterLink
        >
      </div>
      <button class="btn btn-light" @click="userLogout">Выйти</button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { userStoreModule } from "@/entities/user/api/index.js";
import { useRouter } from "vue-router";
import { onMounted, ref, watch } from "vue";
import { OrdersActions } from "@/entities/orders/api";
import { Orders } from "@/entities/orders/model";

const router = useRouter();
const userStore = userStoreModule();
const fileInput = ref<HTMLInputElement | null>(null);
const orders = ref<Orders[]>([]);

function filterInput(event: any) {
  const regex = /[^a-zA-Zа-яА-Я\s]/g;
  event.target.value = event.target.value.replace(regex, "");
}

const triggerFileInput = () => {
  if (fileInput.value) fileInput.value.click();
};

const handleFileChange = (event: any) => {
  const file = event.target.files[0];
  if (file) {
    userStore.uploadProfileImage(file);
  }
};

const userLogout = () => {
  userStore.logout();
  router.push("/");
};

const loadOrders = async () => {
  if (!userStore.user) {
    const response = await OrdersActions.loadByUserId(
      await userStore.getUser.id,
      0,
      5
    );
    orders.value = response;
    return { orders };
  }
};

watch(
  () => userStore.user?.id,
  async (id) => {
    if (id) {
      await loadOrders();
    }
  },
  { immediate: true }
);

onMounted(async () => {
  if (!userStore.isLogin) router.push("/auth");
  await loadOrders();
});
</script>

<style scoped>
.img {
  position: relative;
}

.upload-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgba(0, 0, 0, 0.5);
  opacity: 0;
  transition: opacity 0.3s;
  cursor: pointer;
  max-width: 200px;
}

.upload-overlay:hover {
  opacity: 1;
}

.upload-icon {
  width: 50px;
  height: 50px;
}

.file-input {
  display: none;
}
</style>
