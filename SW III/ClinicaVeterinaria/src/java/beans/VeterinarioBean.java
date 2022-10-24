package beans;

import dao.VeterinarioDAO;
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

@Named(value = "veterinarioBean")
@ApplicationScoped
public class VeterinarioBean implements Serializable {

    private VeterinarioDAO veterinarioDAO;
    
    @Produces
    public VeterinarioDAO getVeterinarioDAO() {
        return veterinarioDAO;
    }
    
    @PostConstruct
    public void init() {
        try {
            FileInputStream fis = new FileInputStream("veterinario.temp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            veterinarioDAO = (VeterinarioDAO) ois.readObject();
            
        } catch (IOException | ClassNotFoundException ex) {
            veterinarioDAO = new VeterinarioDAO();
            System.out.println(ex.getMessage());
        }
    }
    
    @PreDestroy
    public void destroy() {
        try {
            FileOutputStream fos = new FileOutputStream("veterinario.temp");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(veterinarioDAO);
                oos.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
