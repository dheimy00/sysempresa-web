package br.com.sysempresa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 463678765427239741L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,length = 50)
	private String nome;
	
	@Column(nullable=false,length = 50)
	private String cpf;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Contato contato;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<Documento> documento = new HashSet<Documento>();

	
	public Usuario(){}
	
	
	
	public Usuario(Long id, String nome, String cpf, Contato contato, Set<Documento> documento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.contato = contato;
		this.documento = documento;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
		
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public Set<Documento> getDocumento() {
		return documento;
	}

	public void setDocumento(Set<Documento> documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", contato=" + contato + ", documento="
				+ documento + "]";
	}
	
	

}
