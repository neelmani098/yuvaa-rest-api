package org.in.yuvaa.yuvaarestapi.shared.dto.event;

import org.in.yuvaa.yuvaarestapi.entity.event.EventStateValues;

public class EventStateDto {

    private long id;
    private String eventStateId;
    private EventStateValues eventState;

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
