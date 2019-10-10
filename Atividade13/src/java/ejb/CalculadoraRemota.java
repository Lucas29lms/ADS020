package ejb;

import java.rmi.RemoteException;
import javax.ejb.EJBException;
import javax.ejb.Remote;

@Remote
public interface CalculadoraRemota {
    
    int somar(int a, int b) throws EJBException;
    int subtrair(int a, int b) throws EJBException;
    int multiplicar(int a, int b) throws EJBException;
    int dividir(int a, int b) throws EJBException;
}
