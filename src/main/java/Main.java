import com.fasterxml.jackson.databind.ObjectMapper;
import models.Flight;
import service.FlightService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String url = "src/main/resources/flights.json";
        FlightService flightService = new FlightService();
        ObjectMapper objectMapper = new ObjectMapper();
        flightService.loadFlights(url);

        System.out.println("Min Price : " + flightService.getMinPrice(flightService.
                getReqFlights("Москва", "Хабаровск")));
        System.out.println("AveragePrice : " + flightService.getAveragePrice(flightService.
                getReqFlights("Москва", "Хабаровск")));
        System.out.println("Max Price : " + flightService.getMaxPrice(flightService.
                getReqFlights("Москва", "Хабаровск")));
    }
}
