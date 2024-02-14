package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Getter
@Setter
public class Product {

    private String productId;

    @NotBlank(message = "name cannot be empty")
    private String productName;

    @NotNull(message = "please pick a quantity")
    @Min(value = 0, message = "must be at least 0")
    @Max(value = 100000, message = "must be at most 100.000")
    private Integer productQuantity;
}
