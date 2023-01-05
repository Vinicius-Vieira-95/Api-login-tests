package com.vnc.login.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vnc.login.entities.Usuario;
import com.vnc.login.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/users")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarTodos(){
		List<Usuario> list = repository.findAll();
		System.out.println(list);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> registra(@RequestBody Usuario user){
		user.setSenha(encoder.encode(user.getSenha()));
		return ResponseEntity.ok(repository.save(user));
	}
	
	
	@GetMapping(value = "/login")
	public ResponseEntity<Boolean> logado(@RequestParam String login, @RequestParam String senha){
		
		Optional<Usuario> optUsuario = repository.findByEmail(login);
		if(optUsuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}
		
		boolean flag = false;
		flag = encoder.matches(senha, optUsuario.get().getSenha());
		
		HttpStatus status = (flag) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		
		return ResponseEntity.status(status).body(flag);
	}
	
}
