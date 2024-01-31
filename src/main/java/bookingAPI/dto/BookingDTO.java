package bookingAPI.dto;

/**
 * BookingDTO
 */
public class BookingDTO {

	private long id;
	private String customerName;
	private String roomType;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "BookingDTO [id=" + id + ", customerName=" + customerName + ", roomType=" + roomType + ", status="
				+ status + "]";
	}
}
