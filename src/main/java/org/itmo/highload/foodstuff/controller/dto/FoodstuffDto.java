package org.itmo.highload.foodstuff.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodstuffDto {

    UUID id;
    @NotNull
    @NotBlank
    @NotEmpty
    String name;
    @NotNull
    Integer calories;

}
