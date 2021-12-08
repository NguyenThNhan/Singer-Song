package com.example.songservice.controller;

import com.example.songservice.vo.ResponseTemplateVO;
import com.example.songservice.entity.Song;
import com.example.songservice.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
@Slf4j
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping("/")
    public Song saveSong(@RequestBody Song song){
        log.info("inside saveSong in SongController");
        return songService.saveSong(song);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getSongWithSinger(@PathVariable("id") Long songId){
        log.info("inside getSongWithFaculty in songController");
        return songService.getSongWithSinger(songId);
    }

}