package br.edu.uniso;

import java.sql.*;

public class ConexaoJDBC {

    static public void main(String args[]){

        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://34.225.155.37:3306/tiopalma_sempermissao",
                    "root", "rootdotiozao");
            boolean valido = c.isValid(1000);
            System.out.println("conexao eh valida: " + valido);
            // pegar aqui no java em memoria o conteudo do banco

            Statement s = c.createStatement();
            //executar um select
            ResultSet rs = s.executeQuery("select * from ALUNO");
            while(rs.next()){
                System.out.println("RA: " + rs.getInt("ra"));
                System.out.println("nome: " + rs.getString("primeiro_nome"));
                System.out.println("sobrenome: " + rs.getString("sobrenome"));
                System.out.println("idade: " + rs.getInt("idade"));


            }

            Statement i = c.createStatement();
            int resultado = i.executeUpdate("insert into ALUNO(ra, primeiro_nome, sobrenome, idade) values " +
                    "(12345, 'Ze', 'Candongas', 78)");

            System.out.println(resultado);
            rs.close();
            i.close();
            s.close();
            //c.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


}
