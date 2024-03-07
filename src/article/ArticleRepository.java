package article;

import user.UserRepository;

import java.sql.*;
import java.util.List;

public class ArticleRepository {
    private static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection;
    private ArticleRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/linusdb",
                "linus","password" );
    }
    public static ArticleRepository getInstance(){
        return instance;}


    public List<?> findUsers() throws SQLException {
        String sql = "select * from articles";
        System.out.println("sql : "+ sql);
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            do{
                System.out.println("-- inner ---");
                System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s\n",
                        rs.getInt("id"),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                System.out.println();
            }while(rs.next());

        }else{
            System.out.println("데이터가 없습니다.");
        }

        rs.close();
        pstmt.close();
        connection.close();

        return null;
    }
}
