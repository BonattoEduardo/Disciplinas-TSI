package beans;

import dao.ConsultaDAO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.inject.Named;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@Named(value = "consultaBean")
@ApplicationScoped
public class ConsultaBean implements Serializable {
    private ConsultaDAO consultaDAO;
    
    @Produces
    public ConsultaDAO getConsultaDAO() {
        return consultaDAO;
    }
    
    @PostConstruct
    public void init() {
        try {
            FileInputStream fis = new FileInputStream("consulta.temp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            consultaDAO = (ConsultaDAO) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            consultaDAO = new ConsultaDAO();
            System.out.println(ex.getMessage());
        }
    }
    
    @PreDestroy
    public void destroy() {
        try {
            FileOutputStream fos = new FileOutputStream("consulta.temp");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(consultaDAO);
                oos.close();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.toString());
        }
    }
}
