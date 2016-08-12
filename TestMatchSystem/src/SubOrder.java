
public class SubOrder {
	public Integer splitmouont;
	public String walletAddress;
	public String status;
	public Integer numberofSplitTime;
	
	public SubOrder(Integer splitmouont, String walletAddress, String status,Integer numberofSplitTime) {
		super();
		this.splitmouont = splitmouont;
		this.walletAddress = walletAddress;
		this.status = status;
		this.numberofSplitTime=numberofSplitTime;
	}

	public Integer getSplitmouont() {
		return splitmouont;
	}

	public void setSplitmouont(Integer splitmouont) {
		this.splitmouont = splitmouont;
	}

	public String getWalletAddress() {
		return walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNumberofSplitTime() {
		return numberofSplitTime;
	}

	public void setNumberofSplitTime(Integer numberofSplitTime) {
		this.numberofSplitTime = numberofSplitTime;
	}
	

}
