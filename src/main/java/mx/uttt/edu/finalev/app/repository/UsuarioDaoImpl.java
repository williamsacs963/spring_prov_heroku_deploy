package mx.uttt.edu.finalev.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.RollbackException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.uttt.edu.finalev.app.Exception.CustomExceptionClass;
import mx.uttt.edu.finalev.app.infraestructure.IUsuarioDao;
import mx.uttt.edu.finalev.app.models.Usuario;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao{


	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	BCryptPasswordEncoder userPasswordEncoder;
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Usuario> getAllUsuarios() {
		try {
			return em.createQuery("from Usuario").getResultList();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario getUsuarioById(Long id){

		Usuario prov = null;
		
		try {
			prov = em.find(Usuario.class, id);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return prov;
	}

	@Override
	@Transactional(noRollbackFor = RollbackException.class)
	public void saveUsuario(Usuario usuario) throws Exception{


			if(usuario != null) {
				String encriptedPass = userPasswordEncoder.encode(usuario.getPassword());
				usuario.setPassword(encriptedPass);
			}
			
			if(usuario.getId() != null && usuario.getId() > 0) {
				em.merge(usuario);
			}else {
				
				if(getUsuarioByUsername(usuario.getUsername()) != null) {
					throw new CustomExceptionClass("El nombre de usuario no se encuentra disponible","username");
				}
				
				if(!avalibleEmail(usuario.getEmail())) {
					throw new CustomExceptionClass("El correo se encuentra asosciado a otra cuenta","email");
				}
				
				em.persist(usuario);
			}

		
	}

	@Override
	@Transactional
	public void eliminarUsuario(Long id) {
		try {
			Usuario prov = em.find(Usuario.class, id);
			em.remove(em.contains(prov) ? prov: em.merge(prov));
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	@Transactional
	public Usuario getUsuarioByUsername(String username) {
		
		Usuario userfound = null;
		
		try {
			
			userfound = (Usuario) em
					.createQuery("SELECT e FROM Usuario e WHERE e.username=?1")
					.setParameter(1,username)
					.getSingleResult();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return userfound;
	}
	
	@Transactional
	public Usuario getUsuarioByEmail(String email) {
		
		Usuario userfound = null;
		
		try {
			
			userfound = (Usuario) em
					.createQuery("SELECT e FROM Usuario e WHERE e.email=?1")
					.setParameter(1, email)
					.getSingleResult();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return userfound;
	}
	
	protected boolean avalibleUsername(String username) {

		if(getUsuarioByUsername(username) != null) {
			return false;
		}
		return true;
	}

	protected boolean avalibleEmail(String correo) {

		if(getUsuarioByUsername(correo) != null) {
			return false;
		}
		return true;
	}
	
}
