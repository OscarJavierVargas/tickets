package com.partners.tickets.controller;


import org.springframework.data.domain.Pageable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.partners.tickets.entities.TicketsEntity;
import com.partners.tickets.service.TicketsService;

@RestController
@RequestMapping
public class TicketsRestController {
	
	
	@Autowired
	TicketsService ticketsService;
	
    @GetMapping("/filter")
    public Page<TicketsEntity> getTicketsByUsuario(@RequestParam String usuario, @RequestParam int pageable) {
    	
    	if (usuario == null ) {
            throw new IllegalArgumentException("El usuario o pageable no pueden ser null");
        }
    	int size = 2; // Puedes ajustar este valor según tus necesidades
         Pageable pageable1 = PageRequest.of(pageable, size);
    	return ticketsService.getTicketsByUsuario(usuario, pageable1);
    }
	
	@GetMapping("/tickets")
	ResponseEntity<?> getTickes(){
		return ticketsService.getTicket();	
		}
	
	@GetMapping("/tickets/{id}")
	ResponseEntity<?> getTickes(@PathVariable long id){
		return ticketsService.getTicketId(id);	
		}
	
    @PostMapping("/tickets")
    ResponseEntity<?> saveTickets (@RequestBody TicketsEntity tickets){
    	return ticketsService.saveTicket(tickets);
    }
    
    @PutMapping("/tickets/{id}")
    ResponseEntity<?> updateTickets (@PathVariable long id, @RequestBody TicketsEntity tickets){
    	try {
    	return ticketsService.updateTicket(id, tickets);
    	}catch (Exception e) {
    		return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
    		
		}
    }
	
    @DeleteMapping("/tickets/{id}")
	ResponseEntity<?> deleteTickes(@PathVariable long id){
		return ticketsService.deleteTicket(id);	
		}

		

	
}
