package com.diyo.Event.Management.System.EMS.repository;

import com.diyo.Event.Management.System.EMS.entity.Guests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guests,Long> {
}
