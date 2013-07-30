package tao.phys.count;

import tao.phys.count.utils.FindVowels;
import tao.phys.count.utils.InputHelper;

public class CountVowels {

	public static void main(String[] args) {
		String input = InputHelper.getInput("Type in your input.");
		FindVowels.findVowels(input);
	}

}
