package org.rakshith.songvideowithtranslation.controller;

import org.rakshith.songvideowithtranslation.model.Song;
import org.rakshith.songvideowithtranslation.model.SongList;
import org.rakshith.songvideowithtranslation.model.TextRequest;
import org.rakshith.songvideowithtranslation.model.TextResponse;
import org.rakshith.songvideowithtranslation.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;

@RestController
@RequestMapping("/songVideoTranslation")
@CrossOrigin
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping("/song/{songName}")
    public ResponseEntity getSong(@PathVariable("songName") String songName) throws IOException {
        songName = songName.replaceAll("%20", " ");
        System.out.println(songName);
        try{
            return new ResponseEntity(service.getSong(songName), HttpStatus.OK);

        }catch(Exception e){
            System.out.println(e);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/songs")
    public ResponseEntity getSongs() throws Exception {
        try{
            return new ResponseEntity(service.getSongs(), HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/videoIdForSong")
    public ResponseEntity getVideoIdForSong(@RequestParam("songName") String songName){
        try{
            return new ResponseEntity(service.getVideoId(songName), HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/translation/{songName}")
    public ResponseEntity translation(@PathVariable("songName") String songName, @RequestParam("language") String language) throws Exception {
        try{
            return new ResponseEntity(service.getTranslation(songName, language), HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/transliteration/{songName}")
    public ResponseEntity transliteration(@PathVariable("songName") String songName, @RequestParam("language") String language) throws Exception {
        try{
            return new ResponseEntity(service.getTransliteration(songName, language), HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
