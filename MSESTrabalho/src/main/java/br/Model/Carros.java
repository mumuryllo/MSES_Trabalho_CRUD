package br.Model;

public class Carros {

	private int id;
	private String ano;
	private String modelo;
	
	
	public Carros(int id) {
		super();
		this.id = id;
	}
	    public Carros(String ano, String modelo) {
		super();
		this.ano = ano;
		this.modelo = modelo;
	}
		public int getId() {
			return id;
		}
		public void setId(int id) {
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
	    
	    

}
