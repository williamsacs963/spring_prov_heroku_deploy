package mx.uttt.edu.finalev.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.uttt.edu.finalev.app.models.Usuario;
import mx.uttt.edu.finalev.app.repository.UsuarioDaoImpl;


@Service
@Transactional
public class UsuarioDetailService implements UserDetailsService{

	@Autowired
	@Lazy
	UsuarioDaoImpl usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario appUsuario = null;
		
		try {
			appUsuario = usuarioDao.getUsuarioByUsername(username);
		}catch (UsernameNotFoundException e) {
			throw e;
		}
		
		Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();		
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ADMIN");
		grantList.add(grantedAuthority);
		
		UserDetails user = (UserDetails) new User(username,appUsuario.getPassword(),grantList);
		
		return user;
	}

}
