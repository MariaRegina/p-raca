package com.mrsdeus.person.controllers;

import com.mrsdeus.person.entities.Address;
import com.mrsdeus.person.entities.Document;
import com.mrsdeus.person.entities.Person;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    private Person person;
    private Address address;
    private Document document;
}
