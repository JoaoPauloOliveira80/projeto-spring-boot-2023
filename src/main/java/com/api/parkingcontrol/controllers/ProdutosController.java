package com.api.parkingcontrol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.models.ProdutosModelo;
import com.api.parkingcontrol.models.RespostaModelo;
import com.api.parkingcontrol.repositores.ProdutosRepository;
import com.api.parkingcontrol.services.ProdutoService;


@Controller
@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutosController {
    @Autowired
    private ProdutosRepository prodRep;
    
    @Autowired
    private ProdutoService ps;

    public boolean verificarPorId(Long id) {
		return prodRep.existsById(id);
	}

    @GetMapping("/listar")
    public Iterable<ProdutosModelo> listar(){
        return ps.listar();
    }
    
    @GetMapping("/search/{id}")
    public String search(@PathVariable Long id){
        if(verificarPorId(id) != true){
            return "Registro não encontrado...";
        }else{
            return ps.search(id);
        }
       
     }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutosModelo pm){

        return ps.cadastrarAlterar(pm, "alterar");

    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutosModelo pm){

        return ps.cadastrarAlterar(pm, "cadastrar");

    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long codigo){
        return ps.remover(codigo);
    }

    

    @GetMapping("/bemVindo")
    public String lista(){return "Ola mundo!";}

    

}
