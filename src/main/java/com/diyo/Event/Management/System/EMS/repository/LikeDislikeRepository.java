package com.diyo.Event.Management.System.EMS.repository;

import com.diyo.Event.Management.System.EMS.entity.LikeDislikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDislikeRepository extends JpaRepository<LikeDislikes, Long> {
}
