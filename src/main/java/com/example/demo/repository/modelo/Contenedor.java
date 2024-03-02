package com.example.demo.repository.modelo;

public class Contenedor {
	
	private String jwtSemilla;
	private Integer jwtExpirationMs;
	
	//GET Y SET
	public String getJwtSemilla() {
		return jwtSemilla;
	}
	public void setJwtSemilla(String jwtSemilla) {
		this.jwtSemilla = jwtSemilla;
	}
	public Integer getJwtExpirationMs() {
		return jwtExpirationMs;
	}
	public void setJwtExpirationMs(Integer jwtExpirationMs) {
		this.jwtExpirationMs = jwtExpirationMs;
	}
	
	

}
