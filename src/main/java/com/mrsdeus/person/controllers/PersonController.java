package com.mrsdeus.person.controllers;

import com.mrsdeus.person.entities.Address;
import com.mrsdeus.person.entities.Document;
import com.mrsdeus.person.entities.Person;
import com.mrsdeus.person.repositories.IAddress;
import com.mrsdeus.person.repositories.IDocument;
import com.mrsdeus.person.repositories.IPerson;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/person")
@Authenticated
public class PersonController {

    @Inject
    IPerson iPerson;

    @Inject
    IAddress iAddress;

    @Inject
    IDocument iDocument;

    @GET
    public Person getPerson(Person person){
        Optional<Person> response = iPerson.findById(person.getId());;
        return response.orElse(null);
    }

    @POST
    public Response createPerson(Person person, Address address, Document document){
        iPerson.save(person);
        iAddress.save(address);
        iDocument.save(document);
        return Response.created(null).build();
    }

    @PUT
    public void updatePerson(Person person, Address address, Document document){
        iPerson.save(person);
        iPerson.save(person);
        iAddress.save(address);
        iDocument.save(document);
    }

    @DELETE
    public void deletePerson(Person person){
        iPerson.delete(person);
    }
}
