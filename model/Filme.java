package model;

import Conector.FilmeConector;
import java.util.ArrayList;

public class Filme {
    private Integer codFilme;
    private String titulo;
    private String genero;
    private String sinopse;
    private Integer duracao;
    
    private ArrayList<Item> itens = new ArrayList<Item>();

    public Filme(String titulo, String genero, String sinopse, Integer duracao){
        this.titulo = titulo;
        this.genero = genero;
        this.sinopse = sinopse;
        this.duracao = duracao;
    }

    public Filme() {
        
    }
    
    public Integer getCodFilme() {
        return codFilme;
    }

    public void setCodFilme(Integer codFilme) {
        this.codFilme = codFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
    
    public void cadastrarFilme(Filme filme){ // método que salva no banco de dados
        new FilmeConector().cadastrarFilme(filme);
    }
    
    public ArrayList<Filme> listarFilmes(String titulo){
        return new FilmeConector().listarFilmes(titulo);
    }
    
    public ArrayList<Filme> listarTodosFilmes(){
        return new FilmeConector().listarTodosFilmes();
    }
    
    public Filme obterFilmePorCodigo(int codFilme){
        return new FilmeConector().obterFilmePorCodigo(codFilme);
    }
}
