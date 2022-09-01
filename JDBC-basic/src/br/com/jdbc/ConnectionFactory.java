package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {

        // Estabelecendo conexão com o Banco de Dados MySQL

        // Parâmetros para se conectar ao banco de dados MySQL.
        // driver = "mysql";
        // dataBaseAddress = "localhost";
        // dataBaseName = "connection_jdbc";
        // user = "root";
        // password = "";

        // url = "jdbc:driver://dataBaseAddress/dataBaseName"

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/connection_jdbc", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
