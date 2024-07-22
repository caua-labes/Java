package com.postgre.api.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Produtos")
public class Produto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String descricao;
private long quantidade;
private double valor;
@ManyToOne
@JoinColumn(name = "categoria_id")
private Categoria categoria;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public long getQuantidade() {
	return quantidade;
}
public void setQuantidade(long quantidade) {
	this.quantidade = quantidade;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}
public Categoria getCategoria() {
	return categoria;
}
public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}

public Produto() {};
public Produto(Long id,String descricao,Long quantidade, Double valor,Categoria categoria) {
	this.id = id;
	this.descricao = descricao;
	this.quantidade = quantidade;
	this.valor = valor;
	this.categoria = categoria;
}



}
