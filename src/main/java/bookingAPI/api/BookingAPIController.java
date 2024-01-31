package bookingAPI.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	private static final Logger LOGGER = LogManager.getLogger(BookingAPIController.class);

	@Autowired
	BookingService bookingService;
	
	@GetMapping("/health")
	public ResponseEntity<?> getHealth() {
		final HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return  new ResponseEntity<String>("{\"msg\": \"Hello World\"}", HttpStatus.OK);
	}
	

	/**
	 * Returns Booking Details of Booking Id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getBooking(@PathVariable Long id) {
		BookingDTO output = new BookingDTO();
		output = bookingService.getBookingDetails(id);
		LOGGER.info("get Booking output : " + output.toString());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return  new ResponseEntity<BookingDTO>(output,HttpStatus.OK);
	}

	/**
	 * Create new Booking
	 * 
	 * @param requestData
	 * @return
	 */
	@PostMapping(value = "/book")
	public ResponseEntity<?> createBooking(@RequestBody BookingDTO requestData) {
		BookingDTO output = new BookingDTO();
		output = bookingService.createBooking(requestData);
		LOGGER.info("create Booking output : " + output.toString());
		return  new ResponseEntity<BookingDTO>(output,HttpStatus.OK);
	}

	/**
	 * Cancel Booking for a particular Booking id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMapping(@PathVariable Long id) {
		BookingDTO output = new BookingDTO();
		output = bookingService.deleteBookingDetail(id);
		LOGGER.info("delete Booking output : " + output.toString());
		return  new ResponseEntity<BookingDTO>(output,HttpStatus.OK);
	}

}
