package br.com.gerenciador.jogos.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class ConnectionFactory {

	public Connection getConnection() {
		try {
			
			//Necessário por estar usando Tomcat 9: http://bit.ly/18BpDfG
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/gerenciador_jogos", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
