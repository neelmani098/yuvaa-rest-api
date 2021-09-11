package org.in.yuvaa.yuvaarestapi.controller;

import org.in.yuvaa.yuvaarestapi.model.request.event.EventCommentRequestModel;
import org.in.yuvaa.yuvaarestapi.model.request.event.EventRequestModel;
import org.in.yuvaa.yuvaarestapi.model.response.event.EventCommentResponseModel;
import org.in.yuvaa.yuvaarestapi.model.response.event.EventResponseModel;
import org.in.yuvaa.yuvaarestapi.services.EventService;
import org.in.yuvaa.yuvaarestapi.shared.dto.event.EventCommentsDto;
import org.in.yuvaa.yuvaarestapi.shared.dto.event.EventDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    // this should be restricted end point
    // create new event
    @PostMapping
    public ResponseEntity<String> saveEvent(@RequestBody EventRequestModel eventRequestModel){

        EventResponseModel returnValue = new EventResponseModel();


        ModelMapper mapper = new ModelMapper();
        EventDto event = mapper.map(eventRequestModel, EventDto.class);

        EventDto eventDto = eventService.saveEvent(event);

        returnValue = mapper.map(eventDto, EventResponseModel.class);

        return ResponseEntity.ok("Event Added Successfully");

    }

    // public end point
    // get all the approved events to show on website
    @GetMapping
    public List<EventResponseModel> getAllEvents() {

        List<EventResponseModel> result = new ArrayList<>();

        List<EventDto> allApprovedEvents = eventService.getAllApprovedEvents();
        ModelMapper modelMapper = new ModelMapper();

        for (EventDto res : allApprovedEvents){
            result.add(modelMapper.map(res, EventResponseModel.class));
        }
        return result;
    }

    // add comment end point
    // this should be restricted end point
    @PostMapping("/comment/{eventId}")
    public ResponseEntity<String> addComment(@PathVariable("eventId") String eventId,
                                             @RequestBody EventCommentRequestModel eventCommentRequestModel) {

        System.out.println(eventId);
        ModelMapper modelMapper = new ModelMapper();
        EventCommentsDto eventDto = modelMapper.map(eventCommentRequestModel, EventCommentsDto.class);

        eventService.addComment(eventId, eventDto);

        return ResponseEntity.ok("Comment added successfully");
    }

    // get comment for event
    // this should be restricted end point
    @GetMapping("/comment/{eventId}")
    public List<EventCommentResponseModel> getComment(@PathVariable("eventId") String eventId){

        List<EventCommentResponseModel> returnValue = new ArrayList<>();

        List<EventCommentsDto> allComments = eventService.getAllComments(eventId);

        ModelMapper modelMapper = new ModelMapper();
        for(EventCommentsDto comment : allComments){
            returnValue.add(modelMapper.map(comment, EventCommentResponseModel.class));
        }

        return returnValue;
    }



}
