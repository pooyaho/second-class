package ir.mapsa.javacourse.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Connection connection = getConnection();
//        PreparedStatement statement = connection.prepareStatement("insert into users(username,password)  values(?,?)");
//        connection.setAutoCommit(false);
//
//        long l = System.currentTimeMillis();
//        Savepoint savepoint = null;
//        for (int i = 0; i < 100; i++) {
//            statement.setString(1, "ali" + i);
//            statement.setString(2, "123" + i);
//            statement.addBatch();
//            savepoint = connection.setSavepoint();
////            statement.executeUpdate();
//        }
//        connection.rollback(savepoint);
//        statement.executeBatch();
//
//        System.out.println(System.currentTimeMillis() - l);
////        statement.setString(1,"ali");
////        statement.setString(2,"123");
////        ResultSet resultSet = statement.executeQuery();
////
////        while (resultSet.next()) {
////            System.out.println(resultSet.getString("username"));
////        }
////
////        resultSet.close();
//        statement.close();
//        connection.close();
        Main main = new Main();
        UserEntity user = new UserEntity();
        user.setUsername("john_doe");
        user.setPassword("1234");
//        user.setId(502L);
        main.insert(null);
//        Optional<UserEntity> byId = main.findById(502L);
//        byId.ifPresent(i->{
//            String text = "user name is : " + i.getUsername() + "   password is : " + i.getPassword();
//            System.out.println(text);
//        });

    }

    public void insert(UserEntity user) throws ClassNotFoundException, SQLException {
        if (user == null) {
            throw new IllegalArgumentException("user is null");
        }
        if (user.getPassword() == null || user.getUsername() == null) {
            throw new IllegalArgumentException("username or password is null");
        }
        Connection connection = getConnection();

        String insertQuery = "insert into users(username,password) values(?,?);";

        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void update(UserEntity user) throws ClassNotFoundException, SQLException {
        if (user == null) {
            throw new IllegalArgumentException("user is null");
        }
        if (user.getPassword() == null ) {
            throw new IllegalArgumentException("password is null");
        }
        if (user.getUsername() == null ) {
            throw new IllegalArgumentException("username is null");
        }
        if (user.getId()==null) {
            throw new IllegalArgumentException("id is null");
        }
        Connection connection = getConnection();

        String updateQuery = "update users set username=? ,password=? where id=?;";
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setLong(3, user.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();

    }

    public void deleteById(Long id) throws ClassNotFoundException, SQLException {
        if (id==null) {
            throw new IllegalArgumentException("id is null");
        }
        Connection connection = getConnection();

        String deleteQuery = "delete from users where id=?;";
        PreparedStatement statement = connection.prepareStatement(deleteQuery);
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public Optional<UserEntity> findById(Long id) throws ClassNotFoundException, SQLException {
        if (id==null) {
            throw new IllegalArgumentException("id is null");
        }
        Connection connection = getConnection();

        String selectQuery = "select * from users where id=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(id);
            userEntity.setPassword(resultSet.getString("password"));
            userEntity.setUsername(resultSet.getString("username"));
            return Optional.of(userEntity);
        }
        return Optional.empty();

    }

    public List<UserEntity> find(UserEntity entity) throws ClassNotFoundException, SQLException {
        if (entity==null) {
            throw new IllegalArgumentException("entity is null");
        }
        Connection connection = getConnection();

        String selectQuery;
        PreparedStatement preparedStatement;
        if (entity.getUsername() != null) {
            selectQuery = "select * from users where username like %?%;";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, entity.getUsername());
        }else if (entity.getId() != null) {
            selectQuery = "select * from users where id=?;";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setLong(1, entity.getId());

        }else{
            selectQuery = "select * from users;";
            preparedStatement = connection.prepareStatement(selectQuery);


        }
        ResultSet resultSet = preparedStatement.executeQuery();
        List<UserEntity> result = new ArrayList<>();
        while (resultSet.next()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(resultSet.getLong("id"));
            userEntity.setPassword(resultSet.getString("password"));
            userEntity.setUsername(resultSet.getString("username"));
            result.add(userEntity);
        }
        return result;

    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/second_class", "root", null);
    }
}

class UserEntity {
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}