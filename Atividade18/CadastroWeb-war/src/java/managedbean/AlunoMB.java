package managedbean;

import ejb.AlunoFacade;
import entity.Aluno;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;



/**
 *
 * @author 18114290046
 */
@Named(value = "alunoMB")
@SessionScoped
public class AlunoMB implements Serializable{
    
    @EJB
    private AlunoFacade ejb;

    private Aluno aluno = new Aluno();

    public AlunoMB() {

    }

    public List<Aluno> listar() {

        

        return ejb.findAll();

    }

    public String incluir() {
        aluno = new Aluno();
        return "cadastro";

    }

    public String salvar() {

        
        if(aluno.getId() > 0){
            ejb.edit(aluno);
        }else ejb.create(aluno);
        

        return "lista";
    }

    public String alterar(){

        
        
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        aluno.setId(Integer.valueOf(id));
        
        aluno = ejb.find(Integer.valueOf(id));

        return "cadastro";
    }
    
    public String excluir(){
        
        
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        aluno.setId(Integer.valueOf(id));
        
        aluno = ejb.find(Integer.valueOf(id));
        ejb.remove(aluno);
        
        return "lista?faces-redirect=true";
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
