package article;

import common.AbstractService;
import enums.Messenger;
import user.User;
import user.UserRepository;
import user.UserServiceImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService<User> implements ArticleService {
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

    @Override
    public Messenger save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<User> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(User user) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
