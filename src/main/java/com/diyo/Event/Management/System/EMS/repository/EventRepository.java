package com.diyo.Event.Management.System.EMS.repository;

import com.diyo.Event.Management.System.EMS.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByEventNameContaining(String words);
}
