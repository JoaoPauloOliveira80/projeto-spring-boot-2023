package com.api.parkingcontrol.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.parkingcontrol.models.ProdutosModelo;

@Repository
public interface ProdutosRepository  extends JpaRepository<ProdutosModelo, Long>{
    
}
