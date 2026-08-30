package com.meuprojeto.aplicacaoweb.Classes;

import com.meuprojeto.aplicacaoweb.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thays
 */
public class UsuarioDao {

    public int salvar(Usuario usuario) {

        String sql = "INSERT INTO usuario (nome, DataNas, funcao, login, senha) VALUES (?, ?, ?, ?, ?)";
        int status = 0;
        try (Connection con = new Conexao().getConexao(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, usuario.getNomeUsu());
            st.setString(2, usuario.getDataNas());
            st.setString(3, usuario.getFuncao());
            st.setString(4, usuario.getLogin());
            st.setString(5, usuario.getSenha());;

            status = st.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro DAO ao salvar usuário: " + e.getMessage());
            throw new RuntimeException("Falha ao comunicar com o banco de dados durante o cadastro.", e);

        }
        return status;
    }

    public Usuario validarLogin(String login, String senha) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Usuario usuarioEncontrado = null;

        try (Connection con = new Conexao().getConexao(); PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, login);
            st.setString(2, senha);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    // Se encontrou no banco, popula o objeto Usuário
                    usuarioEncontrado = new Usuario();
                    usuarioEncontrado.setNomeUsu(rs.getString("nome"));
                    usuarioEncontrado.setDataNas(rs.getString("DataNas"));
                    usuarioEncontrado.setFuncao(rs.getString("funcao"));
                    usuarioEncontrado.setLogin(rs.getString("login"));
                    usuarioEncontrado.setSenha(rs.getString("senha"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro DAO ao validar login: " + e.getMessage());
            throw new RuntimeException("Falha ao comunicar com o banco de dados durante o login.", e);
        }

        return usuarioEncontrado;
    }
}


