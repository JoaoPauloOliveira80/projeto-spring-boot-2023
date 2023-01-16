package com.api.parkingcontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ProdutosModelo;
import com.api.parkingcontrol.models.RespostaModelo;
import com.api.parkingcontrol.repositores.ProdutosRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutosRepository prodRep;

    @Autowired
    private RespostaModelo rm;

    public boolean verificarPorId(Long id) {
		return prodRep.existsById(id);
	}

  
    public List<ProdutosModelo> listar(){
        return prodRep.findAll();
    }

    //ADICIONA E REMOVE REGISTRO
    public ResponseEntity<?> cadastrarAlterar(ProdutosModelo pm, String acao){

        if(pm.getName().equals("")){
            rm.setMensagem("O nome do produto é Obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);

         }else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é Obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
         }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ProdutosModelo>(prodRep.save(pm), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ProdutosModelo>(prodRep.save(pm), HttpStatus.OK);
            }
         }
    }
    //REMOVE REGISTRO
    public ResponseEntity<RespostaModelo> remover(Long codigo){
            prodRep.deleteById(codigo);
            rm.setMensagem("O produto foi removido com sucesso");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }

    

}
