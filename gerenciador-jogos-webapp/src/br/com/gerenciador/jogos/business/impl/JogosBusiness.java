package br.com.gerenciador.jogos.business.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciador.jogos.business.IJogosBusiness;
import br.com.gerenciador.jogos.data.ConnectionFactory;
import br.com.gerenciador.jogos.domain.entities.Jogo;

@Service
public class JogosBusiness implements IJogosBusiness {

	@Autowired
	private ConnectionFactory _fabricaConexao;

	@Override
	public boolean cadastrarJogo(Jogo jogo) {

		try (Connection conexao = _fabricaConexao.getConnection()) {

			String sql = "INSERT INTO jogos (nome) VALUES (?)";

			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, jogo.getNome());

			statement.execute();
			return statement.getUpdateCount() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Jogo> listaJogos() {
		
		try(Connection conn = _fabricaConexao.getConnection()){
			String sql = "SELECT id, nome FROM jogos";
			
			PreparedStatement stmt =  conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			List<Jogo> lista = new ArrayList<Jogo>();
			while(rs.next()) {
				Jogo j = new Jogo();
				j.setId(rs.getInt(1));
				j.setNome(rs.getString("nome"));
				
				lista.add(j);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
