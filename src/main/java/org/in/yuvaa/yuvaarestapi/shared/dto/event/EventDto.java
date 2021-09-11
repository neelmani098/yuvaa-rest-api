package org.in.yuvaa.yuvaarestapi.shared.dto.event;

import java.util.List;

public class EventDto {

    private long id;
    private String eventId;
    private String eventName;
    private String eventDescription;
    private List<EventStateDto> eventState;
    private List<EventCommentsDto> eventComments;

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

    public List<EventStateDto> getEventState() {
        return eventState;
    }

    public void setEventState(List<EventStateDto> eventState) {
        this.eventState = eventState;
    }

    public List<EventCommentsDto> getEventComments() {
        return eventComments;
    }

    public void setEventComments(List<EventCommentsDto> eventComments) {
        this.eventComments = eventComments;
    }
}
