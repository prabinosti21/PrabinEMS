package com.diyo.Event.Management.System.EMS.service;

import com.diyo.Event.Management.System.EMS.entity.LikeDislikes;
import com.diyo.Event.Management.System.EMS.repository.LikeDislikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeDislikeService {
    @Autowired
    private LikeDislikeRepository likeDislikeRepository;

    public String postLikesDislikes(LikeDislikes likeDislikes) {
        likeDislikes.setLikeCounts(0);
        likeDislikes.setDislikeCounts(0);
        likeDislikeRepository.save(likeDislikes);
        return "Success";
    }

    public String updateLikes(Long id) {
        Optional<LikeDislikes> optional = likeDislikeRepository.findById(id);
        LikeDislikes likeDislikes = optional.get();
        if(optional.isPresent()){
            likeDislikes.setLikeCounts(likeDislikes.getLikeCounts()+1);
            likeDislikeRepository.save(likeDislikes);
            return "Liked";
        }
        else{
            return null;
        }
    }

    public String updateDisLikes(Long id) {
        Optional<LikeDislikes> optional = likeDislikeRepository.findById(id);
        LikeDislikes likeDislikes = optional.get();
        if(optional.isPresent()){
            likeDislikes.setDislikeCounts(likeDislikes.getDislikeCounts()+1);
            likeDislikeRepository.save(likeDislikes);
            return "Disliked";
        }
        else{
            return null;
        }
    }

    public List<LikeDislikes> getAll() {
        return likeDislikeRepository.findAll();
    }
}
