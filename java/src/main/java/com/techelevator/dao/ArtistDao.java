package com.techelevator.dao;

import com.techelevator.model.Artist;

import java.util.List;

public interface ArtistDao {

    List<Artist>  getAllArtists();

    Artist getArtistById(Long artist_id);

    void saveArtist(Artist artistToSave);

    void deleteArtist(Long artist_id);

    void updateArtist(Artist artistToSave, Long artist_id);

    Artist getArtistByName(String artistName);




}
