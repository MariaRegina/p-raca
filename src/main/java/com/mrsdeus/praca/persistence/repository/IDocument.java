package com.mrsdeus.praca.persistence.repository;

import com.mrsdeus.praca.persistence.entities.Document;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IDocument extends CrudRepository<Document, UUID> {
}
