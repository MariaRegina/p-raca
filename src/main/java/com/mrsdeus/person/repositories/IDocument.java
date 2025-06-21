package com.mrsdeus.person.repositories;

import com.mrsdeus.person.entities.Document;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IDocument extends CrudRepository<Document, UUID> {
}
