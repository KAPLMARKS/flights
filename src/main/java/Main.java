import com.fasterxml.jackson.databind.ObjectMapper;
import helper.Helper;
import models.Flight;
import models.Model;
import service.FlightService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Helper helper = new Helper();
        FlightService flightService = new FlightService();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Flight> flights = flightService.getFlights();

        System.out.println("Min costs flight: " + helper.getMinPrice(flightService.getReqFlights(flights,
                "Москва", "Хабаровск")));
        System.out.println("average: " + helper.getAveragePrice(flightService.getReqFlights(flights,"Москва", "Хабаровск")));
        System.out.println("Max: " + helper.getMaxPrice(flightService.getReqFlights(flights,"Москва", "Хабаровск")));
    }
}
