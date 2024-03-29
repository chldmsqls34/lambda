package com.linus.api.user;

import com.linus.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    Messenger save(User user);
    String addUsers();
    String login(User user);
    String updatePassword(User user);
    List<?> findUsersByName(String name);
    Map<String, ?> findUsersByNameFromMap(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobFromMap(String job);
    Map<String, ?> getUserMap();
    List<?> findUsers() throws SQLException;
    Messenger createUsers() throws SQLException;
    void deleteUsers() throws SQLException;

}