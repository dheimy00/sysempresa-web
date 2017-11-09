//package br.com.sysempresa.service.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import br.com.sysempresa.model.Documento;
//import br.com.sysempresa.repositories.DocumentoRepositorio;
//import br.com.sysempresa.service.interfaces.DocumentoService;
//
//@Service("documentoService")
//@Transactional
//public class DocumentoServiceImpl implements DocumentoService {
//	
//	@Autowired
//	private DocumentoRepositorio documentoRepositorio;
//
//	@Override
//	public Documento findById(Long id) {
//		return documentoRepositorio.findOne(id);
//	}
//
//	@Override
//	public Documento findByNome(String nome) {	
//		return documentoRepositorio.findByNome(nome);
//	}
//
//	@Override
//	public void salvarDocumento(Documento documento) {
//		documentoRepositorio.save(documento);
//		
//	}
//
//	@Override
//	public void alterarDocumento(Documento documento) {
//		documentoRepositorio.save(documento);
//		
//	}
//
//	@Override
//	public List<Documento> listarDocumento() {		
//		return documentoRepositorio.findAll();
//	}
//
//	@Override
//	public void excluirDocumento(Long id) {
//		documentoRepositorio.delete(id);
//		
//	}
//
//	@Override
//	public boolean isDocumentoExiste(Documento documento) {
//		
//		return documentoRepositorio.findByNome(documento.getNome()) != null; 
//	}
//}