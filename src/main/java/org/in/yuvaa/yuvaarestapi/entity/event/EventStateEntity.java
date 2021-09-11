package org.in.yuvaa.yuvaarestapi.entity.event;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "eventState")
public class EventStateEntity implements Serializable {

    private static final long serialVersionUID = -2708005759952362563L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String  eventStateId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EventStateValues eventState;

//    @Column(nullable = false)
//    private String updatedBy;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventStateId() {
        return eventStateId;
    }

    public void setEventStateId(String eventStateId) {
        this.eventStateId = eventStateId;
    }

    public EventStateValues getEventState() {
        return eventState;
    }

    public void setEventState(EventStateValues eventState) {
        this.eventState = eventState;
    }
}
