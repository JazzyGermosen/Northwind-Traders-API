package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.pluralsight.NorthwindTradersAPI.dao.JDBCProductDao.dataSource;

@Component
public class JDBCCategoryDao implements CategoryDao{


    @Autowired
    private static DataSource dataSource;

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

            statement.executeUpdate();

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
                Order By
                    CategoryId;
                
               
                """;
        try(
                // creating the connection between the database and using a prepared statement
                Connection conn = dataSource.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
        ){

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getById();
    }
}
