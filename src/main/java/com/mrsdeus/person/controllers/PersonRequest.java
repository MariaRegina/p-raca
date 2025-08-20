package com.mrsdeus.person.controllers;

import com.mrsdeus.panel.user.persitence.entities.User;
import com.mrsdeus.person.entities.Address;
import com.mrsdeus.person.entities.Document;
import com.mrsdeus.person.entities.Person;
import io.quarkus.runtime.util.StringUtil;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    private User user;
    private Person person;
    private Address address;
    private Document document;

    public Person getPerson(){
        Person person = this.person != null ? this.person : new Person();
        if(StringUtil.isNullOrEmpty(person.getName())){
            person.setName(user.getEmail());
        }
        return person;
    }

}
