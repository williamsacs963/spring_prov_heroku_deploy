package mx.uttt.edu.finalev.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import mx.uttt.edu.finalev.app.Exception.CustomExceptionClass;
import mx.uttt.edu.finalev.app.infraestructure.IUsuarioDao;
import mx.uttt.edu.finalev.app.models.Usuario;

@Controller
@RequestMapping({"","/"})
@SessionAttributes("objuser")
public class UserController {

	@Autowired
	@Lazy
	IUsuarioDao usuarioDao;
	
	@GetMapping({"","/","/login","*"})
	public String index() {
		return "index";
	}

	@GetMapping("/usreg")
	public String createUsuario(Model model) {
		
		model.addAttribute("title", "Registro de usuario");
		model.addAttribute("objuser", new Usuario());
		model.addAttribute("nameact", "Registrar usuario");
		
		return "usuario-form/usuario-form";
	}
	
	@PostMapping("/usreg")
	public String saveUsuario(@Valid @ModelAttribute("objuser")Usuario objuser,BindingResult result,Model model, SessionStatus status){

		model.addAttribute("title", "Registro de usuario");
		model.addAttribute("nameact", "Registrar usuario");
		
		if(result.hasErrors()) {
			//model.addAttribute("objuser", objuser);
			return  "usuario-form/usuario-form";
		}else {
			try {
				usuarioDao.saveUsuario(objuser);
				status.setComplete();
			}catch (CustomExceptionClass cecs) {
				result.rejectValue(cecs.getFieldName(), cecs.getMessage());
				return  "usuario-form/usuario-form";
			}catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				return  "usuario-form/usuario-form";
			}
			
		}
		
		return "redirect:/login";
		
	}
	
}
