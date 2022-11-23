package br.com.ngfor.lotofacil.controller;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ngfor.lotofacil.model.Usuario;
import br.com.ngfor.lotofacil.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private final UsuarioRepository rep;

	private final BCryptPasswordEncoder pe;

	public UsuarioController(UsuarioRepository rep, BCryptPasswordEncoder pe) {
		super();
		this.rep = rep;
		this.pe = pe;
	}

	@GetMapping
	// @PreAuthorize("hasAnyRole('ADMIN')")
	public List<Usuario> list() {
		return this.rep.findAll();
	}

}