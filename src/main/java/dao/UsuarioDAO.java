package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class UsuarioDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("primeiroprojeto");
	EntityManager manager = factory.createEntityManager();
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar(){
		return manager.createQuery("select u from Usuario u").getResultList();
	}
	
	public void salvarOuAtualizar(Usuario usuario) {
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
		manager.close();
	}

}
