package com.api.parkingcontrol.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cadastro-usuario")
@NoArgsConstructor
@AllArgsConstructor
public class CadastroUsuario {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
    private String senha;

	public String toString(){
		return "Id: " + id +
				",\nName: " + name +
				",\nSenha: " + senha;
	}
    
}
