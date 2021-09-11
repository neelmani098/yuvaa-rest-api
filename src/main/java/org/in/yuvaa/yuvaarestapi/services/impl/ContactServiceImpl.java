package org.in.yuvaa.yuvaarestapi.services.impl;

import org.in.yuvaa.yuvaarestapi.entity.contact.ContactEntity;
import org.in.yuvaa.yuvaarestapi.repository.contact.ContactRepository;
import org.in.yuvaa.yuvaarestapi.services.ContactService;
import org.in.yuvaa.yuvaarestapi.shared.dto.contact.ContactDto;
import org.in.yuvaa.yuvaarestapi.shared.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    Utils utils;

    @Override
    public ContactDto saveContactQuery(ContactDto contact) {
        ContactDto returnValue = new ContactDto();

        ModelMapper mapper = new ModelMapper();
        ContactEntity contactEntity = new ContactEntity();
        contactEntity = mapper.map(contact, ContactEntity.class);

        // generate public contactId
        String publicId = utils.randomPublicId(30);
        contactEntity.setContactId(publicId);

        ContactEntity save = contactRepository.save(contactEntity);

        returnValue = mapper.map(save, ContactDto.class);

        return returnValue;

    }
}
