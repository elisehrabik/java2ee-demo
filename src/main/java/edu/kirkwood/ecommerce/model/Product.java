package edu.kirkwood.ecommerce.model;

public class Product {
    private String prod_id;
    private String prod_name;
    private String prod_desc;
    private double prod_price;

    public Product(String prod_id, String prod_name, String prod_desc, double prod_price) {
        this.prod_id = prod_id;
        this.prod_name = prod_name;
        this.prod_desc = String.valueOf(prod_desc);
        this.prod_price = prod_price;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }

    public double getProd_price() {
        return prod_price;
    }

    public void setProd_price(double prod_price) {
        this.prod_price = prod_price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prod_id='" + prod_id + '\'' +
                ", prod_name='" + prod_name + '\'' +
                ", prod_desc='" + prod_desc + '\'' +
                ", prod_price='" + prod_price + '\'' +
                '}';
    }
}


