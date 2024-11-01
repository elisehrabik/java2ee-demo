package edu.kirkwood.ecommerce.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.kirkwood.shared.MySQL_Connect.getConnection;

public class VendorDAO {
    public static void main(String[] args) {
        getVendorsAdmin().forEach(System.out::println);
    }

    // Get vendors for admin view
    public static List<Vendor> getVendorsAdmin() {
        List<Vendor> vendors = new ArrayList<>();
        try(Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{CALL sp_get_all_vendors_admin()}");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                 String vend_id = rs.getString("vend_id");
                 String vend_name = rs.getString("vend_name");
                 String vend_address = rs.getString("vend_address");
                 String vend_city = rs.getString("vend_city");
                 String vend_state = rs.getString("vend_state");
                 String vend_zip = rs.getString("vend_zip");
                 String vend_country = rs.getString("vend_country");
                vendors.add(new Vendor(vend_id, vend_name, vend_address, vend_city, vend_state, vend_zip, vend_country));
            }
        } catch(SQLException e) {
            throw new RuntimeException("Query error - " +  e.getMessage());
        }
        return vendors;
    }
}
