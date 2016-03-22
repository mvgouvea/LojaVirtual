package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Produto;

public class ProdutoDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static void inserir(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(produto);
		t.commit();
	}
	
	public static void alterar(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(produto);
		t.commit();
	}
	
	public static void excluir(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(produto);
		t.commit();
	}
	
	public static List<Produto> listagem(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Produto");
		return consulta.list();
	}
	
	public static Produto pesqId(int valor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Produto where codigo =:parametro");
		consulta.setInteger("parametro", valor);
		return (Produto) consulta.uniqueResult();
	}
	
	
}
