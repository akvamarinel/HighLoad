package org.itmo.highload.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.highload.dto.dish.DishDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    UUID id;
    @NotNull
    @NotBlank
    @NotEmpty
    String name;
}
