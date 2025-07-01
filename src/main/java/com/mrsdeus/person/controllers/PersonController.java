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
    public Response createPerson(PersonRequest personRequest){
        Person person = personRequest.getPerson();
        Address address = personRequest.getAddress();
        Document document = personRequest.getDocument();

        return Response.ok().build();
    }

    @PUT
    public void updatePerson(PersonRequest personRequest){
        iPerson.save(personRequest.getPerson());
        iAddress.save(personRequest.getAddress());
        iDocument.save(personRequest.getDocument());
    }

    @DELETE
    public void deletePerson(Person person){
        iPerson.delete(person);
    }
}
