package edu.kirkwood.ecommerce.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.kirkwood.shared.MySQL_Connect.getConnection;

public class ProductDAO {
    public static void main(String[] args) {
        getProducts().forEach(System.out::println);
    }
    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>(); // makes array list
        try(Connection connection = getConnection()){
            CallableStatement statement = connection.prepareCall("{CALL sp_get_all_products()}"); // call sp
            ResultSet rs = statement.executeQuery(); // execute query
            while(rs.next()) { // gets all the data
                String prod_id = rs.getString("prod_id");
                String prod_name = rs.getString("prod_name");
                double prod_price = rs.getDouble("prod_price");
                String prod_desc = rs.getString("prod_desc");
                products.add(new Product(prod_id, prod_name, prod_desc, prod_price)); // matches the column names in the sp
                // instantiates the product objects
            }
        } catch(SQLException e) {
            throw new RuntimeException("Query error - " + e.getMessage());
        }
        return products;
    }
}
