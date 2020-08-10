package model;

public class Product {
    protected int id;
    protected String name;
    protected String brand;
    protected int price;
    protected String imgItem;

    public Product(){

    }

    public Product(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public Product(int id, String name, String brand, int price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public Product(int id, String name, String brand, int price, String imgItem) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.imgItem = imgItem;
    }

    public Product(String name, String brand, int price, String imgItem) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.imgItem = imgItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgItem() {
        return imgItem;
    }

    public void setImgItem(String imgItem) {
        this.imgItem = imgItem;
    }
}
