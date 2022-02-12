package br.Model;

public class Carros {

private Integer id;
private String ano;
private String modelo;

public Carros(String ano, String modelo) {
	this.ano = ano;
	this.modelo = modelo;
}


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getAno() {
	return ano;
}
public void setAno(String ano) {
	this.ano = ano;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}

public String toString() {
	return this.id + " - " + this.ano + " - " + this.modelo;
}
}
