package com.faketri.market;

import com.faketri.market.domain.Promo.Promotion;
import com.faketri.market.domain.image.Image;
import com.faketri.market.domain.order.Rating;
import com.faketri.market.domain.product.*;
import com.faketri.market.domain.users.User;
import com.faketri.market.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
public class MarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner
			(ProductService productService, PromotionService promotionService,
			 CategoriesService categoriesService, RatingService ratingService, UserService userService){
		return args -> {

			Long categoriesId = categoriesService.save(new Categories(null, "phone"));

			List<Product> products = new ArrayList<>();

			products.add(new Product(null,
					new Brand(null, "Samsung"),
					"S23", 23000L, 100, 21, false, 0L));

			products.add(new Product(null,
					new Brand(null, "Apple"),
					"15", 123000L, 50, 41, false, 0L));

			products.add(new Product(null,
					new Brand(null, "Nothing"),
					"Phone 2", 103000L, 20, 51, false, 0L));

			List<Characteristics> characteristics = new ArrayList<>();

			characteristics.add(new Characteristics(null, "Диагональ экрана", "6.5"));
			characteristics.add(new Characteristics(null, "Диагональ экрана", "6.7"));
			characteristics.add(new Characteristics(null, "Аккумулятор", "4500мач"));
			characteristics.add(new Characteristics(null, "Аккумулятор", "3500мач"));
			characteristics.add(new Characteristics(null, "Аккумулятор", "3700мач"));

			products.get(0).addImage(new Image(new File("C:\\Users\\rolll\\Downloads\\b2On-cfo7lY.jpg")));
			products.get(1).addImage(new Image(new File("C:\\Users\\rolll\\Downloads\\oAzacSczTkc.jpg")));
			products.get(2).addImage(new Image(new File("C:\\Users\\rolll\\Downloads\\QbSdtGPuvSU.jpg")));

			products.get(0).getCharacteristics().addAll(List.of(characteristics.get(0), characteristics.get(2)));
			products.get(1).getCharacteristics().addAll(List.of(characteristics.get(1), characteristics.get(3)));
			products.get(2).getCharacteristics().addAll(List.of(characteristics.get(1), characteristics.get(4)));

			Categories categories = new Categories(categoriesId, "phone");//, Set.of(products.get(0),products.get(1), products.get(2)));

			products.get(0).setCategories(categories);
			products.get(1).setCategories(categories);
			products.get(2).setCategories(categories);
			products.forEach(item -> item.setId(productService.save(item)));

			User user = new User();
			user.setLogin("vasya");
			user.setPassword("1231231");
			user.setEmail("ashdasd@mail.ru");
			user.setId(userService.save(user));

			ratingService.save(
					new Rating(null, "Крутяк, чел сдох", (short)4, products.get(0),user)
			);
			ratingService.save(
				new Rating(null, "ЯБЛОКООКООКОКОКО", (short)5, products.get(1), user)
			);
			ratingService.save(
					new Rating(null, "нот бэд, ничего нет", (short)3, products.get(2), user)
			);

			Promotion promotion = new Promotion(null, Files.readAllBytes(Path.of("C:\\Users\\rolll\\Downloads\\14fa9860cff53648c5543a262859347f.jpg")), "РАСПРОДАЖА",
					"Не пропустите Главное событие года в ГОДУУУУ!" +
							"Мегаскидки и кешбэк на технику, товары для дома, аксессуары и многое другое. " +
							"А ещё шанс получить главные призы — машину и квартиру в Москве. Участвуйте в розыгрыше уже сейчас!",
					LocalDateTime.of(2023, 12,20, 12,00),
					LocalDateTime.of(2023, 12,30, 12,00));

			List<Product> productList = productService.findAll();
			promotion.getPromotionItems().addAll(productList);
			promotionService.save(promotion);
		};
	}
}

