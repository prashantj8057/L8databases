package com.principal.L8databases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
public class userController {

//    @Autowired
//    dbManager manager;

    @GetMapping("/get_user")
    public List<User> getuser() throws SQLException {
        return dbManager.getUsers();
    }

    @PostMapping("/insert_user")
    public void insertuser(@RequestBody User user) throws SQLException {
        dbManager.insertUser(user);
    }
}
