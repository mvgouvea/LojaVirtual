package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistencia.ClienteDAO;
import beans.Cliente;
import beans.Fone;


@ManagedBean
@SessionScoped
public class ClienteCtrl implements Serializable{


	private static final long serialVersionUID = 1L;
        
	private Cliente cliente;
	private Fone fone;
	

	public Fone getFone() {
		return fone;
	}

	public void setFone(Fone fone) {
		this.fone = fone;
	}

	public Cliente getCliente() {
		if (cliente == null) {
			cliente = new Cliente(); 
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getListagem() {
		return ClienteDAO.listagem();
	}

	public String actionGravar() {
		if (cliente.getId() == 0) {
			ClienteDAO.inserir(cliente);
			return actionInserir();
		} else {
			ClienteDAO.alterar(cliente);
			return "form_cliente";
		}
	}

	public String actionInserir() {
		cliente = new Cliente();
		return "form_cliente";
	}

	public String actionExcluir() {
	       ClienteDAO.excluir(cliente);
		return "lista_cliente";
	}

	public String actionAlterar(Cliente cl) {
		cliente = cl;
		return "form_cliente";
	}
	
	public String actionInserirFone(){
		Fone fone = new Fone();
		fone.setCliente(cliente);
		cliente.getFones().add(fone);
		return "form_cliente";
	}
	
	public String actionExcluirFone() {
		//

		return "form_cliente";
	}
	
	public String actionPaginaInicial(){
		
		return "index";
	}
	
}
