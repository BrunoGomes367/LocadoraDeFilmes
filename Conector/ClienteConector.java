package Conector;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import model.Cliente;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteConector {
    static private String USER = "root";
    static private String PASS = "Copa2014*";
    static private String DATABASE = "locadora";
    static private String URL = "jdbc:mysql://localhost:3306/locadora?useSSL=false&serverTimezone=UTC";

    public void testaConnection() {

        try (Connection c = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("Conexao estabelecida");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        final String query = "INSERT INTO cliente (nome, cpf, email, endereco, dtNascimento) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);

            PreparedStatement pstm = c.prepareStatement(query);

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getEndereco());
            pstm.setString(5, cliente.getDtNascimento());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Cliente> listarClientes(String cpf){
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        final String query = "select * from cliente where cpf like '%" + cpf + "%' order by codigo";
        
        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement pstm = c.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            Cliente cliente = new Cliente();
            
                while(rs.next()){
                    cliente.setCodCliente(rs.getInt("codigo"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setDtNascimento(rs.getString("dtNascimento"));
                    clientes.add(cliente);
                }
            }catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    public ArrayList<Cliente> listarTodosClientes(){
        ArrayList<Cliente> allClientes = new ArrayList<Cliente>();
        final String query = "select * from cliente";
        
        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
                while(rs.next()){
                    Cliente cliente = new Cliente();
                    cliente.setCodCliente(rs.getInt("codigo"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setDtNascimento(rs.getString("dtNascimento"));
                    allClientes.add(cliente);
                }
            }catch (SQLException e) {
            e.printStackTrace();
    } 
        return allClientes;   
}
    
    public Cliente obterCPFPorCodigo(int codCliente) {
        Cliente cliente = null;
        final String query = "SELECT * FROM cliente WHERE codigo = ?"; 

        try (Connection c = DriverManager.getConnection(URL, USER, PASS); 
            PreparedStatement pstm = c.prepareStatement(query)) {

            pstm.setInt(1, codCliente);
            ResultSet rs = pstm.executeQuery();
 
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setCodCliente(rs.getInt("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setDtNascimento(rs.getString("dtNascimento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente; 
    }
}
