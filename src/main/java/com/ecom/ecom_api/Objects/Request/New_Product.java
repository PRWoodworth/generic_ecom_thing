package com.ecom.ecom_api.Objects.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class New_Product {
    private String product_title;
    private String product_description;
    private double product_price;
}
