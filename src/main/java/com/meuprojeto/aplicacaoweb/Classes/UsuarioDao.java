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

    PreparedStatement st;
    ResultSet rs;   
    private Conexao conexao;
    private Connection conn;

    public UsuarioDao() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public int salvar(Usuario usuario) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO usuario  (nome, DataNas, funcao, login, senha) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, usuario.getNomeUsu());
            String dataMySQL = usuario.getDataNas().replaceAll("(\\d{2})/(\\d{2})/(\\d{4})", "$3-$2-$1");
            st.setString(2, dataMySQL);
            st.setString(3, usuario.getFuncao());
            st.setString(4, usuario.getLogin());
            st.setString(5, usuario.getSenha());

            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public void fecharRecursos() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar recursos: " + ex.getMessage());
        }
    }

    
public Usuario validarLogin(String login, String senha) {
  
          try {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        st = conn.prepareStatement(sql);
        st.setString(1, login);
        st.setString(2, senha);
        rs = st.executeQuery();
        
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setNomeUsu(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setFuncao(rs.getString("funcao"));
            return usuario;
        } else {
            return null;
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao verificar login: " + ex.getMessage());
        return null;
    } finally {
        fecharRecursos(); 
    }
}
}


