package com.ecom.ecom_api.Objects.Request;

import lombok.Data;

@Data
public class New_User {
    private String email;
    private String first_name;
    private String last_name;
    private String password;
}

