package br.com.sysempresa.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="documento")
public class Documento implements Serializable{

	private static final long serialVersionUID = -5581214753355428017L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,length=100) 
	private String nome; 
	
	@Column(nullable=false,length=255)
	private String descricao;
	
	@Lob @Basic(fetch = FetchType.LAZY)
    @Column(nullable=false)
    private byte[] conteudo;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	
	public Documento(){}
	
	public Documento(String nome, String descricao, byte[] conteudo, Usuario usuario) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.conteudo = conteudo;
		this.usuario = usuario;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "UsuarioDocumento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", conteudo="
				+ Arrays.toString(conteudo) + ", usuario=" + usuario + "]";
	}
	
	
	

}
