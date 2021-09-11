package org.in.yuvaa.yuvaarestapi.shared.dto.event;

public class EventCommentsDto {

    private long id;
    private String eventCommentsId;
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
