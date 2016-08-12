import java.util.List;

public class ProvideHelpOrder extends Order {
	public List<SubOrder> suborderList;
	public SubOrder suborder;
	public List<SubOrder> CompletedsuborderList;
	
	

	public ProvideHelpOrder(String userId, String status, String orderID, Integer totalAmount,Integer processLevel) {
		super(userId, status, orderID, totalAmount,processLevel);// TODO Auto-generated constructor stub
	}
	
	

	public List<SubOrder> getSuborderList() {
		return suborderList;
	}


	public void setSuborderList(List<SubOrder> suborderList) {
		this.suborderList = suborderList;
	}



	public SubOrder getSuborder() {
		return suborder;
	}



	public void setSuborder(SubOrder suborder) {
		this.suborder = suborder;
	}

	public List<SubOrder> getCompletedsuborderList() {
		return CompletedsuborderList;
	}



	public void setCompletedsuborderList(List<SubOrder> completedsuborderList) {
		CompletedsuborderList = completedsuborderList;
	}


	

}
