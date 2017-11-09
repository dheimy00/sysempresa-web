package br.com.sysempresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import br.com.sysempresa.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
	
	Usuario findByCpf(String cpf);
	
}
