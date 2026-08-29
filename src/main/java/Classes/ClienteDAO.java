package Classes;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection conn;

    public ClienteDAO() {
        Conexao conect = new Conexao();
        this.conn = conect.getConexao();
    }

    public int salvar(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nome, CPF, nascimento, telefone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getCPF());
            String dataNasc = cliente.getDataNasc();
            if (dataNasc != null && dataNasc.contains("/")) {
                String[] partes = dataNasc.split("/");
                dataNasc = partes[2] + "-" + partes[1] + "-" + partes[0];
            }
            st.setString(3, dataNasc);
            st.setString(4, cliente.getTelefoneCli());
            return st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar cliente: " + ex.getMessage());
            return 0;
        }
    }

    public ResultSet listarClientes() {
        String sql = "SELECT * FROM Cliente ORDER BY nome";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            return st.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erro ao listar clientes: " + ex.getMessage());
            return null;
        }
    }
}
