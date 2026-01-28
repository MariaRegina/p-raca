package com.mrsdeus.praca.controller;

import com.mrsdeus.panel.persistence.entities.User;
import com.mrsdeus.panel.persistence.repositories.IUser;
import com.mrsdeus.praca.persistence.entities.Address;
import com.mrsdeus.praca.persistence.entities.Cart;
import com.mrsdeus.praca.persistence.entities.Document;
import com.mrsdeus.praca.persistence.entities.Person;
import com.mrsdeus.praca.persistence.repository.IAddress;
import com.mrsdeus.praca.persistence.repository.ICart;
import com.mrsdeus.praca.persistence.repository.IDocument;
import com.mrsdeus.praca.persistence.repository.IPerson;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Path("/person")
@Authenticated
public class PersonController {

    @Inject
    IPerson iPerson;

    @Inject
    IAddress iAddress;

    @Inject
    IDocument iDocument;

    @Inject
    ICart iCart;

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

    @PUT
    @PermitAll
    public Response createPerson( PersonRequest personRequest){
        //todo
        //validar itens
        User user = personRequest.getUser();
        user = iUser.save(user);

        Person person = personRequest.getPerson();
        Address address = personRequest.getAddress();
        Document document = personRequest.getDocument();

        person.setUser(user);
        person = iPerson.save(person);

        Cart cart = new Cart(person);
        iCart.save(cart);

        if(address != null){
            address.setPerson(person);
            iAddress.save(address);
        }
        if(document != null){
            document.setPerson(person);
            iDocument.save(document);
        }
        return Response.status(Response.Status.CREATED).entity(person).build();
    }

    @POST
    @Path("/{id}")
    public Response updatePerson(@PathParam("id") UUID id,  PersonRequest personRequest){
        Optional<Person> person = iPerson.findById(id);
        if(person.isEmpty()){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        User user = iUser.findById(person.get().getUser().getId()).get();
        user.setPassword(personRequest.getUser().getPassword());
        iUser.save(user);

        Person personUpdate = personRequest.getPerson();
        personUpdate.setId(id);
        iPerson.save(personUpdate);

        Address addressUpdate = personRequest.getAddress();
        addressUpdate.setPerson(personUpdate);
        iAddress.save(addressUpdate);

        Document documentUpdate = personRequest.getDocument();
        documentUpdate.setPerson(personUpdate);
        iDocument.save(documentUpdate);

        return Response.status(Response.Status.CREATED).entity(personUpdate).build();
    }

    @DELETE
    public void deletePerson(Person person){
        iPerson.delete(person);
    }
}
