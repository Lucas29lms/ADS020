/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Local;

@Local
public interface CarrinhoCompraLocal {
    
    public void adicionarItem(String item) throws EJBException;
    public List<String> listarItens() throws EJBException;
    
}
