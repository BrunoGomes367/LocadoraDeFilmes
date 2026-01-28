package Conector;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import model.Filme;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.ResultSet;

public class FilmeConector {
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

    public void cadastrarFilme(Filme filme) {
        final String query = "INSERT INTO filme (titulo, genero, sinopse, duracao) VALUES (?, ?, ?, ?)";

        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);

            PreparedStatement pstm = c.prepareStatement(query);

            pstm.setString(1, filme.getTitulo());
            pstm.setString(2, filme.getGenero());
            pstm.setString(3, filme.getSinopse());
            pstm.setInt(4, filme.getDuracao());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Filme> listarFilmes(String titulo){
        ArrayList<Filme> filmes = new ArrayList<Filme>();
        final String query = "select * from filme where titulo like ? order by titulo";
        
        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement pstm = c.prepareStatement(query);
            pstm.setString(1, "%" + titulo + "%");
            ResultSet rs = pstm.executeQuery();
            
            
                while(rs.next()){
                    Filme filme = new Filme();
                    filme.setCodFilme(rs.getInt("codigo"));
                    filme.setTitulo(rs.getString("titulo"));
                    filme.setGenero(rs.getString("genero"));
                    filme.setSinopse(rs.getString("sinopse"));
                    filme.setDuracao(rs.getInt("duracao"));
                    filmes.add(filme);
                }
            }catch (SQLException e) {
            e.printStackTrace();
        }
        return filmes;
    }
    public ArrayList<Filme> listarTodosFilmes(){
        ArrayList<Filme> allFilmes = new ArrayList<Filme>();
        final String query = "select * from filme";
        
        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
                while(rs.next()){
                    Filme filme = new Filme();
                    filme.setCodFilme(rs.getInt("codigo"));
                    filme.setTitulo(rs.getString("titulo"));
                    filme.setGenero(rs.getString("genero"));
                    filme.setSinopse(rs.getString("sinopse"));
                    filme.setDuracao(rs.getInt("duracao"));
                    allFilmes.add(filme);
                }
            }catch (SQLException e) {
            e.printStackTrace();
    } 
        return allFilmes;   
}
    public Filme obterFilmePorCodigo(int codFilme) {
        Filme filme = null;
        final String query = "SELECT * FROM filme WHERE codigo = ?"; 

        try (Connection c = DriverManager.getConnection(URL, USER, PASS); 
            PreparedStatement pstm = c.prepareStatement(query)) {

            pstm.setInt(1, codFilme);
            ResultSet rs = pstm.executeQuery();
 
            if (rs.next()) {
                filme = new Filme();
                filme.setCodFilme(rs.getInt("codigo"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(rs.getString("genero"));
                filme.setSinopse(rs.getString("sinopse"));
                filme.setDuracao(rs.getInt("duracao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filme; 
    }


}

