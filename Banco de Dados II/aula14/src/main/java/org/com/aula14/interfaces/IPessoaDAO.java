package org.com.aula14.interfaces;

import java.util.List;

import org.com.aula14.model.Pessoa;

public interface IPessoaDAO {
    public Pessoa encontrar(String nome);
    public List<Pessoa> ler();
    public void cadastrar(Pessoa pessoa);
    public void remover(Pessoa pessoa);
    // public void atualizar(Pessoa pessoa);
}
