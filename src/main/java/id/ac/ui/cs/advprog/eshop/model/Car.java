package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Getter
@Setter
public class Car {

    private String carId;

    @NotBlank(message = "name cannot be empty")
    private String carName;

    @NotBlank(message = "color cannot be empty")
    private String carColor;

    @NotNull(message = "please pick a quantity")
    @Min(value = 0, message = "must be atleast 0")
    @Max(value = 100000, message = "must be at most 100.000")
    private Integer carQuantity;
}
