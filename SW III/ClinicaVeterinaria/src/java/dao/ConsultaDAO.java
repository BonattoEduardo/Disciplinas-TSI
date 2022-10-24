package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entidade.Consulta;
import exceptions.ConsultaJaCadastrada;

public class ConsultaDAO implements Serializable {
    
    private final List<Consulta> consultas = new ArrayList<>();
    
    public void incluir(Consulta consulta) throws ConsultaJaCadastrada {
        if (consultas.contains(consulta)) {
            throw new ConsultaJaCadastrada();
        }
        consultas.add(consulta);
    }
    
    public void remover(Consulta consulta) {
        System.out.println(consultas);
        System.out.println(consulta);
        consultas.remove(consulta);
    }
    
    public List<Consulta> getConsultas() {
        return consultas;
    }
}
