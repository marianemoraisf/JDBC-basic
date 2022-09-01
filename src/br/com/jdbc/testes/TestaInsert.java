package br.com.jdbc.testes;

import br.com.jdbc.modelo.Contato;

public class TestaInsert {
    // pronto para gravar
    Contato contato = new Contato();
        contato.setNome("Mariane");
        contato.setEmail("marianemoraisf28@gmail.com");
        contato.setEndereco("R. Marechal Deodoro");
        contato.setDataNascimento(Calendar.getInstance());

    // grave nessa conexão!!!
    ContatoDAO dao = new ContatoDAO();

    // método insert
        dao.insert(contato);

        System.out.println("Gravado!");
}
