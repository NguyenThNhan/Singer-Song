
package com.example.songservice.service;

import com.example.songservice.vo.ResponseTemplateVO;
import com.example.songservice.vo.Singer;
import com.example.songservice.entity.Song;
import com.example.songservice.repository.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class SongService {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Song saveSong(Song song) {
        log.info("inside saveSong in songService");
        return songRepository.save(song);
    }

    public ResponseTemplateVO getSongWithSinger(Long songId) {
        log.info("inside getStudentWithFaculty in studentRepository");
        ResponseTemplateVO vo=new ResponseTemplateVO();
        Song song= songRepository.findById(songId).get();
        Singer singer  =restTemplate.getForObject("http://SINGER-SERVICE/singers/" + song.getSingerId(), Singer.class);
        vo.setSinger(singer);
        vo.setSong(song);
        return  vo;
    }

//    public ResponseTemplateVO getSongWithSinger(Long songId) {
//        log.info("inside getStudentWithFaculty in studentRepository");
//        ResponseTemplateVO vo=new ResponseTemplateVO();
//        Song song= songRepository.findById(songId).get();
//        Singer singer  =restTemplate.getForObject("http://localhost:9001/singers/" + song.getSingerId(), Singer.class);
//        vo.setSinger(singer);
//        vo.setSong(song);
//        return  vo;
//    }
}
