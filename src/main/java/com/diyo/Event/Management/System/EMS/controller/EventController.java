package com.diyo.Event.Management.System.EMS.controller;

import com.diyo.Event.Management.System.EMS.entity.Event;
import com.diyo.Event.Management.System.EMS.service.EventService;
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

    @PostMapping()
    public ResponseEntity<String>addNewEvent(@Valid @RequestBody Event event){
        return ResponseEntity.ok(eventService.addNewEvent(event));
    }

    @PostMapping("/multiple")
    public ResponseEntity<String>addMultipleEvent(@Valid @RequestBody List<Event>eventList){
        return ResponseEntity.ok(eventService.addMultipleEvent(eventList));
    }

    @GetMapping()
    public ResponseEntity<List<Event>>getEventDetails(){
        return ResponseEntity.ok(eventService.getEventDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event>getEventById(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @GetMapping("/containing/{words}")
    public ResponseEntity<List<Event>>findByEventNameContaining(@PathVariable("words") String words){
        return ResponseEntity.ok(eventService.findByEventNameContaining(words));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteEvent(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok(eventService.deleteEvent(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>updateEventDetails(@Valid @PathVariable("id") Long id, @Valid @RequestBody Event event ){
        return ResponseEntity.ok(eventService.updateEventDetails(id, event));
    }

}
