import java.util.*;

public class AddOnServiceManager {

    private Map<String, List<AddOnService>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    // Add service
    public void addService(String reservationId, AddOnService service) {

        if (!servicesByReservation.containsKey(reservationId)) {
            servicesByReservation.put(reservationId, new ArrayList<>());
        }

        servicesByReservation.get(reservationId).add(service);
    }

    // Calculate total cost
    public double calculateTotalServiceCost(String reservationId) {

        double total = 0;

        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services != null) {
            for (AddOnService s : services) {
                total += s.getCost();
            }
        }

        return total;
    }
}