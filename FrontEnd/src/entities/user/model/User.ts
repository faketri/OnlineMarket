import { Product } from "@/entities/product/model/Product";
import { Image } from "@/entities/image/model/Image";
import { Basket } from "@/entities/basket/model/basket";
import { Orders } from "@/entities/orders/model";

export type User = {
  id: string;
  login: string;
  profileImage: Image;
  name: string;
  surname: string;
  email: string;
  password: string;
  basket: Basket;
  city: string;
  role: Array<string>;
  orders: Array<Orders>;
  favoriteProduct: Array<Product>;
  dateOfCreate: Date;
  dateOfBirthday: Date;
};
