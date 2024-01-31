package bookingAPI.constants;

/**
 * Constants
 */
public class BookingConstants {

	public static final String BOOKING_INSERT_QUERY = "insert into Booking_Details (id, name, type) values ((select max(id) from Booking_Details) +1 ,':name',':type')";

	public static final String BOOKING_GET_QUERY = "select id, name, type from Booking_Details where id = :id";

	public static final String BOOKING_DELETE_QUERY = "delete from Booking_Details where id = :id";

	public static final String SUCCESS_STATUS = "Booking Confirmed : Booking is Created";

	public static final String UNSUCCESSFUL_STATUS = "Booking Unconfirmed: Booking not Created";

	public static final String BOOKING_FOUND = "Booking found";

	public static final String BOOKING_NOT_FOUND = "Booking not found";

	public static final String BOOKING_DELETED = "Booking Deleted Successfuly";

	public static final String BOOKING_NOT_DELETED = "Booking Deletion Unsuccessfuly/ Booking not found";
	
	public static final String GET_ID_QUERY = "select max(id) as id from Booking_Details";

	public static final String JDBC_DRIVER = "org.postgresql.Driver";
	public static final String DB_URL = "jdbc:postgresql://localhost:5442/bookings_db";
	public static final String DB_USER = "postgres";
	public static final String DB_PASS = "password";
}
