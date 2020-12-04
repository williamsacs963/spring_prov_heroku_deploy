package mx.uttt.edu.finalev.app.infraestructure;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.uttt.edu.finalev.app.models.Proveedor;

@Service
public interface IProveedorDao {

	public List<Proveedor> getAllProveedores();
	public Proveedor getProveedorById(Long id);
	public void saveProveedor(Proveedor proveedor);
	public void eliminarProveedor(Long id);
	
}
