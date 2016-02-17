package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {

	testExcluir();

	}
	
	public static void testExcluir(){

		Usuario usu = new Usuario();
		//Criando um usuario
		usu.setId(5);
		
		
		//Criando um objeto que coloque o usuario dentro do banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu); // cadastrar  o usuario num banco de dados
		
		
	}
	
	
	public static void testAlterar(){

		Usuario usu = new Usuario();
		//Criando um usuario
		usu.setId(4);
		usu.setNome("Alberto Roberto");
		usu.setLogin("AR");
		usu.setSenha("7891");
		
		//Criando um objeto que coloque o usuario dentro do banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu); // cadastrar  o usuario num banco de dados
		
		
	}
	
	
	public static void cadastrar(){
		
		Usuario usu = new Usuario();
		//Criando um usuario
		usu.setNome("Vanessa");
		usu.setLogin("vv");
		usu.setSenha("789");
		
		//Criando um objeto que coloque o usuario dentro do banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu); // cadastrar  o usuario num banco de dados
		
	}

}
