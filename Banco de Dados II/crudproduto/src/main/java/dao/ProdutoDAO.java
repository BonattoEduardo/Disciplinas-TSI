package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.Produto;

public class ProdutoDAO {
    private final EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }
    
    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }
    
    public List<Produto> ler() {
        TypedQuery<Produto> query = em.createQuery(
            "SELECT p FROM Produto p",
            Produto.class
        );
        List<Produto> lista = query.getResultList();

        return lista;
    }
    
    public void remover(Produto produto) {
        produto = this.em.merge(produto);
        this.em.remove(produto);
    }
    
}
