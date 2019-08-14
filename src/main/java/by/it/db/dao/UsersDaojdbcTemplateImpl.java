package by.it.db.dao;

import by.it.db.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersDaojdbcTemplateImpl implements UsersDao {
    private JdbcTemplate template;
    private final String sqlSelectAll = "select * from fix_users.fix_user";
    private final String sqlSelectAllByFirstName = "select * from fix_user WHERE first_name = ?";
    //language=SQL
    private final String sqlSelectUserWithCars =
            "select * from fix_user left join fix_car on fix_user.id = fix_car.owner_id where fix_user.id = ?";

    public UsersDaojdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = (resultSet, i) -> {
        return new User(resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name")
        );
    };

    @Override
    public List<User> findAllByFirstName(String firstName) {
        return template.query(sqlSelectAllByFirstName, userRowMapper, firstName);
    }

    @Override
    public Optional<User> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> findAll() {
        return template.query(sqlSelectAll, userRowMapper);
    }
}
