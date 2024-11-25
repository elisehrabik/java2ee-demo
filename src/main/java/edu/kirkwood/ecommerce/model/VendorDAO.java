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
        Vendor vendor = new Vendor("BR01", "Test Vendor", new Address("123 Example St.", "Cedar Rapids", "IA", "55555", "USA"));
        addVendor(vendor);    }

    // Get vendors for admin view
    public static List<Vendor> getVendorsAdmin() {
        List<Vendor> vendors = new ArrayList<>();
        try (Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{CALL sp_get_all_vendors_admin()}");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String vend_id = rs.getString("vend_id");
                String vend_name = rs.getString("vend_name");
                String vend_address = rs.getString("vend_address");
                String vend_city = rs.getString("vend_city");
                String vend_state = rs.getString("vend_state");
                String vend_zip = rs.getString("vend_zip");
                String vend_country = rs.getString("vend_country");
                vendors.add(new Vendor(vend_id, vend_name, new Address(vend_address, vend_city, vend_state, vend_zip, vend_country)));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query error - " + e.getMessage());
        }
        return vendors;
    }

        public static boolean addVendor(Vendor vendor) {
            try(Connection connection = getConnection()) {
                CallableStatement statement = connection.prepareCall("{CALL sp_add_vendor_admin(?, ?, ?, ?, ?, ?, ?)}");
                statement.setString(1, vendor.getVend_id());
                statement.setString(2, vendor.getVend_name());
                statement.setString(3, vendor.getAddress().getAddress());
                statement.setString(4, vendor.getAddress().getCity());
                statement.setString(5, vendor.getAddress().getState());
                statement.setString(6, vendor.getAddress().getZip());
                statement.setString(7, vendor.getAddress().getCountry());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected == 1;
            } catch(SQLException e) {
//            System.out.println(e.getMessage()); // uncomment in case nothing is inserting
                return false;
            }
        }
    }
