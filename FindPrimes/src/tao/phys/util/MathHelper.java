package tao.phys.util;

public class MathHelper {
	public static void findPrime(){
		boolean found = false;
		
		for(int i = currentNumb+1; found == false; i++){
			found = checkNum(i);
		}
	}

	private static boolean checkNum(int i) {
		boolean primeCheck = true;
		for(int j=2; j<i && primeCheck == true; j++){
			switch (i%j) {
			case 0:
				return false;
			default:
				break;
			}
		}
		setCurrentNumb(i);
		return true;
	}
	
	private static int currentNumb = 2;

	public static int getCurrentNumb() {
		return currentNumb;
	}

	private static void setCurrentNumb(int currentNumb) {
		MathHelper.currentNumb = currentNumb;
	}
}
