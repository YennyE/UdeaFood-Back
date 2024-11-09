package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.DTO.LoginRequest;
import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping()
    public ResponseEntity<Tienda> login(@RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok(loginService.login(loginRequest));
    }
}
