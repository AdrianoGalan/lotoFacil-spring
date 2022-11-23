package br.com.ngfor.lotofacil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.ngfor.lotofacil.model.Usuario;
import br.com.ngfor.lotofacil.model.enums.Perfil;
import br.com.ngfor.lotofacil.repository.UsuarioRepository;

@SpringBootApplication
public class LotoFacilApplication {

	@Autowired
	private BCryptPasswordEncoder pe;

	public static void main(String[] args) {
		SpringApplication.run(LotoFacilApplication.class, args);
	}

//	@Bean
//	CommandLineRunner iniciaBaseDados(UsuarioRepository usuarioRepository) {
//
//		return args -> {
//
//			
//		
//			
//			Usuario login = new Usuario(null, pe.encode("senha"), "dricoo@hotmail.com");
//			login.addPerfil(Perfil.ADMIN);
//	
//			
//			usuarioRepository.save(login);
//		
//			
//	
//			
//			
//			
//		};
//
//	}

}
