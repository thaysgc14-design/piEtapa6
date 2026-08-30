package com.meuprojeto.aplicacaoweb.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thays
 */
public class Conexao {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    public Connection getConexao() {

        try {
            if (conn == null || conn.isClosed()) {

                this.conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost/beeflydb",
                        "root",
                        "root"
                );
            }
            return this.conn;
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {

        }
    }

}
