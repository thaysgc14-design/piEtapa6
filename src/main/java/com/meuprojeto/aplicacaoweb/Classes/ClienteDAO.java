package com.meuprojeto.aplicacaoweb.Classes;

import com.meuprojeto.aplicacaoweb.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public int salvar(Cliente cliente) {

        String sql = "INSERT INTO Cliente (nome, CPF, nascimento, telefone) VALUES (?, ?, ?, ?)";

        try (Connection con = new Conexao().getConexao(); PreparedStatement st = con.prepareStatement(sql)) {
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

    public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM Cliente ORDER BY nome";
        List<Cliente> lista = new ArrayList<>();

        try (Connection con = new Conexao().getConexao(); PreparedStatement st = con.prepareStatement(sql); ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNome(rs.getString("nome"));
                c.setCPF(rs.getString("CPF"));
                c.setDataNasc(rs.getString("nascimento"));
                c.setTelefoneCli(rs.getString("telefone"));

                lista.add(c);
            }

        } catch (SQLException ex) {
            System.err.println("Erro DAO ao listar clientes: " + ex.getMessage());
            throw new RuntimeException("Falha ao buscar a lista de clientes no banco.", ex);
        }

        return lista;
    }
}
