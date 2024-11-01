package edu.kirkwood.ecommerce.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.kirkwood.shared.MySQL_Connect.getConnection;

public class CustomerDAO {
    public static void main(String[] args) {
        getCustomersAdmin().forEach(System.out::println);
    }

    // Get customers for admin view
    public static List<Customer> getCustomersAdmin() {
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{CALL sp_get_all_customers_admin()}");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                 int cust_id = rs.getInt("cust_id");
                 String cust_name = rs.getString("cust_name");
                 String cust_address = rs.getString("cust_address");
                 String cust_city = rs.getString("cust_city");
                 String cust_state = rs.getString("cust_state");
                 int cust_zip = rs.getInt("cust_zip");
                 String cust_country = rs.getString("cust_country");
                 String cust_contact = rs.getString("cust_contact");
                 String cust_email = rs.getString("cust_email");
                customers.add(new Customer(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact, cust_email ));
            }
        } catch(SQLException e) {
            throw new RuntimeException("Query error - " +  e.getMessage());
        }
        return customers;
    }
}
