package Controller;

import Conector.FilmeConector;
import java.util.ArrayList;
import model.Filme;

public class FilmeController{
    public boolean cadastrarFilme(String titulo, String genero, String sinopse, Integer duracao){
        if(titulo !=null && titulo.length() > 0 && genero !=null && genero.length() > 0 && sinopse !=null && sinopse.length() > 0 && duracao > 0){
            Filme filme = new Filme(titulo,genero,sinopse,duracao);
            filme.cadastrarFilme(filme);
            return true;
        }
        return false;
    }
    
    public ArrayList<Filme> listarFilmes(String titulo){
        return new Filme().listarFilmes(titulo);
    }
    
    public ArrayList<Filme> listarTodosFilmes(){
        return new Filme().listarTodosFilmes();
    }
    
    public Filme obterFilmePorCodigo(int codFilme) {
         return new Filme().obterFilmePorCodigo(codFilme);
    }

}
