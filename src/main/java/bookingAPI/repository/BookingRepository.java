package bookingAPI.repository;

import bookingAPI.dto.BookingDTO;

/**
 * Booking Repository Interface
 */
public interface BookingRepository {

	/**
	 * Creates new Booking
	 * 
	 * @param cutomer
	 * @return
	 */
	public BookingDTO create(BookingDTO cutomer);

	/**
	 * Gets details for Particular Booking id
	 * 
	 * @param id
	 * @return
	 */
	public BookingDTO get(long id);

	/**
	 * deletes Particular Booking id
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(long id);

}
