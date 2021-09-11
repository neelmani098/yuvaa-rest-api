package org.in.yuvaa.yuvaarestapi.services;

import org.in.yuvaa.yuvaarestapi.shared.dto.contact.ContactDto;

public interface ContactService {

    ContactDto saveContactQuery(ContactDto contact);
}
