package org.in.yuvaa.yuvaarestapi.model.request.event;

import java.util.List;

public class EventRequestModel {

    private String eventName;
    private String eventDescription;
    private List<EventCommentRequestModel> eventComments;
    private List<EventStateRequestModel> eventState;


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

    public List<EventCommentRequestModel> getEventComments() {
        return eventComments;
    }

    public void setEventComments(List<EventCommentRequestModel> eventComments) {
        this.eventComments = eventComments;
    }

    public List<EventStateRequestModel> getEventState() {
        return eventState;
    }

    public void setEventState(List<EventStateRequestModel> eventState) {
        this.eventState = eventState;
    }

    @Override
    public String toString() {
        return "EventRequestModel{" +
                "eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventComments=" + eventComments +
                ", eventState=" + eventState +
                '}';
    }
}
