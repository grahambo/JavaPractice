package tao.phys.findprimes;

import tao.phys.util.InputHelper;
import tao.phys.util.MathHelper;

public class Main {

	public static void main(String[] args) {
		String getNext = InputHelper.getInput("Next prime? y/n ");
		if(getNext.equals("y")){
			System.out.println(2);
			getNext = InputHelper.getInput("Next prime? y/n ");
		}
		while(getNext.equals("y")){
			MathHelper.findPrime();
			System.out.println(MathHelper.getCurrentNumb());
			getNext = InputHelper.getInput("Next prime? y/n ");
		}
	}

}
