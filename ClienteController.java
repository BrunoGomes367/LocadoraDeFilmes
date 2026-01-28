package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Cliente;

public class ClienteController {

    public boolean cadastrarCliente(String nome, String cpf, String email, String endereco, String dtNascimento) throws ParseException {
        if (nome != null && nome.length() > 0 && validarCpf(cpf) && email != null && email.length() > 0 && endereco != null && endereco.length() > 0 && validarData(dtNascimento)) {            
            Cliente cliente = new Cliente(nome, cpf, email, endereco, dtNascimento);
            cliente.cadastrarCliente(cliente);
            return true;
        }
        return false;
    }

    public boolean validarCpf(String cpf) {
        for (int i = 0; i < cpf.length(); i++) { // criando uma icógnita para verificar cada posição de um digíto no meu cpf
            if (!(Character.isDigit(cpf.charAt(i)))) { // se o caracter em sua posição não for um dígito
                if (!(i == 3 || i == 7 || i == 11)) { // com exclusão das posições em que se referem aos . ou -
                    return false; // CPF não é válido por conter um caracter que não é um dígito
                }                
            }
        } return true;
    } 
    public boolean validarData(String data) {
        for (int i = 0; i < data.length(); i++) { // criando uma icógnita para verificar cada posição de um digíto na minha data
            if (!(Character.isDigit(data.charAt(i)))) { // se o caracter em sua posição não for um dígito
                if (!(i == 2 || i == 5 )) { // com exclusão das posições em que se referem às /
                    return false; // Data não é válida por conter um caracter que não é um dígito
                }                
            }
        } return true;
    }
    
    public Cliente obterCPFPorCodigo(int codCliente){
        return new Cliente().obterCPFPorCodigo(codCliente);
    }
    
    public ArrayList<Cliente> listarClientes(String cpf){
        return new Cliente().listarClientes(cpf);
    }
    
    public ArrayList<Cliente> listarTodosClientes(){
        return new Cliente().listarTodosClientes();
    }
}
