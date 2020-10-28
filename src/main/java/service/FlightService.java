package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Flight;
import models.Model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    ObjectMapper objectMapper = new ObjectMapper();

    public List<Flight> getFlights() {
        Model jsonModel;
        try {
            jsonModel = objectMapper.readValue(new FileInputStream("src/main/resources/flights.json"), Model.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        List<Flight> flights = jsonModel.getFlights();
        return flights;
    }

    public List<Flight> getReqFlights(List<Flight> flights, String fromCity, String toCity){
        List<Flight> reqFlights = flights.stream().filter(flight -> flight.getFromСity().equals(fromCity) &&
                flight.getToCity().equals(toCity)).collect(Collectors.toList());
        return reqFlights;
    }
}
