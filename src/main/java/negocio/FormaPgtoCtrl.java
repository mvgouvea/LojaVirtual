package negocio;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

import persistencia.FormaPgtoDAO;
import beans.FormaPgto;

@ManagedBean
@SessionScoped
public class FormaPgtoCtrl implements Serializable {

	private static final long serialVersionUID = 1L;

	private FormaPgto formaPgto = new FormaPgto();
	private String filtro = "";

	public FormaPgto getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(FormaPgto formaPgto) {
		this.formaPgto = formaPgto;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<FormaPgto> getListagem() {
		return FormaPgtoDAO.listagem(filtro);

	}

	public String actionGravar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (formaPgto.getId() == 0) {
			FormaPgtoDAO.inserir(formaPgto);
			context.addMessage(null, new FacesMessage("Sucesso",
					"Inserido com sucesso!"));
		} else {
			FormaPgtoDAO.alterar(formaPgto);
			context.addMessage(null, new FacesMessage("Sucesso",
					"Alterado com sucesso!"));
		}
		return "/admin/lista_formaPgto";
	}

	public String actionInserir() {
		formaPgto = new FormaPgto();
		return "/admin/lista_formaPgto";
	}

	public String actionExcluir() {
		FormaPgtoDAO.excluir(formaPgto);
		return "/admin/lista_formaPgto";

	}
	public void onRowSelect(SelectEvent event){
		FacesMessage msg = new FacesMessage("Forma de Pagamento Selecionada" , 
				String.valueOf(((FormaPgto) event.getObject()).getId()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
