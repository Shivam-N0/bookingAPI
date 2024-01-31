package bookingAPI.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import bookingAPI.constants.BookingConstants;
import bookingAPI.dto.BookingDTO;

/**
 * Booking Repository implementation
 */
@Repository
public class BookingRepositoryImpl implements BookingRepository {

	private static final Logger LOGGER = LogManager.getLogger(BookingRepositoryImpl.class);

	/**
	 * Creates new Booking
	 */
	@Override
	public BookingDTO create(BookingDTO customer) {
		BookingDTO booking = new BookingDTO();
		String query = BookingConstants.BOOKING_INSERT_QUERY;
		query = query.replaceAll(":name", customer.getCustomerName());
		query = query.replaceAll(":type", customer.getRoomType());
		String queryId = BookingConstants.GET_ID_QUERY;
		Connection connect = null;
		PreparedStatement ps = null;
		PreparedStatement psId = null;
		ResultSet result = null;
		try {
			Class.forName(BookingConstants.JDBC_DRIVER);
			connect = DriverManager.getConnection(BookingConstants.DB_URL, BookingConstants.DB_USER,
					BookingConstants.DB_PASS);
			ps = connect.prepareStatement(query);
			ps.executeUpdate();
			psId = connect.prepareStatement(queryId);
			result = psId.executeQuery();
			if(result != null && result.next())
				booking.setId(result.getLong("id"));

		} catch (Exception e) {
			LOGGER.error("Error while creating Booking : " + e.toString(), e);
			booking = null;
		} finally {
			try {
				ps.close();
				connect.close();
			} catch (SQLException e) {
				LOGGER.error("Error while closing DB connection : " + e.toString(), e);
			}
		}
		return booking;
	}

	/**
	 * Gets details for Particular Booking id
	 */
	@Override
	public BookingDTO get(long id) {
		BookingDTO booking = new BookingDTO();
		String query = BookingConstants.BOOKING_GET_QUERY;
		query = query.replaceAll(":id", String.valueOf(id));
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			Class.forName(BookingConstants.JDBC_DRIVER);
			connect = DriverManager.getConnection(BookingConstants.DB_URL, BookingConstants.DB_USER,
					BookingConstants.DB_PASS);
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			if (result != null && result.next()) {
				booking.setId(id);
				booking.setCustomerName(result.getString("name"));
				booking.setRoomType(result.getString("type"));
			} else {
				booking = null;
			}
		} catch (Exception e) {
			LOGGER.error("Error while fetching Booking : " + e.toString(), e);
			booking = null;
		} finally {
			try {
				result.close();
				ps.close();
				connect.close();
			} catch (SQLException e) {
				LOGGER.error("Error while closing DB connection : " + e.toString(), e);
			}
		}
		return booking;
	}

	/**
	 * deletes Particular Booking id
	 */
	@Override
	public boolean delete(long id) {
		boolean status = false;
		String query = BookingConstants.BOOKING_DELETE_QUERY;
		query = query.replaceAll(":id", String.valueOf(id));
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			Class.forName(BookingConstants.JDBC_DRIVER);
			connect = DriverManager.getConnection(BookingConstants.DB_URL, BookingConstants.DB_USER,
					BookingConstants.DB_PASS);
			ps = connect.prepareStatement(query);
			int result = ps.executeUpdate();
			if (result != 0) {
				status = true;
			}
		} catch (Exception e) {
			LOGGER.error("Error while deleting Booking : " + e.toString(), e);
		} finally {
			try {
				ps.close();
				connect.close();
			} catch (SQLException e) {
				LOGGER.error("Error while closing DB connection : " + e.toString(), e);
			}
		}
		return status;
	}

}
