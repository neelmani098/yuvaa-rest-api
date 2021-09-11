package org.in.yuvaa.yuvaarestapi.services;

import org.in.yuvaa.yuvaarestapi.shared.dto.event.EventCommentsDto;
import org.in.yuvaa.yuvaarestapi.shared.dto.event.EventDto;

import java.util.List;

public interface EventService {

    EventDto saveEvent(EventDto event);
    List<EventDto> getAllApprovedEvents();
    EventDto getEventByEventId(String eventId);
    EventDto addComment(String eventId, EventCommentsDto comment);
    List<EventCommentsDto> getAllComments(String eventId);
    long getEventIdByPublicId(String eventId);
}
