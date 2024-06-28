package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.models.Profile;
import org.yearup.data.ProfileDao;
import javax.sql.DataSource;
import java.sql.*;

@Component // add annotation to make this class a spring component
public class MySqlProfileDao extends MySqlDaoBase implements ProfileDao
{
    // constructor to initialize MySqlProfileDao with a DataSource
    public MySqlProfileDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public Profile create(Profile profile)
    {
        // SQL query to insert a new profile into the profiles table
        String sql = "INSERT INTO profiles (user_id, first_name, last_name, phone, email, address, city, state, zip) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = getConnection())
        {
            // create a prepared statement to execute the SQL query
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // set parameters for the prepared statement
            ps.setInt(1, profile.getUserId());
            ps.setString(2, profile.getFirstName());
            ps.setString(3, profile.getLastName());
            ps.setString(4, profile.getPhone());
            ps.setString(5, profile.getEmail());
            ps.setString(6, profile.getAddress());
            ps.setString(7, profile.getCity());
            ps.setString(8, profile.getState());
            ps.setString(9, profile.getZip());

            // execute the update
            ps.executeUpdate();

            // return the created profile
            return profile;
        }
        catch (SQLException e)
        {
            // throw a runtime exception in case of an SQL error
            throw new RuntimeException(e);
        }
    }

    // optional phase 4 starts
    @Override
    public Profile getByUserId(int userId) {
        // SQL query to select a profile by user ID
        String sql = "SELECT * FROM profiles WHERE user_id = ?";
        try (Connection connection = getConnection()){
            // create a prepared statement to execute the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // set the user ID parameter for the prepared statement
            preparedStatement.setInt(1, userId);

            // execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // create and return a new profile object from the result set
                return new Profile(
                     resultSet.getInt("user_id"),
                     resultSet.getString("first_name"),
                     resultSet.getString("last_name"),
                     resultSet.getString("phone"),
                     resultSet.getString("email"),
                     resultSet.getString("address"),
                     resultSet.getString("city"),
                     resultSet.getString("state"),
                     resultSet.getString("zip")
                );
            }
        } catch (SQLException e) {
            // throw a runtime exception in case of an SQL error
            throw new RuntimeException(e);
        }
        // return null if no profile is found
        return null;
    }

    @Override
    public void update(Profile profile) {
        // SQL query to update a profile in the profiles table
        String sql = "UPDATE profiles SET first_name = ?, last_name = ?, phone = ?, email = ?, address = ?, city = ?, state = ?, zip = ? WHERE user_id = ?";
        try (Connection connection = getConnection()) {
            // create a prepared statement to execute the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // set parameters for the prepared statement
            preparedStatement.setString(1, profile.getFirstName());
            preparedStatement.setString(2, profile.getLastName());
            preparedStatement.setString(3, profile.getPhone());
            preparedStatement.setString(4, profile.getEmail());
            preparedStatement.setString(5, profile.getAddress());
            preparedStatement.setString(6, profile.getCity());
            preparedStatement.setString(7, profile.getState());
            preparedStatement.setString(8, profile.getZip());
            preparedStatement.setInt(9, profile.getUserId());

            // execute the update
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // throw a runtime exception in case of an SQL error
            throw new RuntimeException(e);
        }
    }
    // optional phase 4 ends
}
