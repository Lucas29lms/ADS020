package ejb;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

@Stateful
public class StatefulEJB implements Serializable{
    
    int contador = 0;

    public StatefulEJB() {
        System.out.println("Criando o stateful...");
    }
    
    public int invocar(){
        System.out.println("Invocando o stateful...");
        
        return ++contador;
    }
    @PostConstruct
    public void iniciar(){
        System.out.println("Iniciando o stateful...");
    }
    
    @PostActivate 
    public void ativar(){
        System.out.println("Ativando o stateful...");
    }
    
    @PrePassivate
    public void desativar(){
        System.out.println("Desativando o stateful...");
    }
    
    @PreDestroy
    public void finalizar(){
        System.out.println("Finalizando o stateful...");
    }
}
