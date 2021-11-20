package com.principal.L8databases;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class dbManager {
    private static Connection con = null;
    public static void dbConnection() throws SQLException {
        if(con == null)
        {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userdb","root","9410111419");
        }
    }

    public dbManager() throws SQLException {
        createTable();
    }

    public static void createTable() throws SQLException {
        dbConnection();
        Statement statement = con.createStatement();
        statement.execute("create table if not exists user (userId int primary key auto_increment,name varchar(30),age int,country varchar(20))");

    }

    public static void insertUser(User user) throws SQLException {
        PreparedStatement st = con.prepareStatement("Insert into user (name,age,country) values(?,?,?)");
        st.setString(1,user.getName());
        st.setInt(2,user.getAge());
        st.setString(3, user.getCountry());

        int rows_affected = st.executeUpdate();
        if(rows_affected > 0)
        {
            System.out.println("User Object has been inserted successfully");
        }
        else
        {
            System.out.println("Not Inserted");
        }
    }
    public static ArrayList<User> getUsers() throws SQLException {
        ArrayList<User> userList = new ArrayList<>();
        dbConnection();

        System.out.println("Connection Build Successfulllllllly");
        String sql = "select * from user";

        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(sql);
        while(res.next())
        {
            int userId = res.getInt(1);
            String name = res.getString(2);
            int age = res.getInt(3);
            String country = res.getString(4);

            User user = new User(userId,name,age,country);
            userList.add(user);
        }
        return userList;
    }
}
