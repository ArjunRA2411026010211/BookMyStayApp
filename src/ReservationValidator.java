public class ReservationValidator {

    public void validate(String guestName, String roomType, RoomInventory inventory)
            throws InvalidBookingException {

        // Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Validate room type (case sensitive)
        if (roomType == null ||
                (!roomType.equals("Single") &&
                        !roomType.equals("Double") &&
                        !roomType.equals("Suite"))) {

            throw new InvalidBookingException("Invalid room type selected.");
        }

        // Check availability
        if (!inventory.isRoomAvailable(roomType)) {
            throw new InvalidBookingException("Selected room type is not available.");
        }
    }
}