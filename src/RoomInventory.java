import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> rooms;

    public RoomInventory() {
        rooms = new HashMap<>();
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    public boolean isRoomAvailable(String roomType) {
        return rooms.getOrDefault(roomType, 0) > 0;
    }

    public void decrementRoom(String roomType) {
        if (isRoomAvailable(roomType)) {
            rooms.put(roomType, rooms.get(roomType) - 1);
        }
    }

    public void incrementRoom(String roomType) {
        rooms.put(roomType, rooms.getOrDefault(roomType, 0) + 1);
    }

    public int getAvailableRooms(String roomType) {
        return rooms.getOrDefault(roomType, 0);
    }

    // ✅ THIS IS YOUR NEW METHOD (UC12)
    public void setRoomCount(String roomType, int count) {
        rooms.put(roomType, count);
    }
}