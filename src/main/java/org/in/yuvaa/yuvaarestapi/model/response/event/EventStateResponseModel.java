package org.in.yuvaa.yuvaarestapi.model.response.event;

import org.in.yuvaa.yuvaarestapi.entity.event.EventStateValues;

public class EventStateResponseModel {

    private EventStateValues eventState;

    public EventStateValues getEventState() {
        return eventState;
    }

    public void setEventState(EventStateValues eventState) {
        this.eventState = eventState;
    }
}
