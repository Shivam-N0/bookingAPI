package bookingAPI.service;

import bookingAPI.dto.BookingDTO;

/**
 * Booking Service Interface
 */
public interface BookingService {

	/**
	 * Create new booking
	 * 
	 * @param customer
	 * @return
	 */
	public BookingDTO createBooking(BookingDTO customer);

	/**
	 * Gets details of Booking for Booking id
	 * 
	 * @param id
	 * @return
	 */
	public BookingDTO getBookingDetails(long id);

	/**
	 * Deletes Booking for a Booking id
	 * 
	 * @param id
	 * @return
	 */
	public BookingDTO deleteBookingDetail(long id);

}
