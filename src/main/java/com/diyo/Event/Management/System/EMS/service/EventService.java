package com.diyo.Event.Management.System.EMS.service;

import com.diyo.Event.Management.System.EMS.entity.Event;
import com.diyo.Event.Management.System.EMS.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    public String addNewEvent(Event event) {
        eventRepository.save(event);
        return "Event added successfully";
    }

    public String addMultipleEvent(List<Event> eventList) {
        eventRepository.saveAll(eventList);
        return "Multiple events added successfully";
    }

    public List<Event> getEventDetails() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        Optional<Event>eventOptional = eventRepository.findById(id);
        if(eventOptional.isPresent()){
            return eventOptional.get();
        }
        else{
            return null;
        }
    }

    public String deleteEvent(Long id) {
        Optional<Event>events = eventRepository.findById(id);
        if(events.isPresent()){
            eventRepository.deleteById(id);
            return "Event details deleted.";
        }
        else{
            return "Event record not found";
        }
    }

    public String updateEventDetails(Long id, Event event) {
        Optional<Event>eventOptional = eventRepository.findById(id);
        if(eventOptional.isPresent()) {
            Event dbEvent = eventOptional.get();
            event.setEventId(dbEvent.getEventId());
            eventRepository.save(event);
            return "Event record updated successfully";
        }
        else {
            return "Event record not found";
        }
    }

    public List<Event> findByEventNameContaining(String words) {
        return eventRepository.findByEventNameContaining(words);
    }
}
