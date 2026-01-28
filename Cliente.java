package model;

import Conector.ClienteConector;
import java.util.ArrayList;
import java.util.Date;

public class Cliente {
    private Integer codCliente;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String dtNascimento;
    
    private ArrayList<Item> itens = new ArrayList<Item>();

    public Cliente(String nome, String cpf, String email, String endereco, String dtNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.dtNascimento = dtNascimento;
    }

    public Cliente() {
        
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
    
    public void cadastrarCliente(Cliente cliente){ // método que salva no banco de dados
        new ClienteConector().cadastrarCliente(cliente);
    }
    
    public ArrayList<Cliente> listarClientes(String cpf){
        return new ClienteConector().listarClientes(cpf);
    }
    
    public ArrayList<Cliente> listarTodosClientes(){
        return new ClienteConector().listarTodosClientes();
    }
    
    public Cliente obterCPFPorCodigo(int codCliente){
        return new ClienteConector().obterCPFPorCodigo(codCliente);
    }
}
