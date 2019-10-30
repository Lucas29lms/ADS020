
import dao.ContatoDAO;
import entidades.Contato;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18114290046
 */
public class TestaJPA {
    
    public static void main(String[] args) {
        
        ContatoDAO dao = new ContatoDAO();
        
        Contato contato = new Contato();
        
        contato.setNome("Lucas");
        contato.setTelefone(982554855);
        dao.persist(contato);
        
        contato = new Contato();
        
        contato.setNome("Maria");
        contato.setTelefone(982556666);
        dao.persist(contato);
        
        contato = new Contato();
        
        contato.setNome("Jose");
        contato.setTelefone(982554444);
        dao.persist(contato);
        
        contato.setNome("Jose Antonio");
        dao.merge(contato);
        
        contato = dao.find(2);
        dao.remove(contato);
        
        for(Contato cont : dao.list()){
            System.out.println(cont);
        }
        
        
        System.exit(0);
    }
}
