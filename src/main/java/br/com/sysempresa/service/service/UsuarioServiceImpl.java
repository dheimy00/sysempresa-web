package br.com.sysempresa.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sysempresa.model.Usuario;
import br.com.sysempresa.repositories.UsuarioRepositorio;
import br.com.sysempresa.service.interfaces.UsuarioService;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public Usuario findById (Long id) {
		return (Usuario) usuarioRepositorio.findOne(id);
	}
	
	@Override
	public Usuario findByCpf (String cpf) {
		return usuarioRepositorio.findByCpf(cpf);
	}
	
	
	@Override
	public void salvarUsuario(Usuario usuario) {
		usuarioRepositorio.save(usuario);
		
	}

	@Override
	public void alterarUsuario(Usuario usuario) {
		salvarUsuario(usuario);		
	}

	@Override
	public List<Usuario> listarUsuario() {
		return  usuarioRepositorio.findAll();		
	}


	@Override
	public void excluirUsuario(Long id) {
		usuarioRepositorio.delete(id);		
	}

	@Override
	public boolean isUsuarioExist(Usuario usuario) {
		
		return findByCpf(usuario.getCpf()) != null;
	}

}
