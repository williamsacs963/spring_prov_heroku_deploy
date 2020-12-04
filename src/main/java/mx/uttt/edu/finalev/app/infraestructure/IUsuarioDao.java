package mx.uttt.edu.finalev.app.infraestructure;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import mx.uttt.edu.finalev.app.models.Usuario;

@Service
@RequestScope
public interface IUsuarioDao {

	public List<Usuario> getAllUsuarios();
	public Usuario getUsuarioById(Long id);
	public void saveUsuario(Usuario usuario) throws Exception;
	public void eliminarUsuario(Long id);
	public Usuario getUsuarioByUsername(String username);
	
}
