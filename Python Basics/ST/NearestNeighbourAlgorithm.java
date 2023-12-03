import java.util.ArrayList;
import java.util.List;

public class NearestNeighbourAlgorithm {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("City1", 0, 0));
        cities.add(new City("City2", 1, 3));
        cities.add(new City("City3", 4, 2));
        cities.add(new City("City4", 2, 5));
        cities.add(new City("City5", 4, 2));
        cities.add(new City("City6", 3, 6));
        cities.add(new City("City7", 1, 3));
        cities.add(new City("City8", 4, 7));
        cities.add(new City("City9", 4, 2));
        cities.add(new City("City10", 5, 8));
        // cities.add(new City("City11", 0, 0));
        // cities.add(new City("City12", 6, 9));
        // cities.add(new City("City13", 4, 4));
        // cities.add(new City("City14", 7, 12));
        // cities.add(new City("City15", 4, 5));
        // cities.add(new City("City16", 8, 10));
        // cities.add(new City("City17", 1, 13));
        // cities.add(new City("City18", 9, 8));
        // cities.add(new City("City19", 4, 0));
        // cities.add(new City("City20", 10, 2));

        TSPSolver tspSolver = new TSPSolver();
        List<City> shortestRoute = tspSolver.solveTSP(cities);

        if (shortestRoute != null) {
            System.out.println("Shortest Route:");
            for (City city : shortestRoute) {
                System.out.println(city.getName());
            }
            System.out.println("Total Distance: " + tspSolver.calculateTotalDistance(shortestRoute));
        } else {
            System.out.println("No solution found.");
        }
    }
}

class City {
    private String name;
    private double x;
    private double y;

    public City(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class TSPSolver {
    public List<City> solveTSP(List<City> cities) {
        List<City> tour = new ArrayList<>();
        City startCity = cities.get(0);
        tour.add(startCity);
        cities.remove(startCity);

        while (!cities.isEmpty()) {
            City currentCity = tour.get(tour.size() - 1);
            City nearestCity = findNearestCity(currentCity, cities);
            tour.add(nearestCity);
            cities.remove(nearestCity);
        }

        tour.add(startCity); // Return to the starting city to complete the tour
        return tour;
    }

    private City findNearestCity(City currentCity, List<City> cities) {
        City nearestCity = null;
        double minDistance = Double.MAX_VALUE;

        for (City city : cities) {
            double distance = calculateDistance(currentCity, city);
            if (distance < minDistance) {
                minDistance = distance;
                nearestCity = city;
            }
        }

        return nearestCity;
    }

    private double calculateDistance(City city1, City city2) {
        double dx = city1.getX() - city2.getX();
        double dy = city1.getY() - city2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calculateTotalDistance(List<City> route) {
        double totalDistance = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            City city1 = route.get(i);
            City city2 = route.get(i + 1);
            totalDistance += calculateDistance(city1, city2);
        }
        return totalDistance;
    }
}
