package com.partners.tickets.resolver;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.partners.tickets.entities.TicketsEntity;
import com.partners.tickets.service.TicketsService;

@Component

public class TicketResolver {

    @Autowired
    private TicketsService ticketsService;

    public List<TicketsEntity> tickets(String usuario, Integer page, Integer size) {
        // Define cómo manejar la paginación aquí si es necesario
        return ticketsService.getTicketsByUsuario(usuario, PageRequest.of(page, size)).getContent();
    }

    public TicketsEntity ticket(Long id) {
        return (TicketsEntity) ticketsService.getTicketId(id).getBody();
    }

    public TicketsEntity createTicket(String usuario, String fechaCreacion, String fechaActualizacion, TicketsEntity.Status estatus) {
        TicketsEntity ticket = new TicketsEntity();
        ticket.setUsuario(usuario);
        ticket.setFechaCreacion(LocalDateTime.parse(fechaCreacion));
        ticket.setFechaActualizacion(LocalDateTime.parse(fechaActualizacion));
        ticket.setEstatus(estatus);
        return (TicketsEntity) ticketsService.saveTicket(ticket).getBody();
    }

    public TicketsEntity updateTicket(Long id, String usuario, String fechaCreacion, String fechaActualizacion, TicketsEntity.Status estatus) {
        TicketsEntity ticket = new TicketsEntity();
        ticket.setId(id);
        ticket.setUsuario(usuario);
        ticket.setFechaCreacion(LocalDateTime.parse(fechaCreacion));
        ticket.setFechaActualizacion(LocalDateTime.parse(fechaActualizacion));
        ticket.setEstatus(estatus);
        return (TicketsEntity) ticketsService.updateTicket(id, ticket).getBody();
    }

    public String deleteTicket(Long id) {
        return ticketsService.deleteTicket(id).getBody().toString();
    }
}

