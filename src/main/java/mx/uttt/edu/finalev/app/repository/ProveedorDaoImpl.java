package mx.uttt.edu.finalev.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.uttt.edu.finalev.app.infraestructure.IProveedorDao;
import mx.uttt.edu.finalev.app.models.Proveedor;

@Repository
public class ProveedorDaoImpl implements IProveedorDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Proveedor> getAllProveedores() {
		try {
			return em.createQuery("from Proveedor").getResultList();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Proveedor getProveedorById(Long id){

		Proveedor prov = null;
		
		try {
			prov = em.find(Proveedor.class, id);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return prov;
	}

	@Override
	@Transactional
	public void saveProveedor(Proveedor proveedor){

		if(proveedor.getId() != null && proveedor.getId() > 0) {
			em.merge(proveedor);
		}else {
			em.persist(proveedor);
		}
				
	}

	@Override
	@Transactional
	public void eliminarProveedor(Long id) {
		try {
			Proveedor prov = em.find(Proveedor.class, id);
			em.remove(em.contains(prov) ? prov: em.merge(prov));
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
