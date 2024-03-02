package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Contenedor;
import com.example.demo.repository.modelo.Usuario;
import com.example.demo.security.JwtUtils;
import com.example.demo.service.to.UsuarioTo;

@RestController
@RequestMapping("/autorizaciones")
@CrossOrigin(origins = "http://localhost:8082")
public class AuthorizationControllerRestFul {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwt;
	
	@PostMapping(path = "/jwt", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtenerToken(@RequestBody Contenedor contenedor) {
		//Autorizacion
		Usuario usuario = new Usuario();
		usuario.setNombre("Alfred");
		usuario.setPassword("123");
		this.authenticacion(usuario.getNombre(), usuario.getPassword());
		return this.jwt.buildTokenJwt(usuario.getNombre(), contenedor.getJwtSemilla() , contenedor.getJwtExpirationMs());
	}
	
	private void authenticacion(String usuario, String password) {
		UsernamePasswordAuthenticationToken usuarioToken = new UsernamePasswordAuthenticationToken(usuario, password);

		Authentication authentication = authenticationManager.authenticate(usuarioToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}
	
}
