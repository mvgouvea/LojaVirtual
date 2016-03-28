package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistencia.ClienteDAO;
import beans.Cliente;


@ManagedBean
@SessionScoped
public class ClienteCtrl implements Serializable{


	private static final long serialVersionUID = 1L;
        
	private Cliente cliente;

	public Cliente getCliente() {
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
			return "lista_cliente";
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
	
}
