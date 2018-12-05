package pt.sali.SALI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.functions.FUtilizador;
import pt.sali.SALI.model.Login;
import pt.sali.SALI.model.Role;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IUtilizador;

@RestController
@RequestMapping("/Utilizador")
public class HCUtilizador {
	
	@Autowired
	FUtilizador futilizador;
	
	@Autowired
	IUtilizador iUtilizador;		// SOMENTE PARA MOCK UP DATA
	
	@PostMapping("/add")
	public String addUtilizador(@RequestBody Utilizador u, @RequestParam ("tok") String tok) {
		
		return futilizador.saveUtilizador(u, tok);
	}
	
	@GetMapping("/listall")
	public ResponseEntity<?> listarAllUtilizadores (@RequestParam ("tok") String tok) {
		
		List<Utilizador> u = futilizador.listarAllUtilizador(tok); 
		if(u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token não está presente", HttpStatus.OK);
	}
	
	@GetMapping("/listByRole")
	public ResponseEntity<?> listarMedico (@RequestParam ("role") String role, @RequestParam ("tok") String tok){
		
		if (futilizador.listarUtilizadorByRole(role, tok) == null) {
			return new ResponseEntity<String> ("No match", HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Utilizador>> (futilizador.listarUtilizadorByRole(role, tok), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateUtilizador(@RequestBody Utilizador u, @RequestParam ("tok") String tok) {
		
		return new ResponseEntity<>(futilizador.updateUtilizador(u, tok), HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteUtilizador(@RequestBody Utilizador u,@RequestParam ("tok") String tok) {
		
		return new ResponseEntity<>(futilizador.deleteUtilizador(u, tok), HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> login (@RequestParam ("username") String username, 
										@RequestParam ("password") String password){
		
		return new ResponseEntity<String>(futilizador.login(username, password), HttpStatus.OK);
	}
	
	@GetMapping("/mock")
	public void mock() {
		
		Role ro = new Role("Enfermeiro");
		Login lo= new Login("ola", "ola");
		Utilizador e = new Utilizador("Joao", ro, "69", "Pediatra", lo);
		iUtilizador.save(e);
	}
}
