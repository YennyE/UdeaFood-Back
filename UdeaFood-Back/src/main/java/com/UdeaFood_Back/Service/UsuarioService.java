package com.UdeaFood_Back.Service;


import com.UdeaFood_Back.DTO.LoginRequest;
import com.UdeaFood_Back.Modelo.Usuario;
import com.UdeaFood_Back.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioService {

    private final IUsuarioRepository iUsuarioRepository;


    public void crearUsuario(Usuario usuario){
        if(iUsuarioRepository.existsUsuarioByCorreo(usuario.getCorreo())){
            throw new RuntimeException("El correo ya está en uso");
        }
        iUsuarioRepository.save(usuario);
    }
    public Usuario login(LoginRequest loginRequest) {
        Usuario usuario = iUsuarioRepository.findUsuarioByCorreo(loginRequest.getCorreo());

        if (usuario != null && usuario.getClave().equals(loginRequest.getClave())) {
            return usuario;
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}
