package model;

import Conector.ItemConector;
import java.util.ArrayList;

public class Item {
    private Integer codItem;
    private Integer codFilme;
    private Integer codCliente;
    private double preco;
    private String tipo;
    private String dataLocacao;      
    private Filme filme;
    private Cliente cliente;

    public Item() {
        
    }

    public Item(Integer codFilme, Integer codCliente, double preco, String tipo, String dataLocacao) {
        this.codFilme = codFilme;
        this.codCliente = codCliente;
        this.preco = preco;
        this.tipo = tipo;
        this.dataLocacao = dataLocacao;
    }
    
    public void setCodItem(Integer codItem) {
        this.codItem = codItem;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public void setCodFilme(Integer codFilme) {
        this.codFilme = codFilme;
    }

    public Integer getCodItem() {
        return codItem;
    }

    public double getPreco() {
        return preco;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public Integer getCodFilme() {
        return codFilme;
    }

    public Filme getFilme() {
        return filme;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
       
    public void cadastrarItem(Item item){
        new ItemConector().cadastrarItem(item);
    }
    
    public ArrayList<Item> listarItens(String titulo){
        return new ItemConector().listarItens(titulo);
    }
    
    public ArrayList<Item> listarTodosItens(){
        return new ItemConector().listarTodosItens();
    }
}
