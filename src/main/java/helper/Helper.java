package helper;

import models.Flight;

import java.util.List;

public class Helper {

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
