package com.diyo.Event.Management.System.EMS.repository;

import com.diyo.Event.Management.System.EMS.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Long> {
}
