package Conexao.SQLSERVER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexao {

    private Connection conexao;

    public Conexao() throws Exception {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String url = "jdbc:jtds:sqlserver://localhost:1433/CadastroCliente";
        conexao = DriverManager.getConnection(url, "Leticia", "Trocar@123");
    }

    public Connection getConexao() {
        return conexao;
    }

}
