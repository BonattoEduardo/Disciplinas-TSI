package org.com.aula14.testes;

import javax.persistence.EntityManager;

import org.com.aula14.dao.PessoaDAO;
import org.com.aula14.model.Pessoa;
import org.com.aula14.util.JPAUtil;

public class CadastroPessoa {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        PessoaDAO dao = new PessoaDAO(em);

        // Removendo todas os registros
        em.getTransaction().begin();
        dao.ler().forEach(p -> dao.remover(p));
        em.getTransaction().commit();

        // Adicionando quatro pessoas
        em.getTransaction().begin();
        dao.cadastrar(new Pessoa("Carlos Alberto", 34));
        dao.cadastrar(new Pessoa("Paulo Paulos", 16));
        dao.cadastrar(new Pessoa("Jair Inacio", 77));
        dao.cadastrar(new Pessoa("Luiz Messias", 89));
        em.getTransaction().commit();

        System.out.println("Listando Registros: ");
        dao.ler().forEach(System.out::println);
        
        // Removendo duas pessoas
        em.getTransaction().begin();
        dao.remover(dao.encontrar("Carlos Alberto"));
        dao.remover(dao.encontrar("Paulo Paulos"));
        em.getTransaction().commit();

        System.out.println("Listando Registros: ");
        dao.ler().forEach(System.out::println);

        // Alterando registro
        em.getTransaction().begin();
        Pessoa pessoa = dao.encontrar("Luiz Messias");
        pessoa.setIdade(76);
        em.getTransaction().commit();

        System.out.println("Listando Registros: ");
        dao.ler().forEach(System.out::println);
    }
}
