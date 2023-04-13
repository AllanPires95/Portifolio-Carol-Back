package com.allan.portifoliocarol.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // indica que a classe será utilizada para gerar uma tabela no banco de dados 
@Table(name = "tb_postagens") 	//indica o nome da tabela 
public class Postagem {

	@Id //Primary Key da postagens
	@GeneratedValue(strategy = GenerationType.IDENTITY) //A PK é gerada pelo Spring Data JPA, strategy indica a forma que será gerada, identity = PK vai ser gerada pela DB pelo auto-incremento, gerando um valor número a partir de 1.	
	private long id;
	
	@NotBlank(message = "O título é obrigatório!") //Não permite o atributo ser nulo ou conter apenas espaços em branco
	@Size(min = 5, max = 100, message = "O título deve conter entre 5 e 100 caracteres") //Size define o tamanho 
	private String titulo;
	
	@NotBlank(message = "O texto é obrigatório!")
	@Size(min = 5, max = 1000, message = "O texto deve conter entre 5 e 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp //O spring pega a data do sistema operacional
	private LocalDateTime data;
	
	@ManyToOne //indica que será N:1
	@JsonIgnoreProperties("postagem") //Interrompe a repetição, ignorando o Objeto da classe postagem
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTítulo() {
		return titulo;
	}

	public void setTítulo(String título) {
		this.titulo = título;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
