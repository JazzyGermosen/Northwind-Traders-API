package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class JDBCProductDao implements ProductDao {

    private  DataSource dataSource;

    @Autowired
    public void jdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Product product){
        // creating a sequel query
        // since we are doing values we are adding ?'s since we are unsure of what product we are adding
        //
        String sql = """
                Insert Into 
                    products ( productId, productName, categoryId, unitPrice)
                Values
                    (?, ?, ?, ?)
                """;

        try(
                // creating the connection between the database and using a prepared statement
                Connection conn = dataSource.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
        ){
            // replacing question marks with what should go in the column names
            // the first question mark is being set next we need to do the other 3
            // we are using the perameter set in the begining of the method and using get productid to set the first question mark
            statement.setInt(1, product.getProductId());

            statement.setString(2, product.getProductName());

            statement.setInt(3, product.getCategoryId());

            statement.setDouble(4, product.getUnitPrice());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> getAll(){

        List<Product> products = new ArrayList<>();

        String sql = """
               
               Select
                 *
               From 
                 Products
                """;

        try(
                // creating the connection between the database and using a prepared statement
                Connection conn = dataSource.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
        ){

            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product getById(int id){


        String sql = """
                Select
                    ProductName,
                    ProductId,
                    UnitPrice,
                    CategoryId
                From
                    Product
                Order By
                    ProductId;
                
               
                """;
        try(
                // creating the connection between the database and using a prepared statement
                Connection conn = dataSource.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
        ){
            try(
                    //hover over result set to tell you wat it does
                    // you can do this with any class or method
                    //Big Pur
                    ResultSet rs = statement.executeQuery()

                    ){
                String name = rs.getString("ProductName");
                int prodId = rs.getInt("ProductId");
                double unit = rs.getDouble("UnitPrice");
                int catId = rs.getInt("CategoryId");
                Product product = new Product(prodId, name, catId, unit);
                return product;
            }

        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }

    }


}
