package org.in.yuvaa.yuvaarestapi.entity.contact;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact")
public class ContactEntity implements Serializable {

    private final static long serialVersionUID = 417872381058657197L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 30)
    private String contactId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(nullable = false, length = 10)
    private String mobile;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String description;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
