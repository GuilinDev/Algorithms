
public class CalculateEggs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = 1;
		boolean flag = false;
		CalculateEggs ce = new CalculateEggs();
		while (!flag) {
			flag = ce.checkNumber(result);
			result++;
		}
		result--; // offset for last while loop
		System.out.println("Joyce, the number for eggs is: " + result);
		
	}
	public boolean checkNumber(int num) {
		if (num % 1 != 0) {
			return false;
		}
		if (num % 2 != 1) {
			return false;
		}
		if (num % 3 != 0) {
			return false;
		}
		if (num % 4 != 1) {
			return false;
		}
		if (num % 5 != 4) {
			return false;
		}
		if (num % 6 != 3) {
			return false;
		}
		if (num % 7 != 5) {
			return false;
		}
		if (num % 8 != 1) {
			return false;
		}
		if (num % 9 != 0) {
			return false;
		}
		return true;
	}
}
