package com.mrsdeus.person.controllers;

import com.mrsdeus.panel.user.persitence.entities.User;
import com.mrsdeus.panel.user.persitence.repositories.IUser;
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

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Path("/person")
//@Authenticated
public class PersonController {

    @Inject
    IPerson iPerson;

    @Inject
    IAddress iAddress;

    @Inject
    IDocument iDocument;

    @Inject
    IUser iUser;

    @GET
    public ArrayList<Person> getPersons(){
        return (ArrayList<Person>) iPerson.findAll();
    }

    @GET
    @Path("/{id}")
    public Person getPersonById(UUID id){
        Optional<Person> pessoa = iPerson.findById(id);;
        return pessoa.orElse(null);
    }

    @POST
    public Response createPerson( PersonRequest personRequest){
        User user = personRequest.getUser();
        user = iUser.save(user);

        Person person = personRequest.getPerson();
        Address address = personRequest.getAddress();
        Document document = personRequest.getDocument();

        person.setUser(user);
        person = iPerson.save(person);
        if(address != null){
            address.setPerson(person);
            iAddress.save(address);
        }
        if(document != null){
            document.setPerson(person);
            iDocument.save(document);
        }
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
