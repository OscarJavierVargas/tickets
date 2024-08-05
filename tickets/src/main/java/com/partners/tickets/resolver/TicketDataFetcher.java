package com.partners.tickets.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.partners.tickets.entities.TicketsEntity;
import com.partners.tickets.service.TicketsService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class TicketDataFetcher implements DataFetcher<List<TicketsEntity>> {

    @Autowired
    private TicketsService ticketsService;

    @Override
    public List<TicketsEntity> get(DataFetchingEnvironment environment) {
        String usuario = environment.getArgument("usuario");
        Integer page = environment.getArgument("page");
        Integer size = environment.getArgument("size");
        return ticketsService.getTicketsByUsuario(usuario, PageRequest.of(page, size)).getContent();
    }
}
