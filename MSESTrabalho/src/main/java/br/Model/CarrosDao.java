package br.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarrosDao {



public CarrosDao (){
}


public void insert(Carros carros) {
	Conexao c = Conexao.getInstance();
	Connection con = c.getConnection();
	
	try {
		PreparedStatement p = con.prepareStatement("insert into carros (Ano, Modelo) values (?,  ?)");
		p.setString(1, carros.getAno());
		p.setString(2, carros.getModelo());
		System.out.println(p);
		p.executeUpdate();
		System.out.println("Comando executado");
		p.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public ArrayList<Carros> selectAll(){
	Conexao c = Conexao.getInstance();
	Connection con = c.getConnection();
	ArrayList<Carros> lista = new ArrayList<Carros>();
	try {
		PreparedStatement p = con.prepareStatement("select * from carros");
		ResultSet r = p.executeQuery();			
		
		while (r.next()) {
			Integer id = r.getInt("id");
			String ano = r.getString("ano");
			String modelo = r.getString("modelo");
			Carros ca = new Carros(ano,modelo);
			ca.setId(id);
			lista.add(ca);
		}
		r.close();
		p.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lista;
}

public void removeCarros(Integer id) {
	Conexao c = Conexao.getInstance();
	Connection con = c.getConnection();
	
	try {
		PreparedStatement p = con.prepareStatement("delete from carros where ID = ?");
		p.setInt(1, id);
		System.out.println(p);
		p.executeUpdate();
		System.out.println("Comando executado");
		p.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//public void updateUser(Integer id, String newName) {
public void updateCarros(Carros updateCarros) {
	Conexao c = Conexao.getInstance();
	Connection con = c.getConnection();
	
	try {
		PreparedStatement p = con.prepareStatement("update carros set Ano = ?,  Modelo = ? where ID = ?");
		p.setString(1, updateCarros.getAno());
		p.setString(2, updateCarros.getModelo());
		p.setInt(3, updateCarros.getId());
		System.out.println(p);
		p.executeUpdate();
		System.out.println("Comando executado");
		p.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public Carros selectById(Integer id) {
	Conexao c = Conexao.getInstance();
	Connection con = c.getConnection();
	Carros ca = null;
	try {
		PreparedStatement p = con.prepareStatement("select * from carros where ID = ?");
		p.setInt(1, id);
		ResultSet r = p.executeQuery();			
		
		
		while (r.next()) {
			//Integer id2 = r.getInt("id");
			String ano = r.getString("ano");
			String modelo = r.getString("modelo");
			ca = new Carros(ano, modelo);
			ca.setId(id);
		}
		r.close();
		p.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ca;
}
}