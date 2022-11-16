package controller;

import dao.ProdutoDAO;
import java.util.List;
import modelo.Produto;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import util.JPAUtil;

public class ProdutoController {
    private final EntityManager em;
    private final ProdutoDAO dao;
    private List<Produto> produtos;
    private Produto produtoSelecionado;
    
    public ProdutoController() {
        em = JPAUtil.getEntityManager();
        dao = new ProdutoDAO(em);
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }
    
    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public void salvar(String nome, String precoStr, String descricao) {
        if (nome.trim().length() == 0) {
            JOptionPane.showMessageDialog(
                null,
                "Informe o nome",
                "Atenção", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
                
        double preco;
        try {
            preco = Double.parseDouble(precoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                null,
                "Informe o preço correto",
                "Atenção", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        if (descricao.trim().length() == 0) {
            JOptionPane.showMessageDialog(
                null,
                "Informe a descrição",
                "Atenção", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        em.getTransaction().begin();
        
        if (produtoSelecionado == null) {
            Produto produto = new Produto(nome, preco, descricao);
            dao.cadastrar(produto);
        } else {
            produtoSelecionado.setNome(nome);
            produtoSelecionado.setPreco(preco);
            produtoSelecionado.setDescricao(descricao);
        }
        
        em.getTransaction().commit();
    }
    
    public void remover(Produto produto) {
        em.getTransaction().begin();
        dao.remover(produto);
        em.getTransaction().commit();
    }
    
    public List<Produto> atualizarProdutos() {
        produtos = dao.ler();
        return produtos;
    }
}
