package ru.aston.morozov_aa.task4.work_with_db.dao;

import ru.aston.morozov_aa.task4.work_with_db.dto.UserJoinOrderDTO;
import ru.aston.morozov_aa.task4.work_with_db.config.DataSource;
import ru.aston.morozov_aa.task4.work_with_db.exceptions.UserAlreadyExistException;
import ru.aston.morozov_aa.task4.work_with_db.exceptions.UserNotFoundException;
import ru.aston.morozov_aa.task4.work_with_db.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    private final Connection connection = DataSource.getInstance().getConnection();

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                users.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return users;
    }

    @Override
    public User findUserById(int id) throws UserNotFoundException {
        User user;
        String query = "SELECT * FROM users WHERE id = ?;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                throw new UserNotFoundException("User with id = " + id + " not found");
            }

            user = getUserFromResultSet(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return user;
    }

    @Override
    public boolean delete(int id) throws UserNotFoundException {
        String query = "DELETE FROM users WHERE id = ?;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            if(!isUserExist(id)){
                throw new UserNotFoundException("User with id = " + id + " not found");
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected > 0) {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public boolean create(User user) throws UserAlreadyExistException {
        String query = "INSERT INTO users (full_name, phone_number, email, birthday, order_id, id ) VALUES (?, ?, ?, ?, ?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if (isUserExist(user.getId())){
                throw new UserAlreadyExistException("User with id = " + user.getId() + " already exist");
            }

            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getPhoneNumber());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setDate(4, user.getBirthday());
            preparedStatement.setInt(5, user.getOrderId());
            preparedStatement.setInt(6, user.getId());


            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected > 0) {
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return false;
    }

    @Override
    public User update(User user) throws UserNotFoundException {
        User updatedUser;
        String query =
                "UPDATE users SET id = ?, full_name = ?, phone_number = ?, email = ?, birthday = ?, order_id = ? WHERE id = ?;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if(!isUserExist(user.getId())) {
                throw new UserNotFoundException("User with id = " + user.getId() + " not found");
            }

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setDate(5, user.getBirthday());
            preparedStatement.setInt(6, user.getOrderId());
            preparedStatement.setInt(7, user.getId());


            preparedStatement.executeUpdate();

            updatedUser = findUserById(user.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return updatedUser;
    }

    @Override
    public List<UserJoinOrderDTO> findInfoAboutUsersJoinOrders() {
        List<UserJoinOrderDTO> infoAboutUsersAndOrders = new ArrayList<>();
        String query =
                "SELECT u.id AS user_id, full_name, email, o.name AS order_name, s.name AS shipper_name FROM users u INNER JOIN orders o ON u.order_id = o.id INNER JOIN shippers s ON o.shipper_id = s.id;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                UserJoinOrderDTO userJoinOrderDTO = new UserJoinOrderDTO();

                userJoinOrderDTO.setId(resultSet.getInt("user_id"));
                userJoinOrderDTO.setFullName(resultSet.getString("full_name"));
                userJoinOrderDTO.setEmail(resultSet.getString("email"));
                userJoinOrderDTO.setOrderName(resultSet.getString("order_name"));
                userJoinOrderDTO.setOrderShipperName(resultSet.getString("shipper_name"));

                infoAboutUsersAndOrders.add(userJoinOrderDTO);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return infoAboutUsersAndOrders;
    }

    private boolean isUserExist(int id) {
        try {
            findUserById(id);
            return true;
        } catch (UserNotFoundException e) {
            return false;
        }
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setBirthday(resultSet.getDate("birthday"));
        user.setEmail(resultSet.getString("email"));
        user.setFullName(resultSet.getString("full_name"));
        user.setOrderId(resultSet.getInt("order_id"));
        user.setPhoneNumber(resultSet.getString("phone_number"));

        return user;
    }
}
