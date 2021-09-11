package org.in.yuvaa.yuvaarestapi.model.response.event;

import java.util.List;

public class EventResponseModel {

    private String eventId;
    private String eventName;
    private String eventDescription;
//    private List<EventStateResponseModel> eventState;

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

//    public List<EventStateResponseModel> getEventState() {
//        return eventState;
//    }
//
//    public void setEventState(List<EventStateResponseModel> eventState) {
//        this.eventState = eventState;
//    }
}
