package bookingAPI.service;

import bookingAPI.dto.BookingDTO;
import bookingAPI.repository.BookingRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Tests Booking Service Implementation
 */
@RunWith(MockitoJUnitRunner.class)
public class BookingServiceImplTest {

	@Mock
	BookingRepository bookingRepository;

	@InjectMocks
	BookingServiceImpl bookingService;

	@Test
	public void testCreateBooking() {
		BookingDTO out = new BookingDTO();
		BookingDTO in = new BookingDTO();
		in.setCustomerName("Max");
		in.setRoomType("BASIC");
		out.setId(10);
		out.setCustomerName("Max");
		out.setRoomType("BASIC");
		Mockito.when(bookingRepository.create(in)).thenReturn(out);
		BookingDTO result = bookingService.createBooking(in);
		assertNotNull(result);

	}

	@Test
	public void testGetBooking() {
		BookingDTO out = new BookingDTO();
		out.setId(10);
		out.setCustomerName("Max");
		out.setRoomType("BASIC");
		Mockito.when(bookingRepository.get(10)).thenReturn(out);
		assertNotNull(bookingService.getBookingDetails(10));
		assertEquals(out.getId(), bookingService.getBookingDetails(10).getId());
	}

	@Test
	public void testDeleteBooking() {
		BookingDTO out = new BookingDTO();
		out.setCustomerName("Max");
		out.setRoomType("BASIC");
		Mockito.when(bookingRepository.get(20)).thenReturn(out);
		Mockito.doReturn(true).when(bookingRepository).delete(20);
		BookingDTO result = bookingService.deleteBookingDetail(20);
		assertEquals(20, result.getId());
	}

}
