package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection(); //criando a conexao com o banco
	 
	public void cadastrar(Usuario usu) {
		
			
		//Montando a String sql para ser enviada
		String sql = "insert into usuario (nome, login, senha) values (?, ?, ?)";
		//Uso de parametros ? são variaveis que serão substituidas pelas
		//variaveis dos objetos passados como parametro
		
		//criando o statement (substitui os pontos ? na string
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome()); //substitui o ?
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			
			//Executando o comando sql no banco
			preparador.execute();
			
			//Fechando o statement
			preparador.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void alterar(Usuario usu) {
		//Montando a String sql para ser enviada
				String sql = "update usuario set nome=?, login=?, senha=? where id=? ";
				//Uso de parametros ? são variaveis que serão substituidas pelas
				//variaveis dos objetos passados como parametro
				
				//criando o statement (substitui os pontos ? na string
				try (PreparedStatement preparador = con.prepareStatement(sql)) { //try with resource só pra testar
					
					
					preparador.setString(1, usu.getNome()); //substitui o ?
					preparador.setString(2, usu.getLogin());
					preparador.setString(3, usu.getSenha());
					preparador.setInt(4,usu.getId());
					
					//Executando o comando sql no banco
					preparador.execute();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	public void excluir(Usuario usu) {
		//Montando a String sql para ser enviada
		String sql = "delete from usuario where id=? ";
		//Uso de parametros ? são variaveis que serão substituidas pelas
		//variaveis dos objetos passados como parametro
		
		//criando o statement (substitui os pontos ? na string
		try (PreparedStatement preparador = con.prepareStatement(sql)) { //try with resource só pra testar
			
			
			preparador.setInt(1,usu.getId());
			
			//Executando o comando sql no banco
			preparador.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
