package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.ICityDAO;
import gr.aueb.cf.schoolapp.dao.exceptions.CityDAOException;
import gr.aueb.cf.schoolapp.model.City;

import java.util.List;

public class CityServiceImpl implements ICityService{
    private final ICityDAO cityDAO; // dependacy injection, τα service χρειάζονται DAO

    public CityServiceImpl(ICityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public List<City> getAllCities() throws CityDAOException {
        try {
            return cityDAO.getAll();
        } catch (CityDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
