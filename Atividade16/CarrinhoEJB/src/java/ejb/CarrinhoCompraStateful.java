/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateful;

/**
 *
 * @author 18114290046
 */
@Stateful
@Local(CarrinhoCompraLocal.class)
public class CarrinhoCompraStateful implements CarrinhoCompraLocal {

    List<String> lista = new ArrayList<String>();

    @Override
    public void adicionarItem(String item) throws EJBException {
        
        System.out.println("Item " + item + " adicionado ao carrinho");
    }

    @Override
    public List<String> listarItens() throws EJBException {
        
    return lista;
    }
}
