package bookingAPI.api;

import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookingAPI.dto.BookingDTO;
import bookingAPI.service.BookingService;

/**
 * Controller for BookingAPI
 * 
 * @param <T>
 */
@RestController
@RequestMapping(value = "/bookings")
public class BookingAPIController<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingAPIController.class);

	@Autowired
	BookingService bookingService;

	/**
	 * Returns Booking Details of Booking Id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public T getBooking(@PathVariable Long id) {
		BookingDTO output = new BookingDTO();
		output = bookingService.getBookingDetails(id);
		LOGGER.info("get Booking output : " + output.toString());
		return (T) new JSONObject(output.toString());
	}

	/**
	 * Create new Booking
	 * 
	 * @param requestData
	 * @return
	 */
	@PostMapping(value = "/book")
	public T createBooking(@RequestBody Map<String, Object> requestData) {
		String name = requestData.get("name").toString();
		String roomType = requestData.get("roomType").toString();
		BookingDTO output = new BookingDTO();
		BookingDTO input = new BookingDTO();
		input.setCustomerName(name);
		input.setRoomType(roomType);
		output = bookingService.createBooking(input);
		LOGGER.info("create Booking output : " + output.toString());
		return (T) new JSONObject(output.toString());
	}

	/**
	 * Cancel Booking for a particular Booking id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public T deleteMapping(@PathVariable Long id) {
		BookingDTO output = new BookingDTO();
		output = bookingService.deleteBookingDetail(id);
		LOGGER.info("delete Booking output : " + output.toString());
		return (T) new JSONObject(output.toString());
	}

}
