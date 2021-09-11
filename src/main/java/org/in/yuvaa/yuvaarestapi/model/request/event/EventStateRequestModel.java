package org.in.yuvaa.yuvaarestapi.model.request.event;

import org.in.yuvaa.yuvaarestapi.entity.event.EventStateValues;

public class EventStateRequestModel {

    private EventStateValues eventState;

    public EventStateValues getEventState() {
        return eventState;
    }

    public void setEventState(EventStateValues eventState) {
        this.eventState = eventState;
    }
}
