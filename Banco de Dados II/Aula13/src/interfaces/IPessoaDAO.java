package interfaces;

import java.util.List;

import entidades.Pessoa;

public interface IPessoaDAO {
    public List<Pessoa> ler();
    public void criar(String nome, int idade);
    public void atualizar(String nome, int novaIdade);
    public void remover(String nome);
}
