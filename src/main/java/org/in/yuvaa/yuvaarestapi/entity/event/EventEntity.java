package org.in.yuvaa.yuvaarestapi.entity.event;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="event")
public class EventEntity implements Serializable {

    private static final long serialVersionUID = -4088477839227621560L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String eventId;

    @Column(nullable = false, length = 60)
    private String eventName;

    @Column(nullable = false)
    private String eventDescription;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "comments_id")
    private List<EventCommentsEntity> eventComments;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    private  List<EventStateEntity> eventState;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public List<EventCommentsEntity> getEventComments() {
        return eventComments;
    }

    public void setEventComments(List<EventCommentsEntity> eventComments) {
        this.eventComments = eventComments;
    }

    public List<EventStateEntity> getEventState() {
        return eventState;
    }

    public void setEventState(List<EventStateEntity> eventState) {
        this.eventState = eventState;
    }
}
