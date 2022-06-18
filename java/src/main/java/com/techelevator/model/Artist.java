package com.techelevator.model;

public class Artist {
    private Long artist_id;
    private String artist_name;
    private String artistImg;

    public Artist(){}

    public Artist(Long artist_id, String artist_name, String artistImg) {
        this.artist_id = artist_id;
        this.artist_name = artist_name;
        this.artistImg = artistImg;
    }

    public Long getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Long artist_id) {
        this.artist_id = artist_id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getArtistImg() {
        return artistImg;
    }

    public void setArtistImg(String artistImg) {
        this.artistImg = artistImg;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artist_id=" + artist_id +
                ", artist_name='" + artist_name + '\'' +
                ", artistImg='" + artistImg + '\'' +
                '}';
    }
}
