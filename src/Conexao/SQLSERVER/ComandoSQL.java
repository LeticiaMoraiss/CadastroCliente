package Conexao.SQLSERVER;

import Modelo.Cliente;
import Modelo.ClienteTable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

public class ComandoSQL extends Conexao {

    public ComandoSQL() throws Exception {
    }

    String INSERT = "INSERT INTO CLIENTE (Nome, Tel_Residencial, Tel_Comercial, Tel_Celular, Email) VALUES (?,?,?,?,?)";
    String UPDATE = "UPDATE CLIENTE SET Nome=?, Tel_Residencial=?, Tel_Comercial=?, Tel_Celular=?, Email=? WHERE Id=?";
    String DELETE = "DELETE FROM CLIENTE WHERE Id =?";
    String LIST = "SELECT * FROM CLIENTE";
    String LISTBYID = "SELECT * FROM CLIENTE WHERE Id=?";
    String ULTIMOID = "SELECT IDENT_CURRENT( 'Cliente' ) + 1 AS Id"; //Pega o Id do proximo cliente cadastrado
    String LISTARTABELA = "SELECT Id, Nome, Email FROM CLIENTE";

    public void inserir(Cliente cliente) throws Exception {
        if (cliente != null) {

            PreparedStatement ps = getConexao().prepareStatement(INSERT);
            ps.setString(1, cliente.nome);
            ps.setString(2, cliente.tel_Residencial);
            ps.setString(3, cliente.tel_Comercial);
            ps.setString(4, cliente.tel_Celular);
            ps.setString(5, cliente.email);
            int registro = ps.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao adicionar cliente!");
            }
            ps.close();
        } else {
            JOptionPane.showMessageDialog(null, "Os dados do cleinte esta vazio!");
        }
    }

    public String ultimoId() throws Exception {
        String id = "";
        PreparedStatement ps = getConexao().prepareStatement(ULTIMOID);
        ResultSet resultado = ps.executeQuery();
        while (resultado.next()) {
            id = resultado.getString(1);
        }
        ps.close();
        return id;
    }

    public void deletar(int id) throws Exception {
        PreparedStatement ps = getConexao().prepareStatement(DELETE);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }

    public void update(Cliente cliente) throws Exception {
        if (cliente != null) {
            PreparedStatement ps = getConexao().prepareStatement(UPDATE);
            ps.setString(1, cliente.nome);
            ps.setString(2, cliente.tel_Residencial);
            ps.setString(3, cliente.tel_Comercial);
            ps.setString(4, cliente.tel_Celular);
            ps.setString(5, cliente.email);
            ps.setInt(6, cliente.id);
            ps.executeUpdate();
            ps.close();

        } else {
            JOptionPane.showMessageDialog(null, "Os dados do cliente esta vazio!");
        }

    }

    public Cliente listarPorId(String id) throws Exception {
        Cliente cliente = new Cliente();
        PreparedStatement ps = getConexao().prepareStatement(LISTBYID);
        ps.setString(1, id);
        ResultSet resultado = ps.executeQuery();

        while (resultado.next()) {
            cliente.id = resultado.getInt(1);
            cliente.nome = resultado.getString(2);
            cliente.tel_Residencial = resultado.getString(3);
            cliente.tel_Comercial = resultado.getString(4);
            cliente.tel_Celular = resultado.getString(5);
            cliente.email = resultado.getString(6);
        }
        ps.close();
        resultado.close();
        return cliente;
    }

    public List<Cliente> listarClientes() throws Exception {
        PreparedStatement ps = getConexao().prepareStatement(LIST);
        ResultSet resultado = null;
        resultado = ps.executeQuery();
        List<Cliente> lstClientes = new ArrayList<>();

        while (resultado.next()) {
            Cliente cliente = new Cliente();
            cliente.id = resultado.getInt("Id");
            cliente.nome = resultado.getString("Nome");
            cliente.tel_Residencial = resultado.getString("Tel_Residencial");
            cliente.tel_Comercial = resultado.getString("Tel_Comercial");
            cliente.tel_Celular = resultado.getString("Tel_Celular");
            cliente.email = resultado.getString("Email");
            lstClientes.add(cliente);
        }
        ps.close();
        resultado.close();
        return lstClientes;
    }

    public List<ClienteTable> listarTabela() throws Exception {
        PreparedStatement ps = getConexao().prepareStatement(LISTARTABELA);
        ResultSet resultado = null;
        resultado = ps.executeQuery();
        List<ClienteTable> lstClientes = new ArrayList<>();

        while (resultado.next()) {
            ClienteTable cliente = new ClienteTable();
            cliente.id = resultado.getInt("Id");
            cliente.nome = resultado.getString("Nome");
            cliente.email = resultado.getString("Email");
            lstClientes.add(cliente);
        }
        ps.close();
        resultado.close();
        return lstClientes;
    }
}
