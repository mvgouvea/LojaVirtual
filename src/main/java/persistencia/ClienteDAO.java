package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Cliente;

public class ClienteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void inserir(Cliente cliente){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(cliente);
		t.commit();
	}
	
	public static void alterar(Cliente cliente){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.merge(cliente);
		t.commit();
	}
	
	public static void excluir(Cliente cliente){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(cliente);
		t.commit();
	}
	
	public static List<Cliente> listagem(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Cliente");
		return consulta.list();
	}
	
	public static Cliente pesqId(int valor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Cliente where codigo =:parametro");
		consulta.setInteger("parametro", valor);
		return (Cliente) consulta.uniqueResult();
	}
}
