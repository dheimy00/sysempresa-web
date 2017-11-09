package br.com.sysempresa.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sysempresa.model.Contato;
import br.com.sysempresa.model.Usuario;
import br.com.sysempresa.service.interfaces.UsuarioService;
import br.com.sysempresa.util.ErrorType;

@RestController
@RequestMapping("/api")
public class RestUsuarioController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestUsuarioController.class);

	@Autowired
	private UsuarioService usuarioService;
	
	// -------------------Salvando usuário-------------------------------------------
	
		@RequestMapping(value = "/usuario/", method = RequestMethod.POST)
		public ResponseEntity<?> salvarUsuario(@RequestBody Usuario usuario, UriComponentsBuilder ucBuilder) {
			logger.info("Salvando usuario : {}", usuario);
			
			if(usuarioService.isUsuarioExist(usuario)){
				logger.error("Não foi possível salvar. Um usuário com cpf {} já existe", usuario.getCpf());
				return new ResponseEntity(new ErrorType("Não foi possível salvar. Um usuário com cpf " + 
				usuario.getCpf() + " já existe."),HttpStatus.CONFLICT);
			}
			usuarioService.salvarUsuario(usuario);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/api/usuario/{id}").buildAndExpand(usuario.getId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
	
		// -------------------Recuperar usuário usuário ------------------------------------------


		@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> getUsuario(@PathVariable("id") long id) {
			logger.info("Buscando o usuário com id {}", id);
			Usuario usuario  = usuarioService.findById(id);
			if (usuario == null) {
				logger.error("Usuário com id {} não encontra.", id);
				return new ResponseEntity(new ErrorType("Usuário com id " + id 
						+ " não encontra"), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
	
		

		// -------------------Recuperar todos os usuários---------------------------------------------


		@RequestMapping(value = "/usuario/", method = RequestMethod.GET)
		public ResponseEntity<List<Usuario>> listarUsuario() {
		List<Usuario> usuarios = usuarioService.listarUsuario();
			
			if (usuarios.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		}
	
		// ------------------- Atualizar usuário ------------------------------------------------

		@RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> alterarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
			logger.info("Atualizando o usuário com id {}", id);

			Usuario atualUsuario = usuarioService.findById(id);

			if (atualUsuario == null) {
				logger.error("Não foi possível atualizar. Usuário com id {} não encontra.", id);
				return new ResponseEntity(new ErrorType("Não foi possível atualizar. Usuário com id " + id + " não encontra."),
						HttpStatus.NOT_FOUND);
			}

			atualUsuario.setNome(usuario.getNome());
			atualUsuario.setCpf(usuario.getCpf());

			usuarioService.alterarUsuario(atualUsuario);
			return new ResponseEntity<Usuario>(atualUsuario, HttpStatus.OK);
		}
		
		
		// ------------------- Excluido usuário-----------------------------------------

		@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> excluirUsuario(@PathVariable("id") long id) {
			logger.info("Buscando & Excluido o usuário com id {}", id);

			Usuario usuario = usuarioService.findById(id);
			if (usuario == null) {
				logger.error("Não foi possível excluir. Usuário com id {} não encontra.", id);
				return new ResponseEntity(new ErrorType("Não foi possível excluir. Usuário com id " + id + " não encontra."),
						HttpStatus.NOT_FOUND);
			}
			usuarioService.excluirUsuario(id);
			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
		}
	


}
