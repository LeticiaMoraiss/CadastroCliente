package View;

import Modelo.Cliente;
import Modelo.ClienteTable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaEditavel extends AbstractTableModel {

    private List<ClienteTable> dados = new ArrayList<>();
    private String[] colunas = {"Id", "Nome", "E-mail"};

    @Override
    public int getRowCount() {
        return dados.size(); //Retorna quantas linhas tem no array
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length; //retorna a qtd de colunas
    }

    @Override
    public String getColumnName(int index) {
        return colunas[index]; //retorna o nome da coluna na posição x
    }

    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        switch (indexColuna) {
            case 0:
                return dados.get(indexLinha).id;
            case 1:
                return dados.get(indexLinha).nome;
            case 2:
                return dados.get(indexLinha).email;
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                break;
            case 1:
                dados.get(linha).nome = (String) valor;
                break;
            case 2:
                dados.get(linha).email = (String) valor;
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void addLinha(ClienteTable c) {
        this.dados.add(c);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void limparTabela(){
        dados = new ArrayList<>();
    }
}
