package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;


@Stateless
@LocalBean
public class CarrinhoCompraStateless implements CarrinhoCompraLocal{

    private List<String> lista = new ArrayList<String>();

    @Override
    public void adicionarItem(String item) throws EJBException {
        
        System.out.println("Item \" + item + \" adicionado ao carrinho");

    }

    @Override
    public List<String> listarItens() throws EJBException {
        
        System.out.println("Listando itens do carrinho");
        
        return lista;
    }
}
