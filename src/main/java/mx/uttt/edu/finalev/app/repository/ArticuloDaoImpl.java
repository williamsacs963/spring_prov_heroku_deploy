package mx.uttt.edu.finalev.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.uttt.edu.finalev.app.infraestructure.IArticuloDao;
import mx.uttt.edu.finalev.app.models.Articulo;

@Repository
public class ArticuloDaoImpl implements IArticuloDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Articulo> getAllArticulos() {
		return em.createQuery("from Articulo").getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Articulo getArticuloById(Long id) {
		
		Articulo artfind = null;
		
		try {
			artfind = em.find(Articulo.class, id);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return artfind;
	}

	@Override
	@Transactional()
	public void saveArticulo(Articulo articulo) {
		
		try {
			if(articulo.getId() != null && articulo.getId() > 0) {
				em.merge(articulo);
			}else {
				em.persist(articulo);
			}
		}catch (Exception e) {
			//String myErrorMessage = e.getMessage();
		}
		
	}

	@Override
	@Transactional
	public void eliminarArticulo(Long id) {
		try {
			Articulo articulo = em.find(Articulo.class, id);
			
			em.remove(em.contains(articulo) ? articulo: em.merge(articulo));
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
