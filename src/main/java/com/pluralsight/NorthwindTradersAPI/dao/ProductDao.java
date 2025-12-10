package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.model.Product;

public interface ProductDao {

    public void add(Product product);


    public void getAll();
}
