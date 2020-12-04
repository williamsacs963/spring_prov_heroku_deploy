package mx.uttt.edu.finalev.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import mx.uttt.edu.finalev.app.infraestructure.IProveedorDao;
import mx.uttt.edu.finalev.app.models.Proveedor;

@Controller
@SessionAttributes("objprov")
public class ProveedorController {

	@Autowired
	private IProveedorDao proveedorDao;
	
	@GetMapping("/proveedores")
	public String listarProveedores(Model model) {
		model.addAttribute("title", "Listado de proveedores");
		model.addAttribute("lprov", proveedorDao.getAllProveedores());
		return "proveedor-form/proveedor-list";
	}

	@GetMapping("/proveedorform")
	public String crearProveedor(Model model) {
		
		model.addAttribute("title", "Registro de proveedores");
		model.addAttribute("objprov", new Proveedor());
		model.addAttribute("nameact", "Crear proveedor");
		
		return "proveedor-form/proveedor-form";
	}

	@PostMapping("/proveedorform")
	public String saveProveedor(@Valid @ModelAttribute("objprov") Proveedor objprov, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("title", "Registro de proveedor");
			//model.addAttribute("objprov", objprov);
			model.addAttribute("nameact", "Crear proveedor");
			return "/proveedorForm";
		}
		proveedorDao.saveProveedor(objprov);
		status.setComplete();
		
		return "redirect:/proveedores";
	}
	
	@GetMapping("/proveedorform/{id}")
	public String actualizarProveedor(@PathVariable(name="id")Long id ,Model model) {
		
		Proveedor objProv = null;
		
		if(id > 0) {
			objProv = proveedorDao.getProveedorById(id);
		}else {
			return "redirect:proveedores";
		}

		model.addAttribute("objprov",objProv);
		model.addAttribute("title", "Edición de usuario");
		model.addAttribute("nameact", "Guardar cambios");
		
		return "proveedor-form/proveedor-form";
	}

	@GetMapping("/deleteprov/{id}")
	public String eliminarProveedor(@PathVariable(name="id")Long id ,Model model) {
		
		if(id > 0) {

			try {
				proveedorDao.eliminarProveedor(id);
			}catch(Exception e) {
				
			}
			
		}else {
			return "redirect:/proveedores";
		}

		return "redirect:/proveedores";
	}
	
}
