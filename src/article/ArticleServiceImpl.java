package article;

import user.User;
import user.UserRepository;
import user.UserServiceImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleServiceImpl implements ArticleService {
    private static ArticleServiceImpl instance = new ArticleServiceImpl();
    public static ArticleServiceImpl getInstance(){return instance;}
    ArticleRepository repository;
    private ArticleServiceImpl(){
        this.repository = ArticleRepository.getInstance();
    }




    @Override
    public List<?> findUsers() throws SQLException {
        return repository.findUsers();
    }
}
