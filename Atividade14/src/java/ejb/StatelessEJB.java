package ejb;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;


@Stateless
public class StatelessEJB implements Serializable {
    
    int contador = 0;

    public StatelessEJB() {
        System.out.println("Criando o stateless...");
    }
     public int invocar(){
         System.out.println("Invocando o stateless...");
         
         return ++contador;
     }
     
     @PostConstruct
     public void iniciar(){
         System.out.println("Iniciando o stateless...");
     }
     
     @PreDestroy
     public void finalizar(){
         System.out.println("Finalizando o stateless...");
     }
}
