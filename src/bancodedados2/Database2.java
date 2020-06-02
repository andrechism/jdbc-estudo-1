package bancodedados2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database2 {
    public void menu(String address, String user, String password, String operation){
        try {
            Connection connection = DriverManager.getConnection(address, user, password);
            Database2 db = new Database2();
            
            if(operation.equalsIgnoreCase("update")) db.update(connection);
            if(operation.equalsIgnoreCase("print")) db.examplePrint(connection);
            if(operation.equalsIgnoreCase("readestado")) db.readEstado(connection);
            if(operation.equalsIgnoreCase("delete")) db.delete(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Database2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(Connection connection) throws SQLException {
        int codigo = 4080;
        String nomeCidade = "Exu";
        String codigoPais = "BRA";
        String estado = "Pernambuco";
        int populacao = 4000;
        
        String sqlInsert = "INSERT INTO City (ID, Name, CountryCode, District, Population) "
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
    
    public void readEstado(Connection connection) throws SQLException {
        String sql = "SELECT District estado, count(*) quant_cidades "
                + "FROM city "
                + "WHERE CountryCode = 'BRA' "
                + "GROUP BY District "
                + "ORDER BY District ASC ";
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Estado> listaEstados = new ArrayList<Estado>();
        
        while(rs.next()){
            Estado estado = new Estado();
            estado.setNome(rs.getString("estado"));
            estado.setQuantidadeCidades(rs.getInt("quant_cidades"));
            
            listaEstados.add(estado);
        }
        
        rs.close();
        stmt.close();
        connection.close();
        
        for(Estado estado : listaEstados){
            System.out.println("Estado: " + estado.getNome() + "      Quantidade de Cidades: " + estado.getQuantidadeCidades());
        }
    }
    
    public void update(Connection connection) throws SQLException {
        String novoNome = "Rio Claro";
        int novaPopulacao = 250000;
        int id = 4080;
        
        String sqlUpdate = "UPDATE city SET Name = ?, Population = ? "
                + "WHERE ID = ? ";
        
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
        String sqlDelete = "DELETE FROM city WHERE ID = ? ";
        
        PreparedStatement stmt = connection.prepareStatement(sqlDelete);
        stmt.setInt(1, id);
        stmt.execute();
        
        stmt.close();
        connection.close();
    }
    
    public void examplePrint(Connection connection) throws SQLException {   
        /*String sql = "SELECT District estado, count(*) quant_cidades "
                + "FROM city "
                + "WHERE CountryCode = 'BRA' "
                + "GROUP BY District "
                + "ORDER BY District ASC ";*/
        String sql = "SELECT * FROM City WHERE ID = 4080";
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            //System.out.println(rs.getString("estado") + "  ------------------  " + rs.getInt("quant_cidades"));
            System.out.println("ID: " + rs.getInt("ID") + " Name: " + rs.getString("Name") + " País: " + rs.getString("CountryCode") + " Estado: " + rs.getString("District") + " População: " + rs.getInt("Population"));
        }
        
        rs.close();
        stmt.close();
        connection.close();
    }
}