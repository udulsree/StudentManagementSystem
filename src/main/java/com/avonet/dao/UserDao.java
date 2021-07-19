package com.avonet.dao;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.List;
        import javax.sql.DataSource;
        import com.avonet.model.User;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.jdbc.core.RowMapper;

public class UserDao {

    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    public User validateUser(User user) {

        String sql = "select * from userInfo where username='" + user.getUsername() + "' and password='" + user.getPassword()
                + "'";

        List<User> users = jdbcTemplate.query(sql, new UserMapper());

        return users.size() > 0 ? users.get(0) : null;
    }
}

class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();

        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));


        return user;
    }
}
