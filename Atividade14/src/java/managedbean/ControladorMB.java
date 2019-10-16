package managedbean;

import ejb.StatelessEJB;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named(value = "controladorMB")
@RequestScoped
public class ControladorMB implements Serializable{

    public ControladorMB() {        
        System.out.println("Criando o controlador...");       
    }
    @EJB
     private StatelessEJB ejb;

     
    public StatelessEJB getEjb() {
        return ejb;
    }

    public void setEjb(StatelessEJB ejb) {
        this.ejb = ejb;
    }
}
