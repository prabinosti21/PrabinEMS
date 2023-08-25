package com.diyo.Event.Management.System.EMS.controller;

import com.diyo.Event.Management.System.EMS.entity.Event;
import com.diyo.Event.Management.System.EMS.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin("http://localhost:4200")
public class EventController {
    @Autowired
    private EventService eventService;

    @Operation(summary = "API to add new Event.")
    @PostMapping()
    public ResponseEntity<String>addNewEvent(@Valid @RequestBody Event event){
        return ResponseEntity.ok(eventService.addNewEvent(event));
    }

    @Operation(summary = "API to add multiple Event at once.")
    @PostMapping("/multiple")
    public ResponseEntity<String>addMultipleEvent(@Valid @RequestBody List<Event>eventList){
        return ResponseEntity.ok(eventService.addMultipleEvent(eventList));
    }

    @Operation(summary = "API to get all the details about the Event.")
    @GetMapping()
    public ResponseEntity<List<Event>>getEventDetails(){
        return ResponseEntity.ok(eventService.getEventDetails());
    }

    @Operation(summary = "API to get the details about the Event from their respective ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Event>getEventById(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @Operation(summary = "API to get the Events from their name containing the words given by the users.")
    @GetMapping("/containing/{words}")
    public ResponseEntity<List<Event>>findByEventNameContaining(@PathVariable("words") String words){
        return ResponseEntity.ok(eventService.findByEventNameContaining(words));
    }

    @Operation(summary = "API to delete the Event.")
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteEvent(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok(eventService.deleteEvent(id));
    }

    @Operation(summary = "API to update all the details about the Event.")
    @PutMapping("/{id}")
    public ResponseEntity<String>updateEventDetails(@Valid @PathVariable("id") Long id, @Valid @RequestBody Event event ){
        return ResponseEntity.ok(eventService.updateEventDetails(id, event));
    }

}
