import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;

public class HotelTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  // @Before
  // public void setOutStream() {
  //   System.setOut(new PrintStream(outContent));
  // }

  // @After
  // public void restoreOutStream() {
  //   System.setOut(originalOut);
  // }

  @Test
  public void testCreateReservationWhenNoRoomOfDesiredTypeIsAvailable() {
    Room[] rooms = { new Room("double") };

    Hotel hotel = new Hotel("Coco", rooms);

    hotel.createReservation("Simon", "double");

    hotel.createReservation("Marie", "double");

    fail();
    // assertEquals(
    //   "Sorry \"Marie\", we have no available rooms of the desired type.",
    //   hotel
    // );
  }

  @Test
  public void testCreateReservationWhenNoRoomOfDesiredTypeExists() {
    Room[] rooms = { new Room("double") };

    Hotel hotel = new Hotel("Coco", rooms);
  }

  @Test
  public void testToStringHotelCocoWithOneAvailableDoubleRoom() {
    String hotelName = "Coco";

    Room[] rooms = { new Room("double") };

    Hotel hotel = new Hotel(hotelName, rooms);

    assertEquals(
      "Hotel name: Coco\nAvailable Rooms: 1 double, 0 queen, 0 king.",
      hotel.toString()
    );
  }

  @Test
  public void testToStringHotelKikiWithOneReservedDoubleRoom() {
    String hotelName = "Kiki";

    Room room1 = new Room("double");

    Room[] rooms = { room1 };

    Hotel hotel = new Hotel(hotelName, rooms);

    hotel.createReservation("Simon", "double");

    assertEquals(
      "Hotel name: Kiki\nAvailable Rooms: 0 double, 0 queen, 0 king.",
      hotel.toString()
    );
  }
}
