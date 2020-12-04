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

import mx.uttt.edu.finalev.app.infraestructure.IArticuloDao;
import mx.uttt.edu.finalev.app.infraestructure.IProveedorDao;
import mx.uttt.edu.finalev.app.models.Articulo;

@Controller
@SessionAttributes("objart")
public class ArticuloController {

	@Autowired
	private IArticuloDao articuloDao;
	
	@Autowired
	private IProveedorDao proveedorDao;
	
	@GetMapping("/articulos")
	public String listadoArticulos(Model model) {
		model.addAttribute("title", "Listado de articulos");
		model.addAttribute("larti", articuloDao.getAllArticulos());
		return "articulo-form/articulo-list";
	}
	
	@GetMapping("/articuloform")
	public String crearArticulos(Model model) {
		
		model.addAttribute("title", "Registro de articulos");
		model.addAttribute("objart", new Articulo());
		model.addAttribute("nameact", "Crear articulo");
		model.addAttribute("lprov", proveedorDao.getAllProveedores());
		
		return "articulo-form/articulo-form";
	}
	
	@PostMapping("/articuloform")
	public String saveArticulo(@Valid @ModelAttribute("objart") Articulo objart, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("title", "Registro de articulos");
			model.addAttribute("nameact", "Crear articulo");
			model.addAttribute("lprov", proveedorDao.getAllProveedores());
			//model.addAttribute("objart", objart);
			return "articulo-form/articulo-form";
		}
		articuloDao.saveArticulo(objart);
		status.setComplete();
		
		return "redirect:/articulos";
	}

	@GetMapping("/articuloform/{id}")
	public String actualizarArticulo(@PathVariable(name="id")Long id ,Model model) {
		
		Articulo objart = null;
		
		if(id > 0) {
			objart = articuloDao.getArticuloById(id);
		}else {
			return "redirect:articulos";
		}

		model.addAttribute("objart",objart);
		model.addAttribute("lprov", proveedorDao.getAllProveedores());
		model.addAttribute("title", "Edición de articulos");
		model.addAttribute("nameact", "Guardar cambios");
		
		return "articulo-form/articulo-form";
	}

	@GetMapping("/deleteart/{id}")
	public String eliminarArticulo(@PathVariable(name="id")Long id ,Model model) {
		
		if(id > 0) {

			try {
				articuloDao.eliminarArticulo(id);
			}catch(Exception e) {
				
			}
			
		}else {
			return "redirect:/articulos";
		}

		return "redirect:/articulos";
	}
	
}
