package org.in.yuvaa.yuvaarestapi.controller;

import org.in.yuvaa.yuvaarestapi.model.request.contact.ContactRequestModel;
import org.in.yuvaa.yuvaarestapi.services.ContactService;
import org.in.yuvaa.yuvaarestapi.shared.dto.contact.ContactDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    // submit the contact query to database
    // public endpoint
    @PostMapping
    public ResponseEntity<String> saveContactQuery(@RequestBody ContactRequestModel contactRequestModel){

        ModelMapper modelmapper = new ModelMapper();
        ContactDto contactDto = modelmapper.map(contactRequestModel, ContactDto.class);

        contactService.saveContactQuery(contactDto);

        return ResponseEntity.ok("You query has been submitted successfully, Sit back and relax our members will contact you");
    }


    //
}
