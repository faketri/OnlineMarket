import { Brand } from "@/entities/brand/model/Brand";
import { Characteristics } from "@/entities/characteristics/model/Characteristics";
import { Image } from "@/entities/image/model/Image";
import { Categories } from "@/entities/categories/model/Categories";

export type Product = {
  id: string;
  brand: Brand;
  nameModel: string;
  categories: Categories;
  image: Array<Image>;
  characteristics: Array<Characteristics>;
  price: number;
  description: string;
  promoPrice: number;
  isPromoActive: boolean;
  discount: number;
  quantity: number;
  quantitySold: number;
};
