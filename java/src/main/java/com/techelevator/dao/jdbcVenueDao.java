package com.techelevator.dao;

import com.techelevator.model.Venue;
import com.techelevator.model.VenueNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class jdbcVenueDao implements  VenueDao {

    private JdbcTemplate template;

    public jdbcVenueDao(DataSource datasource) {template = new JdbcTemplate(datasource);}

    @Override
    public List<Venue> getAllVenues() {
        List<Venue> venueList = new ArrayList<>();
        String sql = "select * from venue";
        SqlRowSet results = template.queryForRowSet(sql);
        while(results.next()){
            venueList.add(mapResultToVenue(results));
        }
        return venueList;
    }

    @Override
    public Venue getVenueByName(String venue_name) {
        String sqlGetVenue = "select * from venue where venue_name = ?";
        SqlRowSet result = template.queryForRowSet(sqlGetVenue, venue_name);
        if(result.next()){
            return mapResultToVenue(result);
        } else {
            throw new VenueNotFoundException();
        }

    }

    @Override
    public void saveVenue(Venue venueToSave) {
            String sql = "Insert into venue (venue_name, city, state_abv, venue_img"
                    + "values(?,?,?,?)";
            template.update(sql, venueToSave.getVenue_name(), venueToSave.getCity(),
            venueToSave.getStateAbv(), venueToSave.getVenueImg());
    }

    @Override
    public void deleteVenue(String venue_name) {
                String sql = "delete from venue where venue_name = ?";
                template.update(sql, venue_name);
    }

    @Override
    public void updateVenue(Venue venueToSave, String venue_name) {
                String sql = "Update venue set venue_name = ?, city = ?, state_abv = ?" +
                        "venue_img = ?";
                template.update(sql, venueToSave.getVenue_name(),venueToSave.getCity(),
                venueToSave.getStateAbv(), venueToSave.getVenueImg(), venue_name);
    }

    private Venue mapResultToVenue(SqlRowSet result){
        Venue retrievedVenue = null;
        String venue_name = result.getString("venue_name");
        String city = result.getString("city");
        String stateAbv = result.getString("state_abv");
        String venueImg = result.getString("venue_img");

        retrievedVenue = new Venue(venue_name,city,stateAbv,venueImg);

        return retrievedVenue;

    }
}
