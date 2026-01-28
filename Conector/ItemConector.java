package Conector;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import model.Item;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.ResultSet;
import model.Cliente;
import model.Filme;

public class ItemConector {
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

    public void cadastrarItem(Item item) {
        final String query = "INSERT INTO item (codigoFilme, codigoCliente, preco, tipo, dataLocacao) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);

            PreparedStatement pstm = c.prepareStatement(query);

            pstm.setInt(1, item.getCodFilme());
            pstm.setInt(2, item.getCodCliente());
            pstm.setDouble(3, item.getPreco());
            pstm.setString(4, item.getTipo());
            pstm.setString(5, item.getDataLocacao());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Item> listarItens(String titulo){
        ArrayList<Item> itens = new ArrayList<Item>();
        final String query = "SELECT item.codigo, item.preco, item.tipo, item.dataLocacao, filme.titulo, cliente.cpf FROM item JOIN filme ON filme.codigo = item.codigoFilme JOIN cliente ON cliente.codigo = item.codigoCliente WHERE filme.titulo like ? order by codigo";
        
        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement pstm = c.prepareStatement(query);
            pstm.setString(1, "%" + titulo + "%");
            ResultSet rs = pstm.executeQuery();                        
                       
                while(rs.next()){
                    Item item = new Item();
                    item.setCodItem(rs.getInt("codigo"));
                    item.setPreco(rs.getDouble("preco"));
                    item.setTipo(rs.getString("tipo"));
                    item.setDataLocacao(rs.getString("dataLocacao"));
                    
                    Filme filme = new Filme();
                    filme.setTitulo(rs.getString("titulo"));
                    item.setFilme(filme);
                    
                    Cliente cliente = new Cliente();
                    cliente.setCpf(rs.getString("cpf"));
                    item.setCliente(cliente);
                    
                    itens.add(item);
                }
            }catch (SQLException e) {
            e.printStackTrace();
        }
        return itens;
    }
    public ArrayList<Item> listarTodosItens(){
        ArrayList<Item> itens = new ArrayList<Item>();
        final String query = "SELECT item.codigo, item.preco, item.tipo, item.dataLocacao, filme.titulo, cliente.cpf FROM item JOIN filme ON filme.codigo = item.codigoFilme JOIN cliente ON cliente.codigo = item.codigoCliente order by codigo";
        
        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(query);                     
                       
                while(rs.next()){
                    Item item = new Item();
                    item.setCodItem(rs.getInt("codigo"));
                    item.setPreco(rs.getDouble("preco"));
                    item.setTipo(rs.getString("tipo"));
                    item.setDataLocacao(rs.getString("dataLocacao"));
                    
                    Filme filme = new Filme();
                    filme.setTitulo(rs.getString("titulo"));
                    item.setFilme(filme);
                    
                    Cliente cliente = new Cliente();
                    cliente.setCpf(rs.getString("cpf"));
                    item.setCliente(cliente);
                    
                    itens.add(item);
                }
            }catch (SQLException e) {
            e.printStackTrace();
        }
        return itens;
    }

}
