package br.com.alura.jdbc.dao;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.modelo.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ContatoDAO {
        private static Connection connection;

        public ContatoDAO() {
            this.connection = new ConnectionFactory().getConnection();
        }

        public static void insert(Contato contato) throws SQLException {
            // criando preparedStatement
            String sql = "INSERT INTO contatos " +
                    "(nome, email, endereco, dataNascimento) " +
                    "VALUES (?,?,?,?)";

            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1,contato.getNome());
                stmt.setString(2,contato.getEmail());
                stmt.setString(3,contato.getEndereco());
                stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                connection.close();
            }
        }

        public List<Contato> getLista() throws SQLException {
            String sql = "SELECT * FROM contatos";

            try {
                List<Contato> contatos = new ArrayList<Contato>();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()){
                    Contato contato = new Contato();
                    contato.setId(rs.getInt("id"));
                    contato.setNome(rs.getString("nome"));
                    contato.setEmail(rs.getString("email"));
                    contato.setEndereco(rs.getString("endereco"));

                    Calendar data = Calendar.getInstance();
                    data.setTime(rs.getDate("dataNascimento"));
                    contato.setDataNascimento(data);

                    contatos.add(contato);
                }
                rs.close();
                stmt.close();
                return contatos;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                connection.close();
            }
        }
    }

