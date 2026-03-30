import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> rooms;

    public RoomInventory() {
        rooms = new HashMap<>();
        rooms.put("Single", 2);
        rooms.put("Double", 2);
        rooms.put("Suite", 1);
    }

    public boolean isRoomAvailable(String roomType) {
        return rooms.containsKey(roomType) && rooms.get(roomType) > 0;
    }

    // UC10 method
    public void incrementRoom(String roomType) {
        if (rooms.containsKey(roomType)) {
            rooms.put(roomType, rooms.get(roomType) + 1);
        }
    }

    public int getAvailableRooms(String roomType) {
        return rooms.getOrDefault(roomType, 0);
    }
}