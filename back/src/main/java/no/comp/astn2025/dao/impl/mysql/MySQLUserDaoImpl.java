package no.comp.astn2025.dao.impl.mysql;

import no.comp.astn2025.configuration.ConnectionPool;
import no.comp.astn2025.dao.UserDao;
import no.comp.astn2025.entity.EntityStatus;
import no.comp.astn2025.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDaoImpl implements UserDao {
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    public MySQLUserDaoImpl() {   }

    @Override
    public void create(User type) {
        try {
            Connection connection = connectionPool.takeConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO users (email, pass) VALUES (?, ?)");
            pstmt.setString(1, type.getEmail());
            pstmt.setString(2, type.getPassword());
            pstmt.execute();
            connection.close();
        } catch (Exception exc) { exc.printStackTrace(); throw new RuntimeException(exc); }
    }

    @Override
    public List<User> readAll() {
        Connection connection = connectionPool.takeConnection();
        List<User> result = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                result.add(this.buildUser(rs));
            }

            connection.close();
        } catch (Exception exc) { throw new RuntimeException(exc); }

        return result;
    }

    @Override
    public User read(long id) {
        return null;
    }

    @Override
    public void update(User type) {

    }

    @Override
    public void delete(User type) {

    }

    @Override
    public User readWhereEmail(String email) {
        return null;
    }

    private User buildUser(ResultSet rs) {
        User user = new User();
        try {
            user.setId(rs.getLong("id"));
            user.setEmail(rs.getString("email"));
            user.setStatus(EntityStatus.valueOf(rs.getString("status")));
            user.setPassword(rs.getString("pass"));
        } catch (Exception exc) { exc.printStackTrace(); throw new RuntimeException(exc); }

        return user;
    }
}
