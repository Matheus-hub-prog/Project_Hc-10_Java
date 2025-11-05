package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521/ORCL";
    private static final String USUARIO = "Rm564662";
    private static final String SENHA = "020207";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521/ORCL", "Rm564662", "020207");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }

    public static void fecharConexao(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }

    }
}