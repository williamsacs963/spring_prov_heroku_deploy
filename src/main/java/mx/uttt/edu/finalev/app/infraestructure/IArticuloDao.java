package mx.uttt.edu.finalev.app.infraestructure;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.uttt.edu.finalev.app.models.Articulo;

@Service
public interface IArticuloDao {

	public List<Articulo> getAllArticulos();
	public Articulo getArticuloById(Long id);
	public void saveArticulo(Articulo sart);
	public void eliminarArticulo(Long id);
	
}
