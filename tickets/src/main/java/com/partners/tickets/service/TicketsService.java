package com.partners.tickets.service;

import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.partners.tickets.entities.TicketsEntity;
import com.partners.tickets.repository.TicketsPageRepository;
import com.partners.tickets.repository.TicketsRepository;

@Service
public class TicketsService {
	

	
	@Autowired
	TicketsRepository ticketsRepository;
	@Autowired
	TicketsPageRepository ticketsPageRepository;
	
	public Page<TicketsEntity> getTicketsByUsuario(String usuario, Pageable pageable) {
		
		 // Verifica si el repositorio es nulo
	    if (ticketsPageRepository == null) {
	        throw new IllegalStateException("El repositorio no está inicializado");
	    }
        return ticketsPageRepository.findByUsuario(usuario, pageable);
    }
	
	// listar tickets
	public ResponseEntity<?> getTicket(){
		try {
			return  ResponseEntity.ok(ticketsRepository.findAll());	
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
		}
	}
	
	public ResponseEntity<?> getTicketId(long id){
		try {
			return  ResponseEntity.ok(ticketsRepository.findById(id));	
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
		}
	}
	
	// ingresar tickets
	
	public ResponseEntity<?> saveTicket(TicketsEntity tickets){
		LocalDateTime ahora = LocalDateTime.now();
		try {
			tickets.setFechaCreacion(ahora);
			tickets.setFechaActualizacion(ahora);
			ticketsRepository.save(tickets);
			return new ResponseEntity<>("tickets creado con exito", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
		}
	}
	
	public ResponseEntity<?> updateTicket(long id, TicketsEntity tickets){
		LocalDateTime ahora = LocalDateTime.now();
		try {
			
			if(ticketsRepository.findById(id) != null) {
				TicketsEntity actualiuzar=ticketsRepository.findById(id).get();
				actualiuzar.setEstatus(tickets.getEstatus());
				actualiuzar.setUsuario(tickets.getUsuario());
				actualiuzar.setFechaActualizacion(ahora);
			ticketsRepository.save(actualiuzar);
			}
			return new ResponseEntity<>("tickets modificado con exito", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
		}
	}
	
	public ResponseEntity<?> deleteTicket(long id ){
		try {
			
			if(ticketsRepository.findById(id) != null) {;	
			ticketsRepository.deleteById(id);;
			}
			return new ResponseEntity<>("tickets eliminado con exito", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
		}
	}


	

}
