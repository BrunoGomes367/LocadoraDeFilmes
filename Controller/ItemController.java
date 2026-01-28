package Controller;

import java.util.ArrayList;
import model.Item;

public class ItemController {
    public boolean cadastrarItem(Integer codFilme, Integer codCliente, double preco, String tipo, String dataLocacao){
        if(codFilme !=null && codFilme > 0 && codCliente !=null && codCliente > 0 && preco > 0 && tipo !=null && tipo.length() > 0 && validarData(dataLocacao)){
            Item item = new Item(codFilme, codCliente, preco, tipo, dataLocacao);
            item.cadastrarItem(item);
            return true;
        }
        return false;
    }
    
    public boolean validarData(String dataLocacao) {
        for (int i = 0; i < dataLocacao.length(); i++) { // criando uma icógnita para verificar cada posição de um digíto na minha data
            if (!(Character.isDigit(dataLocacao.charAt(i)))) { // se o caracter em sua posição não for um dígito
                if (!(i == 2 || i == 5 )) { // com exclusão das posições em que se referem às /
                    return false; // Data não é válida por conter um caracter que não é um dígito
                }                
            }
        } return true;
    }
    
    public ArrayList<Item> listarItens(String titulo){
        return new Item().listarItens(titulo);
    }
    
    public ArrayList<Item> listarTodosItens(){
        return new Item().listarTodosItens();
    }
}
