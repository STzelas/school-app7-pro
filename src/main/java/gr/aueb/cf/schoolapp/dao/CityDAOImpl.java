package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.dao.exceptions.CityDAOException;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.model.City;
import gr.aueb.cf.schoolapp.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements ICityDAO {
    @Override
    public City insert(City city) throws CityDAOException {
        return null;
    }

    @Override
    public City update(City city) throws CityDAOException {
        return null;
    }

    @Override
    public void delete(Integer id) throws CityDAOException {

    }

    @Override
    public City getById(Integer id) throws CityDAOException {
        return null;
    }

    @Override
    public List<City> getAll() throws CityDAOException {
        String sql = "SELECT * FROM cities";
        List<City> cities = new ArrayList<>();
        City city;
        ResultSet rs;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            rs = ps.executeQuery();

            while (rs.next()) {
                city = new City(rs.getInt("id"), rs.getString("name"));

                cities.add(city);
            }

            return cities;
        } catch (SQLException e) {
            e.printStackTrace();
            //logging
            throw new CityDAOException("SQL Error. Error in getting all teachers.");
        }
    }
}
