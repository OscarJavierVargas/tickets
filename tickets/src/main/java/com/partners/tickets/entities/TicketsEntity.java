package com.partners.tickets.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class TicketsEntity {
	
	public TicketsEntity() {
		super();
	}
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String usuario;
	    private LocalDateTime fechaCreacion;
	    private LocalDateTime fechaActualizacion;
	    @Enumerated(EnumType.STRING)
	    private Status estatus;
	    
	    public enum Status {
	        ABIERTO,
	        CERRADO
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public LocalDateTime getFechaCreacion() {
			return fechaCreacion;
		}
		public void setFechaCreacion(LocalDateTime fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}
		public LocalDateTime getFechaActualizacion() {
			return fechaActualizacion;
		}
		public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
			this.fechaActualizacion = fechaActualizacion;
		}
		public Status getEstatus() {
			return estatus;
		}
		public void setEstatus(Status estatus) {
			this.estatus = estatus;
		}	
	    
		
}
