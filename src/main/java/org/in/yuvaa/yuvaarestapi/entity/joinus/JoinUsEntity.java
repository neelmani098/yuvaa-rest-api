package org.in.yuvaa.yuvaarestapi.entity.joinus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "joinus")
public class JoinUsEntity implements Serializable {

    private static final long serialVersionUID = 740445645172815970L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 30)
    private String joinId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(nullable = false, length = 10)
    private String mobile;

    @Column(nullable = false, length = 80)
    private String college;

    @Column(nullable = false)
    private boolean selected;

    public String getJoinId() {
        return joinId;
    }

    public void setJoinId(String joinId) {
        this.joinId = joinId;
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


    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
