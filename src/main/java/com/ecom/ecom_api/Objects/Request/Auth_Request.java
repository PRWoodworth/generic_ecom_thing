package com.ecom.ecom_api.Objects.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth_Request {
    private String username;
    private String password;
}
