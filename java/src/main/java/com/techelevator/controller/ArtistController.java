package com.techelevator.controller;


import com.techelevator.dao.ArtistDao;
import com.techelevator.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class ArtistController {

    @Autowired
    ArtistDao theArtist;


    @GetMapping(path = {"/allArtists","/"})
    public List<Artist> returnArtistData(){
        logTimestamp("Getting All Artists");
        List<Artist> allArtists = theArtist.getAllArtists();

        return allArtists;
    }
    @GetMapping("/artist/{artist_id}")
    public Artist returnArtistById(@PathVariable Long artist_id){
        logTimestamp("Returning Artist" + artist_id);

        Artist artist =  theArtist.getArtistById(artist_id);
        return artist;
    }

//    @GetMapping("/artist/{artist_name}")
//    public Artist returnArtistByName(@PathVariable String artist_name){
//        logTimestamp("Returning Artist" + artist_name);
//
//        return theArtist.getArtistByName(artist_name);
//    }

    @PostMapping("/saveArtist")
    public void createArtist(@RequestBody Artist newArtist){
        theArtist.saveArtist(newArtist);
        logTimestamp("Creating new artist" + newArtist.getArtist_name());
    }

    @DeleteMapping("/deleteArtist/{artist_id}")
    public void deleteArtist(@PathVariable Long artist_id, Principal principle){
        theArtist.deleteArtist(artist_id);
        logTimestamp("Deleting artist" + artist_id + "by user" + principle.getName());
    }

    @PutMapping("/updateArtist/{artist_id}")
    public Artist updateArtistById(@PathVariable Long artist_id, @RequestBody Artist updatedArtist){
        logTimestamp("Updating artist " + artist_id);
        theArtist.updateArtist(updatedArtist,artist_id);
        return returnArtistById(artist_id);
    }

    static void logTimestamp(String msg) {    // log timestamp of request to Console
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }
}
