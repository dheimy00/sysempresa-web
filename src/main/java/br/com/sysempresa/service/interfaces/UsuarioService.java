package br.com.sysempresa.service.interfaces;

import java.util.List;

import br.com.sysempresa.model.Usuario;


public interface UsuarioService {

	Usuario findById(Long id);
	
	Usuario findByCpf(String cpf);

	void salvarUsuario(Usuario usuario) ;
	
	void alterarUsuario(Usuario usuario);
	
	List<Usuario> listarUsuario();	
	
	void excluirUsuario(Long id) ;
	
	boolean isUsuarioExist(Usuario usuario);
	
       
	    
}
