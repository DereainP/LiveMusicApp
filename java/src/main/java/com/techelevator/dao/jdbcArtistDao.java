package com.techelevator.dao;

import com.techelevator.model.Artist;
import com.techelevator.model.ArtistNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class jdbcArtistDao implements  ArtistDao {
    private JdbcTemplate template;

    public jdbcArtistDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Artist> getAllArtists() {
        List<Artist> artistList = new ArrayList<>();
        String sql = "Select * from artists";
        SqlRowSet results = template.queryForRowSet(sql);
        while (results.next()) {
            artistList.add(mapResultsToArtists(results));
        }
        return artistList;
    }


    @Override
    public Artist getArtistById(Long artist_id) {
        String sql = "Select * from artists where artist_id = ?";
        SqlRowSet result = template.queryForRowSet(sql,artist_id);
        if(result.next()){
            return mapResultsToArtists(result);
        } else {
            throw new ArtistNotFoundException();
        }

    }

    @Override
    public void saveArtist(Artist artistToSave) {
        String sql = "Insert into artists (artist_name, artist_img)"
                + "values (?,?)";
        template.update(sql, artistToSave.getArtist_name(), artistToSave.getArtistImg());
    }

    @Override
    public void deleteArtist(Long artist_id) {
            String sql = "delete from artists where artist_id = ?";
            template.update(sql,artist_id);
    }

    @Override
    public void updateArtist(Artist artistToSave,Long artist_id) {
        String sql = "Update artists set artist_name = ? , artist_img = ? where artist_id = ?";
        template.update(sql,artistToSave.getArtist_name(), artistToSave.getArtistImg(), artist_id);
    }

    @Override
    public Artist getArtistByName(String artist_name) {
        String sql = "Select * from artists where artist_name = ?";
        SqlRowSet result = template.queryForRowSet(sql,artist_name);
        if(result.next()){
            return mapResultsToArtists(result);
        } else {
            throw new ArtistNotFoundException();
        }

    }

    private  Artist mapResultsToArtists(SqlRowSet result){
        Artist retrievedArtist = null;
        Long artistId = result.getLong("artist_id");
        String artistName = result.getString("artist_name");
        String artistImg = result.getString("artist_img");
        retrievedArtist = new Artist(artistId,artistName,artistImg);
        return retrievedArtist;
    }
}
