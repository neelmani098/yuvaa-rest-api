package org.in.yuvaa.yuvaarestapi.repository.contact;

import org.in.yuvaa.yuvaarestapi.entity.contact.ContactEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Long> {
}
