package org.itmo.highload.restaurant.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResponseDto {
    private UUID id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String name;
    @NotNull
    private Integer rating;

    private List<UUID> dishes = new ArrayList<>();
}
