/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author 18114290046
 */
@ManagedBean
@RequestScoped
public class CadastroMB {

    /**
     * Creates a new instance of CadastroMB
     */
    public CadastroMB() {
    }
    
    public String salvar() {
   return "lista.xhtml";
}
}
