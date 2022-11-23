package br.com.ngfor.lotofacil.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ngfor.lotofacil.model.Usuario;
import br.com.ngfor.lotofacil.repository.UsuarioRepository;
import br.com.ngfor.lotofacil.security.UserSS;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository rep;

	public Usuario find(Integer id) {

		UserSS user = UserService.authenticated();
		/*
		 * if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
		 * throw new AuthorizationException("Acesso negado"); }
		 */

		Optional<Usuario> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName(), null));
	}

}
