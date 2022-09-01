package br.com.alura.jdbc.dao;

import br.com.alura.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class InsertDB {
    public static void main(String[] args) throws SQLException {
        // estabelecendo conexão
        Connection connection = new ConnectionFactory().getConnection();

        // criando preparedStatement
        String sql = "INSERT INTO contatos " +
                "(nome, email, endereco, dataNascimento) " +
                "VALUES (?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);

        // preenche valores

        stmt.setString(1, "Mariane");
        stmt.setString(2, "marianemoraisf28@gmail.com");
        stmt.setString(3, "R Marechal Deodoro");
        stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

        // executa query
        stmt.execute();
        stmt.close();

        System.out.println("Gravado!");

        // fecha conexão com o banco
        connection.close();
    }
}
