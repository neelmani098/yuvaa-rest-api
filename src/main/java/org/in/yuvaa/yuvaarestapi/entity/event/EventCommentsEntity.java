package org.in.yuvaa.yuvaarestapi.entity.event;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "eventComments")
public class EventCommentsEntity implements Serializable {

    private static final long serialVersionUID = -2979152405557461077L;

    @Id
    @GeneratedValue
    private long id;

//    @Column(nullable = false)
    private String eventCommentsId;

//    @Column(nullable = false)
    private String eventComments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventCommentsId() {
        return eventCommentsId;
    }

    public void setEventCommentsId(String eventCommentsId) {
        this.eventCommentsId = eventCommentsId;
    }

    public String getEventComments() {
        return eventComments;
    }

    public void setEventComments(String eventComments) {
        this.eventComments = eventComments;
    }
}
