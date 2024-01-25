package bookingAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookingAPI.constants.BookingConstants;
import bookingAPI.dto.BookingDTO;
import bookingAPI.repository.BookingRepository;

/**
 * Booking Service Implementation
 */
@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	/**
	 * Creates new Booking
	 */
	@Override
	public BookingDTO createBooking(BookingDTO customer) {
		BookingDTO result = new BookingDTO();
		BookingDTO out = new BookingDTO();
		result = bookingRepository.create(customer);
		if (result != null) {
			out.setId(result.getId());
			out.setCustomerName(customer.getCustomerName());
			out.setRoomType(customer.getCustomerName());
			out.setStatus(BookingConstants.SUCCESS_STATUS);
		} else {
			out.setStatus(BookingConstants.UNSUCCESSFUL_STATUS);
		}
		return out;
	}

	/**
	 * Gets details for Particular Booking id
	 */
	@Override
	public BookingDTO getBookingDetails(long id) {
		BookingDTO result = new BookingDTO();
		BookingDTO out = new BookingDTO();
		result = bookingRepository.get(id);
		if (result != null) {
			out.setId(id);
			out.setCustomerName(result.getCustomerName());
			out.setRoomType(result.getRoomType());
			out.setStatus(BookingConstants.BOOKING_FOUND);
		} else {
			out.setId(id);
			out.setStatus(BookingConstants.BOOKING_NOT_FOUND);
		}
		return out;
	}

	/**
	 * deletes Particular Booking id
	 */
	@Override
	public BookingDTO deleteBookingDetail(long id) {
		BookingDTO result = new BookingDTO();
		BookingDTO out = new BookingDTO();
		result = bookingRepository.get(id);
		if (result != null) {
			boolean output = bookingRepository.delete(id);
			if (output)
				out.setId(id);
			out.setStatus(BookingConstants.BOOKING_DELETED);
		} else {
			out.setId(id);
			out.setStatus(BookingConstants.BOOKING_NOT_FOUND);
		}
		return out;
	}

}
