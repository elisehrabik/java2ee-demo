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
        try (Connection connection = getConnection2()) {
            CallableStatement statement = connection.prepareCall("{CALL sp_get_all_trails()}"); // call sp
            ResultSet rs = statement.executeQuery(); // execute query
            while (rs.next()) { // gets all the data
                int trail_id = rs.getInt("trail_id");
                String trail_name = rs.getString("trail_name");
                double trail_distance = rs.getDouble("trail_distance");
                TrailDifficulty trail_difficulty = TrailDifficulty.fromString(rs.getString("trail_difficulty"));
                LocalTime trail_time = rs.getTime("trail_time").toLocalTime();
                String trail_description = rs.getString("trail_description");
                Boolean allows_bikes = rs.getBoolean("allows_bikes");
                String trail_image = rs.getString("trail_image");
                trails.add(new Trail(trail_id, trail_name, trail_distance, trail_difficulty, trail_time, trail_description, allows_bikes, trail_image)); // matches the column names in the sp
                // instantiates the trail objects
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query error - " + e.getMessage());
        }
        return trails;
    }

    public static List<Trail> getTrailsAdmin() {
        List<Trail> trails = new ArrayList<>(); // makes array list
        try (Connection connection = getConnection2()) {
            CallableStatement statement = connection.prepareCall("{CALL sp_get_all_trails_admin()}"); // call sp
            ResultSet rs = statement.executeQuery(); // execute query
            while (rs.next()) { // gets all the data
                int trail_id = rs.getInt("trail_id");
                String trail_name = rs.getString("trail_name");
                double trail_distance = rs.getDouble("trail_distance");
                TrailDifficulty trail_difficulty = TrailDifficulty.fromString(rs.getString("trail_difficulty"));
                LocalTime trail_time = rs.getTime("trail_time").toLocalTime();
                String trail_description = rs.getString("trail_description");
                Boolean allows_bikes = rs.getBoolean("allows_bikes");
                String trail_image = rs.getString("trail_image");
                trails.add(new Trail(trail_id, trail_name, trail_distance, trail_difficulty, trail_time, trail_description, allows_bikes, trail_image)); // matches the column names in the sp
                // instantiates the trail objects
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query error - " + e.getMessage());
        }
        return trails;
    }
}
