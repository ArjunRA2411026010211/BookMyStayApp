import java.util.*;

public class CancellationService {

    // Stack to track released reservation IDs (LIFO)
    private Stack<String> releasedRoomIds;

    // Map reservationId → roomType
    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    // Register confirmed booking
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    // Cancel booking + rollback inventory
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        // Validate existence
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation not found.");
            return;
        }

        // Get room type
        String roomType = reservationRoomTypeMap.get(reservationId);

        // Remove from active bookings
        reservationRoomTypeMap.remove(reservationId);

        // Push into rollback stack
        releasedRoomIds.push(reservationId);

        // Restore inventory
        inventory.incrementRoom(roomType);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    // Show rollback history
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");

        if (releasedRoomIds.isEmpty()) {
            System.out.println("No cancellations yet.");
            return;
        }

        while (!releasedRoomIds.isEmpty()) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.pop());
        }
    }
}