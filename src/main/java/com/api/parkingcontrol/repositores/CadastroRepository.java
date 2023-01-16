package com.api.parkingcontrol.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.models.CadastroUsuario;


@RestController
public interface CadastroRepository  extends JpaRepository<CadastroUsuario, Long>{
    
}
