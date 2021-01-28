package com.beta.ms.auth.ro;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LoginRO {
    private String username;
    private String password;
}
