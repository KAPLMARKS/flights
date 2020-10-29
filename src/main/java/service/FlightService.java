package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Flight;
import models.Model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static FlightService instance;
    private List<Flight> flights;

    public static FlightService getInstance() {
        if (instance == null) instance = new FlightService();
        return instance;
    }



    public void loadFlights(String fileUrl) {
        Model jsonModel;
        try {
            jsonModel = objectMapper.readValue(new FileInputStream(fileUrl), Model.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        flights = jsonModel.getFlights();
    }

    public List<Flight> getReqFlights(String fromCity, String toCity){
        return flights.stream().filter(flight -> flight.getFromСity().equals(fromCity) &&
                flight.getToCity().equals(toCity)).collect(Collectors.toList());

    }

    public int getMinPrice(List<Flight> reqFlights) {
        return reqFlights.stream().mapToInt(Flight::getPrice).min().getAsInt();
    }

    public double getAveragePrice(List<Flight> reqFlights) {
        return reqFlights.stream().mapToInt(Flight::getPrice).average().getAsDouble();
    }
    public int getMaxPrice(List<Flight> reqFlights) {
        return reqFlights.stream().mapToInt(Flight::getPrice).max().getAsInt();
    }

}
