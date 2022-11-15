import java.sql.Connection;

import dao.ConnectionFactory;
import dao.PessoaDAO;

public class Aula13 {
    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionFactory.getConnection(
            "localhost:3306",
            "teste",
            "root",
            "root"
        );

        PessoaDAO dao = new PessoaDAO(conn);

        dao.criar("Carlos Alberto", 34);
        dao.criar("Paulo Paulos", 16);
        dao.criar("Jair Inacio", 77);
        dao.criar("Luiz Messias", 89);

        System.out.println("Listando Registros: ");
        dao.ler().forEach(System.out::println);
        
        dao.remover("Carlos Alberto");
        dao.remover("Paulo Paulos");

        System.out.println("Listando Registros: ");
        dao.ler().forEach(System.out::println);

        dao.atualizar("Luiz Messias", 76);

        System.out.println("Listando Registros: ");
        dao.ler().forEach(System.out::println);

        conn.close();
    }
}
