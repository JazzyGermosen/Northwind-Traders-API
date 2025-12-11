package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.model.Product;

import java.util.List;

public interface ProductDao {

    public void add(Product product);


    public List<Product> getAll();

    public Product getById(int id);
}
