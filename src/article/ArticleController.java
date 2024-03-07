package article;

import user.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    ArticleServiceImpl service;

    public ArticleController() {
        this.service = ArticleServiceImpl.getInstance();
    }


    public List<?> findUsers() throws SQLException {
        return service.findUsers();
    }
}
