import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		List<ProvideHelpOrder> createPHOrder = createPHOrder();
		List<GetHelpOrder> createghOrder = createghOrder();
		MatchManager manager= new MatchManager();
		List<ProvideHelpOrder> splitOrder = manager.splitOrder(createPHOrder);
		Pool p2 = new Pool();
		Pool p1 = new Pool();
		List<ProvideHelpOrder> p2L= new ArrayList<ProvideHelpOrder >();
		p2.setPHOrderList(p2L);
		p1.setPHOrderList(splitOrder);
		ActivePool activePool = new ActivePool();
		List<ProvideHelpOrder> activePL= new ArrayList<ProvideHelpOrder >();
		activePool.setPHOrderList(activePL);
		int breakGH= 0;
		for(int i=0;i<createghOrder.size();i++){
			GetHelpOrder getHelpOrder = createghOrder.get(i);
			for(;;){
				if(p1.getPHOrderList().isEmpty()&&p2.getPHOrderList().isEmpty()){
					break;
				}
				if(getHelpOrder.getTotalAmount()==0){
					break;
				}
				
			getHelpOrder = manager.runOnPool(p1, p2, getHelpOrder, activePool, "system",false);
		   
			if(getHelpOrder.getTotalAmount()>0);{
			getHelpOrder = manager.runOnPool(p1, p2, getHelpOrder, activePool, "system",true);
			
		    }	
			}
			if(getHelpOrder.getTotalAmount()>0){
				breakGH=i;//know which GH has break
				System.out.println("GH has remain");
				break;
			}
		}
		if(breakGH!=0){
			System.out.println("GH stops at "+breakGH+" order");
		}
		if(!p1.getPHOrderList().isEmpty()){
			System.out.println("PH has remain:"+splitOrder.size());
		}
		getInfoFromActivePool(activePool);
 		
		}


	private static List<ProvideHelpOrder> createPHOrder() {
		List<ProvideHelpOrder> PHOrderList= new ArrayList<ProvideHelpOrder>();
		for(int i=0;i<50;i++){
			//userId, status, orderID, totalAmount,processLevel
			String userid= new String("user"+1);
			String status="incompleted";
			Integer orid=2000+i;
			String orderid= new String("ph/"+orid.toString());
			int totalAomount= getRandomNumber(10,90)*10;
		//	int totalAomount=(i+5)*100;
		    int	processLevel=0;
		    List<SubOrder> CompletedsuborderList = new ArrayList<SubOrder>();
		    ProvideHelpOrder ph = new ProvideHelpOrder(userid, status, orderid, totalAomount, processLevel);
		    ph.setCompletedsuborderList(CompletedsuborderList);
		    PHOrderList.add(ph);
		    System.out.println(orderid+":"+totalAomount);
			}
		return PHOrderList;
	}
	
	private static List<GetHelpOrder> createghOrder() {
		List<GetHelpOrder> PHOrderList= new ArrayList<GetHelpOrder>();
		  /*GetHelpOrder gh1 = new GetHelpOrder("UserFirst", "", "gh/1000", 7000, 0);
		  gh1.setWalletAddress("wallet0");
		  PHOrderList.add(gh1);*/
		for(int i=0;i<60;i++){
			//userId, status, orderID, totalAmount,processLevel
			String userid= new String("user"+1);
			String status="incompleted";
			Integer orid=1000+i; 
			String orderid= new String("gh/"+orid.toString());
			int totalAomount= getRandomNumber(10,90)*10;
		//	int totalAomount=(i+7)*100;
		    int	processLevel=0;
		    String walletAddress= new String("wallet"+i);
		    GetHelpOrder ph = new GetHelpOrder(userid, status, orderid, totalAomount, processLevel);
		    ph.setWalletAddress(walletAddress);
		    System.out.println(orderid+" : "+totalAomount+" wallet: "+walletAddress);
		    PHOrderList.add(ph);
			}
		return PHOrderList;
	}
		 
		
	public static Integer getRandomNumber(int start,int range){
		Random ran = new Random();
		int x = ran.nextInt(range)+start;
		return x;
	}
	
	public static String getInfoFromActivePool(Pool activePool){
		
		for(int i=0;i<activePool.getPHOrderList().size();i++){
			ProvideHelpOrder provideHelpOrder = activePool.getPHOrderList().get(i);
			List<SubOrder> completedsuborderList = provideHelpOrder.getCompletedsuborderList();
			System.out.println(".................................");
			System.out.println(provideHelpOrder.getOrderID()+"has :");
			for(SubOrder sub:completedsuborderList){
				String wl=sub.getWalletAddress();
				int amout=sub.getSplitmouont();
				if(amout!=0){
				System.out.println("wallet:"+wl+" /need:"+amout);
				}
			}
		}
		activePool.getPHOrderList();
		return null;
		
	}

}
