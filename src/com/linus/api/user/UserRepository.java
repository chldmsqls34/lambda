package com.linus.api.user;

import com.linus.api.enums.Messenger;

import java.lang.reflect.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.linus.api.enums.Messenger.FAIL;
import static com.linus.api.enums.Messenger.SUCCESS;

public class UserRepository {
    private static UserRepository instance;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private static Connection connection;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private UserRepository() throws SQLException {
       connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/linusdb",
                "linus","password" );
    }
    public static UserRepository getInstance(){
        return instance;}


    public List<?> findUsers() throws SQLException {
        List<User> ls = new ArrayList<>();
        String sql = "select * from users";
        System.out.println("sql : "+ sql);
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if(rs.next()){
            do{
                ls.add(User.builder()
                        .id(rs.getLong("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .phone(rs.getString("phone"))
                        .job(rs.getString("job"))
                        .height(rs.getDouble("height"))
                        .weight(rs.getDouble("weight"))
                        .build());
            }while(rs.next());

        }else{
            System.out.println("데이터가 없습니다.");
        }

        return null;
    }

    public static Messenger createUsers() throws SQLException {
        String touch = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(20) NOT NULL," +
                "password VARCHAR(20) NOT NULL," +
                "name VARCHAR(20)," +
                "phone VARCHAR(20)," +
                "job VARCHAR(20)," +
                "height DOUBLE," +
                "weight DOUBLE" +
                ")";
            PreparedStatement pstmt = connection.prepareStatement(touch);
            return (pstmt.executeUpdate(touch)==0) ? SUCCESS : FAIL;
    }

    public static void deleteUsers() throws SQLException {
        String rm = "DROP TABLE IF EXISTS users";
        PreparedStatement pstmt = connection.prepareStatement(rm);
        pstmt.executeUpdate(rm);
    }




}
