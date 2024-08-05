package com.partners.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.partners.tickets.entities.TicketsEntity;

@Repository
public interface TicketsRepository extends JpaRepository<TicketsEntity, Long>{

}
