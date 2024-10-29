package edu.kirkwood.emeraldTrails.model;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static edu.kirkwood.shared.MySQL_Connect.getConnection2;

public class TrailDAO {
    public static void main(String[] args) {
        getTrails().forEach(System.out::println);
    }
    public static List<Trail> getTrails() {
        List<Trail> trails = new ArrayList<>(); // makes array list
        try(Connection connection = getConnection2()){
            CallableStatement statement = connection.prepareCall("{CALL sp_get_all_trails()}"); // call sp
            ResultSet rs = statement.executeQuery(); // execute query
            while(rs.next()) { // gets all the data

                String trailName = rs.getString("trail_name");
                double trailDistance = rs.getDouble("trail_distance");
                TrailDifficulty trailDifficulty = TrailDifficulty.fromString(rs.getString("trail_difficulty"));
                LocalTime trailTime = rs.getTime("trail_time").toLocalTime();
                String trailDescription = rs.getString("trail_description");
                Boolean allowsBikes = rs.getBoolean("allows_bikes");
                String trailImage = rs.getString("trail_image");
                trails.add(new Trail(trailName, trailDistance, trailDifficulty, trailTime, trailDescription, allowsBikes, trailImage)); // matches the column names in the sp
                // instantiates the trail objects
            }
        } catch(SQLException e) {
            throw new RuntimeException("Query error - " + e.getMessage());
        }
        return trails;
    }
}
