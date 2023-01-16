package com.api.parkingcontrol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.models.CadastroUsuario;
import com.api.parkingcontrol.repositores.CadastroRepository;

@RestController
@RequestMapping("/cadastro-user")
public class CadastroController {

    @Autowired
    CadastroRepository cadastroRep;

    public boolean verificarPorId(Long id) {
		return cadastroRep.existsById(id);
	}

    @GetMapping("/getLista")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<CadastroUsuario> getList(){
        return cadastroRep.findAll();
    }

    @PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public String addPerfil(@RequestBody CadastroUsuario user) {

		cadastroRep.save(user);
		return "Inserido com sucesso id: ";

	}

    @GetMapping("/buscarId/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String getId(@PathVariable Long id) {

		if (verificarPorId(id) != true) {
			return "Registro não encontrado...";
		} else {

			CadastroUsuario user = cadastroRep.findById(id).get();

			return "" + user;
		}
	}

    @DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String deletePerfil(@PathVariable Long id) {

		if (verificarPorId(id) != true) {
			return "Registro não encontrado";
		} else {
			cadastroRep.deleteById(id);
			return "Deletado com sucesso id: " + id;
		}

	}

    @PutMapping("/atualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String updatePerfil(@PathVariable Long id, @RequestBody CadastroUsuario user) {

		if (verificarPorId(id) != true) {
			return "Registro não encontrado";
		} else {
			CadastroUsuario newObj = cadastroRep.findById(id).get();
			
			newObj.setName(user.getName());
            newObj.setSenha(user.getSenha());
			/*newObj.setNomeProduto(anuncio.getNomeProduto());
			newObj.setPreco(anuncio.getPreco());
			newObj.setEndereco(anuncio.getEndereco());
			newObj.setNumero(anuncio.getNumero());
			newObj.setCidade(anuncio.getCidade());
			newObj.setEstado(anuncio.getEstado());
			newObj.setNota(anuncio.getNota());*/
			cadastroRep.save(newObj);
			return "Atualizado com sucesso id: " + id;
		}
	}
}
