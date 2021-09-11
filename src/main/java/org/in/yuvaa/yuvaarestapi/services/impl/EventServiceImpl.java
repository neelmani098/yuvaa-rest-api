package org.in.yuvaa.yuvaarestapi.services.impl;

import org.in.yuvaa.yuvaarestapi.entity.event.EventCommentsEntity;
import org.in.yuvaa.yuvaarestapi.entity.event.EventEntity;
import org.in.yuvaa.yuvaarestapi.entity.event.EventStateEntity;
import org.in.yuvaa.yuvaarestapi.entity.event.EventStateValues;
import org.in.yuvaa.yuvaarestapi.repository.event.EventCommentsRepository;
import org.in.yuvaa.yuvaarestapi.repository.event.EventRepository;
import org.in.yuvaa.yuvaarestapi.services.EventService;
import org.in.yuvaa.yuvaarestapi.shared.dto.event.EventCommentsDto;
import org.in.yuvaa.yuvaarestapi.shared.dto.event.EventDto;
import org.in.yuvaa.yuvaarestapi.shared.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventCommentsRepository eventCommentsRepository;

    @Autowired
    Utils eventUtils;

    @Override
    public EventDto saveEvent(EventDto event) {

        ModelMapper modelMapper = new ModelMapper();

        EventEntity eventEntity = modelMapper.map(event, EventEntity.class);
        String publicId = eventUtils.randomPublicId(30);
        eventEntity.setEventId(publicId);
        EventStateEntity eventStateEntity = new EventStateEntity();
        String publicStateId = eventUtils.randomPublicId(30);
        eventStateEntity.setEventStateId(publicStateId);
        eventStateEntity.setEventState(EventStateValues.DRAFT);
        eventEntity.setEventState(Arrays.asList(eventStateEntity));

        EventEntity save = eventRepository.save(eventEntity);

        return modelMapper.map(save, EventDto.class);
    }

    @Override
    public List<EventDto> getAllApprovedEvents() {

        List<EventDto> returnedValues = new ArrayList<>();
        List<EventEntity> allApprovedEvents = eventRepository.findAllApprovedEvents();

        ModelMapper modelMapper = new ModelMapper();
        for (EventEntity eventEntity : allApprovedEvents){
            returnedValues.add(modelMapper.map(eventEntity, EventDto.class));
        }

        return returnedValues;
    }

    @Override
    public EventDto getEventByEventId(String eventId) {
        EventDto result = new EventDto();

        ModelMapper modelMapper = new ModelMapper();
        EventEntity eventEntity = eventRepository.findByEventId(eventId);
        result = modelMapper.map(eventEntity, EventDto.class);

        return result;
    }

    @Override
    public EventDto addComment(String eventId, EventCommentsDto comment) {
        EventDto event = getEventByEventId(eventId);
        System.out.println(event.getId());
        ModelMapper modelMapper = new ModelMapper();
        EventEntity eventEntity = modelMapper.map(event, EventEntity.class);
        EventCommentsEntity eventComment = modelMapper.map(comment, EventCommentsEntity.class);

        String publicId = eventUtils.randomPublicId(30);
        eventComment.setEventCommentsId(publicId);
        eventEntity.getEventComments().add(eventComment);

        eventRepository.save(eventEntity);

        return modelMapper.map(eventEntity, EventDto.class);
    }

    @Override
    public List<EventCommentsDto> getAllComments(String eventId) {

        List<EventCommentsDto> returnValue = new ArrayList<>();

        ModelMapper modelMapper = new ModelMapper();


        long eId = getEventIdByPublicId(eventId);


        List<EventCommentsEntity> allComments = eventCommentsRepository.getAllComments(eId);
        for (EventCommentsEntity eventComment : allComments) {
            returnValue.add(modelMapper.map(eventComment, EventCommentsDto.class));
        }

        return returnValue;
    }

    @Override
    public long getEventIdByPublicId(String eventId) {
        return eventRepository.findEventId(eventId);
    }

}
