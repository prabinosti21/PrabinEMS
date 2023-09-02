package com.diyo.Event.Management.System.EMS.controller;

import com.diyo.Event.Management.System.EMS.entity.LikeDislikes;
import com.diyo.Event.Management.System.EMS.service.LikeDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/l&d")
public class LikeDislikesController {
    @Autowired
    private LikeDislikeService likeDislikeService;
    @PostMapping()
    public ResponseEntity<String> postLikesDislikes(@RequestBody LikeDislikes likeDislikes){
        return ResponseEntity.ok(likeDislikeService.postLikesDislikes(likeDislikes));
    }

    @PutMapping("/likes/{id}")
    public ResponseEntity<String>updateLikes(@PathVariable("id") Long id){
        return ResponseEntity.ok(likeDislikeService.updateLikes(id));
    }

    @PutMapping("/dislikes/{id}")
    public ResponseEntity<String>updateDisLikes(@PathVariable("id") Long id){
        return ResponseEntity.ok(likeDislikeService.updateDisLikes(id));
    }

    @GetMapping()
    public ResponseEntity<List<LikeDislikes>>getAll(){
        return ResponseEntity.ok(likeDislikeService.getAll());
    }

}
