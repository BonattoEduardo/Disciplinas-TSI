package org.com.aula14.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.com.aula14.interfaces.IPessoaDAO;
import org.com.aula14.model.Pessoa;

public class PessoaDAO implements IPessoaDAO {
    private EntityManager em;

    public PessoaDAO(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public Pessoa encontrar(String nome) {
        TypedQuery<Pessoa> query = em.createQuery(
            "SELECT p FROM Pessoa p WHERE p.nome LIKE ?1",
            Pessoa.class
        );

        return query.setParameter(1, nome).setMaxResults(1).getSingleResult();
    }

    @Override
    public void cadastrar(Pessoa pessoa) {
        this.em.persist(pessoa);
    }

    @Override
    public List<Pessoa> ler() {
        TypedQuery<Pessoa> query = em.createQuery(
            "SELECT p FROM Pessoa p",
            Pessoa.class
        );
        List<Pessoa> lista = query.getResultList();

        return lista;
    }

    @Override
    public void remover(Pessoa pessoa) {
        this.em.remove(pessoa);
    }
    
}
