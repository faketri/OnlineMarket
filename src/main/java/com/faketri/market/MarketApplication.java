package com.faketri.market;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Market application.
 *
 * @author Dmitriy Faketri
 */
@SpringBootApplication
public class MarketApplication {

    static final Logger log = LoggerFactory.getLogger(MarketApplication.class);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        log.info("Before Starting application");
        SpringApplication.run(MarketApplication.class, args);
        log.debug("Starting my application in debug with {} args", args.length);
        log.info("Starting my application with {} args.", args.length);
    }

    /*@Bean
    public CommandLineRunner CommandLineRunner(UserService userService, AuthService authService, PasswordEncoder passwordEncoder){
        return args -> {
            SignUpRequest signUpRequest = new SignUpRequest();
            signUpRequest.setLogin("ValeraKraftAdmin");
            signUpRequest.setEmail("magistorADMIN@mail.ru");
            signUpRequest.setPassword("123123123");
            var req = authService.signUp(signUpRequest);

            final Users users = userService.findById(req.getUser().getId());
            users.getRole().addAll(Set.of(ERole.EMPLOYEE, ERole.SUPER_USER));
            userService.save(users);
        };
    }*/
}

