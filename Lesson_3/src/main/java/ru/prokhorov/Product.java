package ru.prokhorov;

public class Product {
    private final int id;
    private final String title;
    private final String cost;

    public Product(int id, String title, String cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCost() {
        return cost;
    }
}
