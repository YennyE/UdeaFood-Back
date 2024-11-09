package com.UdeaFood_Back.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

        private String correo;
        private String clave;

        public LoginRequest() {
        }

        public LoginRequest(String correo, String clave) {
            this.correo = correo;
            this.clave = clave;
        }

}
