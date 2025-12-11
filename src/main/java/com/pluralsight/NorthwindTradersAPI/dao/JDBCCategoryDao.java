package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@Component
public class JDBCCategoryDao implements CategoryDao{


    private DataSource dataSource;

    @Autowired
    public void jdbcCategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll(){

        String sql = """
               
               Select
                 *
               From 
                 categories
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

        return getAll();
    }

    @Override
    public Category getById(int id){


        String sql = """
                Select
                    categoryId,
                    categoryName
                From
                    Categories
                Where
                    CategoryId = ?
                Order By
                    CategoryId;
                
               
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
        return Category category = new Category(int categoryId, String categoryName);
    }
}
