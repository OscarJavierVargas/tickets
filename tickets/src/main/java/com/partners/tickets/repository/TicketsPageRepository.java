package com.partners.tickets.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.partners.tickets.entities.TicketsEntity;

@Repository
public interface TicketsPageRepository extends PagingAndSortingRepository<TicketsEntity, Long>{
	 Page<TicketsEntity> findByUsuario(String usuario, Pageable pegable );
}
