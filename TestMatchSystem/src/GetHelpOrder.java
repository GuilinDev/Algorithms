import java.util.ArrayList;

public class GetHelpOrder extends Order {
	public String walletAddress;
	public  ArrayList<String> providerUID;
	

	public GetHelpOrder(String userId, String status, String orderID, Integer totalAmount,Integer processLevel) {
		super(userId, status, orderID, totalAmount,processLevel);
	}

	public String getWalletAddress() {
		return walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}

	public ArrayList<String> getProviderUID() {
		return providerUID;
	}

	public void setProviderUID(ArrayList<String> providerUID) {
		this.providerUID = providerUID;
	}
	
}
