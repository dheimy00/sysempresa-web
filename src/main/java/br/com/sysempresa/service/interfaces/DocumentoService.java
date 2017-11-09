package br.com.sysempresa.service.interfaces;

import java.util.List;

import br.com.sysempresa.model.Documento;

public interface DocumentoService {

	Documento findById(Long id);
	
    Documento findByNome(String nome);

	void salvarDocumento(Documento documento) ;
	
	void alterarDocumento(Documento  documento);
	
	List<Documento> listarDocumento();	
	
	void excluirDocumento(Long id) ;
	
	boolean isDocumentoExiste(Documento documento);

}
