package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Pessoa;
import interfaces.IPessoaDAO;

public class PessoaDAO implements IPessoaDAO {
    private Connection connection;

    public PessoaDAO(Connection conn) {
        this.connection = conn;
    }

    @Override
    public void atualizar(String nome, int novaIdade) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE pessoa SET idade = ? WHERE nome LIKE ?");
            ps.setInt(1, novaIdade);
            ps.setString(2, nome);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro tentando 'atualizar': " + e.getMessage());
        }
    }

    @Override
    public void criar(String nome, int idade) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO pessoa (nome, idade) VALUES (?, ?)");
            ps.setString(1, nome);
            ps.setInt(2, idade);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro tentando 'criar': " + e.getMessage());
        }
    }

    @Override
    public List<Pessoa> ler() {
        List<Pessoa> resultList = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT nome, idade FROM pessoa");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(rs.getString("nome"), rs.getInt("idade"));
                resultList.add(pessoa);
            }
        } catch (SQLException e) {
            System.out.println("Erro tentando 'ler': " + e.getMessage());
        }

        return resultList;
    }

    @Override
    public void remover(String nome) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM pessoa WHERE nome LIKE ?");
            ps.setString(1, nome);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro tentando 'remover': " + e.getMessage());
        }
    }
    
}
