package beans;

import dao.TipoAnimalDAO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Named(value = "tipoAnimalBean")
@ApplicationScoped
public class TipoAnimalBean implements Serializable {
    
    private TipoAnimalDAO tipoAnimalDAO;
    
    @Produces
    public TipoAnimalDAO getTipoAnimalDAO() {
        return tipoAnimalDAO;
    }
    
    @PostConstruct
    public void init() {
        try {
            FileInputStream fis = new FileInputStream("tipoanimal.temp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tipoAnimalDAO = (TipoAnimalDAO) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            tipoAnimalDAO = new TipoAnimalDAO();
            System.out.println(ex.getMessage());
        }
    }
    
    @PreDestroy
    public void destroy() {
        try {
            FileOutputStream fos = new FileOutputStream("tipoanimal.temp");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(tipoAnimalDAO);
                oos.close();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.toString());
        }
    }
}
