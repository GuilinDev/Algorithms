import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MatchManager {
	
	
	public List<ProvideHelpOrder> splitOrder(List<ProvideHelpOrder> listPhOrder) {
		for (int i=0;i<listPhOrder.size();i++){
			Integer totalAmount = listPhOrder.get(i).getTotalAmount();
			int[] splitAmount = splitAmount(totalAmount);
			ArrayList<SubOrder> suborderList = new ArrayList<SubOrder>();
			System.out.println(listPhOrder.get(i).getOrderID());
			for(int k=0;k<splitAmount.length;k++){
				int spAmount =splitAmount[k];
				SubOrder subOrder= new SubOrder(spAmount, "", "",0);
				suborderList.add(subOrder);
				System.out.println(spAmount);
				
			}
			listPhOrder.get(i).setSuborderList(suborderList);
		}
		return listPhOrder;
	}
	
	public static int[] splitAmount(Integer Totalamount){
		int parts = getSplictNumber();
		return getRandSum(parts,10,Totalamount);
		 
	}
	
	public static Integer getRandomNumber(int start,int range){
		//System.out.println(range+"and start"+start);
		Random ran = new Random();
		int x = ran.nextInt(range)+start;
		return x;
	}
	
	public static Integer getSplictNumber(){
		// if the amount > 9000, at least two orders
		// Add above logic
		int random= getRandomNumber(1,100);
		if(random>=0&&random<20)	{
			return getRandomNumber(1,1);
		}
		if(random>=20&&random<70)	{
			return getRandomNumber(2,2);
		}
		
		return 4;
	}
	
	public static int[] getRandSum(int numParts, int minimum, int Total) {
		int n=numParts;
		int m=Total/10;
		int min=minimum/10;
	    Random rand = new Random();
	    int[] nums = new int[n];
	    int[] decNums = new int[n];
	    int max = m - min*n;
	    if(max <= 0)
	        throw new IllegalArgumentException();
	    for(int i=1; i<nums.length; i++) {
	        nums[i] = rand.nextInt(max);
	    }
	    Arrays.sort(nums, 1, nums.length);
	    for(int i=1; i<nums.length; i++) {
	        nums[i-1] = nums[i]-nums[i-1]+min;
	    }
	    nums[nums.length-1] = max-nums[nums.length-1]+min;
	    for(int i=0; i<nums.length; i++) {
	    	decNums[i] = nums[i]*10;
	    }
	    return decNums;
	}
	
	private static boolean cleanEmptySub(ActivePool activePool, List<ProvideHelpOrder> maxSubList) {
		for(int i=0;i<maxSubList.size();i++){
		ProvideHelpOrder provideHelpOrder = maxSubList.get(i);
		if(provideHelpOrder.getSuborderList().size()==0){
			 maxSubList.remove(i);
		}
		
		}
		if(maxSubList.size()==0){
			return false;
		}else
			return true;
		
	}

	
	private static void addSubList(ProvideHelpOrder provideHelpOrder, SubOrder subod) {
	
			provideHelpOrder.getCompletedsuborderList().add(subod);
		
	}
	
	
	public static void sortgetHelpOrder(List<ProvideHelpOrder> PHOrderList){
		Collections.sort(PHOrderList, new Comparator<ProvideHelpOrder>(){
			   public int compare(ProvideHelpOrder o1, ProvideHelpOrder o2){
			      return o1.getProcessLevel() - o2.getProcessLevel();
			   }
			});
	}
	
	
	public static List<ProvideHelpOrder> getMaxSubList(List<ProvideHelpOrder> PHOrderList){
		int maxLevel=PHOrderList.get(PHOrderList.size()-1).getProcessLevel();
		List<ProvideHelpOrder> MaxLevelPHOrderList= new ArrayList<ProvideHelpOrder>();
		for(int i=PHOrderList.size()-1;i>=0;i--){
			if(PHOrderList.get(i).getProcessLevel()==maxLevel){
				MaxLevelPHOrderList.add(PHOrderList.get(i));
			}else{
				break;
			}
		}
		
		return MaxLevelPHOrderList;
	}
	
	
	
	public GetHelpOrder runOnPool(Pool pool1,Pool pool2,GetHelpOrder getHelpOrder,ActivePool activePool,String systemWallet,boolean needPool1){
		Pool realPool=null;
		if(needPool1){
			realPool=pool1;
		}else {
 			realPool=pool2;
		}
		List<ProvideHelpOrder> OrderList = realPool.getPHOrderList();
		for(;;){
			int totalAmountt= getHelpOrder.getTotalAmount();
		//	System.out.println(totalAmountt);
			if(cleanEmptySub(activePool,OrderList)){
			int ran=getRandomNumber(0,OrderList.size());
			ProvideHelpOrder provideHelpOrder = OrderList.get(ran);
	    	List<SubOrder> suborderList = provideHelpOrder.getSuborderList();
	    	if(suborderList.size()==0){
	    		OrderList.remove(ran);
	    		break;
	    	}
	    //	System.out.println("SUB:"+suborderList.size());
	    	   int	ran2=getRandomNumber(0,suborderList.size());
	    		SubOrder subOrder = suborderList.get(ran2);
	    		int subAmount=subOrder.getSplitmouont();
	    		Integer numberofSplitTime = subOrder.getNumberofSplitTime();
	    		int totalAmountHP= getHelpOrder.getTotalAmount();
	    		if(subAmount>totalAmountHP){
	    			getHelpOrder.setStatus("completed");
	    			getHelpOrder.setTotalAmount(0);
	    			
	    			SubOrder subod= new SubOrder(totalAmountHP, getHelpOrder.getWalletAddress(), "completed", 0);
	    			addSubList(provideHelpOrder, subod);
	    			int provideHelpRest= subAmount-totalAmountHP;
	    				  if (numberofSplitTime==0){
	    					  SubOrder restSub= new SubOrder(provideHelpRest, "", "Pending",1);
	    					  suborderList.remove(ran2);
	    					  suborderList.add(restSub);
	    					  if(needPool1){
	    						  pool2.getPHOrderList().add(provideHelpOrder);
	    					  }					  
	    				  }else {
	    					  SubOrder  systemSub= new SubOrder(provideHelpRest, systemWallet, "completed",2);
	    					  suborderList.remove(ran2);
	    					  provideHelpOrder.getCompletedsuborderList().add(systemSub);
	    					  if(suborderList.isEmpty()){
	    						  activePool.getPHOrderList().add(OrderList.remove(ran));
	    					  }else {
	    						  if(needPool1){
	    						  pool2.getPHOrderList().add(provideHelpOrder);
	    						  }
	    					  }
	    				  }
	    				  break;
	    		}
	    		else { 
	    			  SubOrder remove = suborderList.remove(ran2); 
	    			  remove.setWalletAddress(getHelpOrder.getWalletAddress());
	    			  provideHelpOrder.getCompletedsuborderList().add(remove);
	    			  if(suborderList.isEmpty()){
	    				  activePool.getPHOrderList().add(OrderList.remove(ran));
	    			  }else {
						  if(needPool1){
						  pool2.getPHOrderList().add(provideHelpOrder);
						  }
					  }
	    			getHelpOrder.setTotalAmount(totalAmountHP-subAmount);
	    		}
	    	
		}
		else{
			break;
		}
		}
		
		return getHelpOrder;
	}
	
	public GetHelpOrder runForRemain(Pool p2,GetHelpOrder getHelpOrder,String systemWallet){
		int remain=getHelpOrder.getTotalAmount();
		for (int i=0;i<p2.getPHOrderList().size();i++){
			ProvideHelpOrder provideHelpOrder = p2.getPHOrderList().get(i);
			provideHelpOrder.getSuborderList();
			   
				
		}
        
		return null;
		
	}
	
	
	
	
	
}
    
    
    
    
    
    
    
    
    
    

