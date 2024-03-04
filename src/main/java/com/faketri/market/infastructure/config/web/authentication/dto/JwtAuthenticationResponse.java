package com.faketri.market.infastructure.config.web.authentication.dto;

import com.faketri.market.infastructure.user.dto.UserResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The type Jwt authentication response.
 *
 * @author Dmitriy Faketri
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Ответ c токеном доступа")
public class JwtAuthenticationResponse {

    @Schema(description = "Пользователь")
    private UserResponse user;
    @Schema(description = "Токен доступа",
            example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyMjUwNj...")
    private String       token;

    @Override
    public String toString() {
        return "Bearer " + token;
    }

}
