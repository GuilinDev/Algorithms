public class Order {
	public String UserId;
	public String Status;
	public String orderID;
	public Integer TotalAmount;
	public Integer processLevel;
	

	public Order(String userId, String status, String orderID, Integer totalAmount,Integer processLevel) {
		super();
		UserId = userId;
		Status = status;
		this.orderID = orderID;
		TotalAmount = totalAmount;
		this.processLevel=processLevel;
	}
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Integer getTotalAmount() {
		return TotalAmount;
	}
	
	public void setTotalAmount(Integer totalAmount) {
		TotalAmount = totalAmount;
	}

	public Integer getProcessLevel() {
		return processLevel;
	}

	public void setProcessLevel(Integer processLevel) {
		this.processLevel = processLevel;
	}
	

}
