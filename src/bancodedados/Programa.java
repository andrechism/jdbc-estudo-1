/*
package bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Programa {
	
	public static void main(String[] args) {	
		try {
			Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost/world?useTimezone=true&serverTimezone=UTC", "root", "");
			
			new Programa().select1(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void select1(Connection connection) throws SQLException {
		String sql = "select District estado, count(*) quant_cidades\r\n" + 
				"from city\r\n" + 
				"where CountryCode = 'BRA'\r\n" + 
				"group by District\r\n" + 
				"order by District asc;";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		List<Estado> listaEstados = new ArrayList<Estado>();
		while(rs.next()) {
			Estado estado = new Estado();
			estado.setNome(rs.getString("estado"));
			estado.setQuantidadeCidades(rs.getInt("quant_cidades"));
			listaEstados.add(estado);
		}
		
		rs.close();
		stmt.close();
		connection.close();
		
		for(Estado estado : listaEstados) {
			System.out.println(estado.getNome() + " - Quant. Cidades: " + estado.getQuantidadeCidades());
		}
	}
	
	public void select2(Connection connection) throws SQLException {
		String continente = "South America";
		
		String sql = "select *\r\n" + 
				"from country\r\n" + 
				"where Continent = ?;";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, continente);
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("Code") + " - " + rs.getString("Name"));
		}
		
		rs.close();
		stmt.close();
		connection.close();
	}
	
	public void insert(Connection connection) throws SQLException {
		int codigo = 4080;
		String nomeCidade = "Exu";
		String codigoPais = "BRA";
		String estado = "Pernambuco";
		int populacao = 4000;
		
		String sqlInsert = "INSERT INTO city (ID, Name, CountryCode, District, Population) "
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sqlInsert);
		stmt.setInt(1, codigo);
		stmt.setString(2, nomeCidade);
		stmt.setString(3, codigoPais);
		stmt.setString(4, estado);
		stmt.setInt(5, populacao);
		stmt.execute();
		
		stmt.close();
		connection.close();
	}
	
	public void update(Connection connection) throws SQLException {
		String novoNome = "Rio Claro";
		int novaPopulacao = 250000;
		int id = 4080;
		
		String sqlUpdate = "UPDATE city SET Name = ?, Population = ? "
				+ "WHERE ID = ?";
		PreparedStatement stmt = connection.prepareStatement(sqlUpdate);
		stmt.setString(1, novoNome);
		stmt.setInt(2, novaPopulacao);
		stmt.setInt(3, id);
		
		stmt.execute();
		
		stmt.close();
		connection.close();
	}
	
	public void delete(Connection connection) throws SQLException {
		int id = 4080;
		
		String sqlDelete = "DELETE FROM city WHERE ID = ?";
		PreparedStatement stmt = connection.prepareStatement(sqlDelete);
		stmt.setInt(1, id);
		
		stmt.execute();
		
		stmt.close();
		connection.close();
		System.out.println("Deu certo");
	}

}
*/