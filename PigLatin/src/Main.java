import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		String phrase = getInput("What would you like to translate?");
		String[] parsed = phrase.split(" ");
		
		System.out.println(translate(parsed));
		
	}
	private static String translate(String[] parsed) {
		ArrayList<Character> vowels = new ArrayList<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		
		ArrayList<Character> punc = new ArrayList<Character>();
		punc.add('.');
		punc.add('?');
		punc.add(',');
		punc.add(';');
		punc.add(':');
		
		ArrayList<Character> word = new ArrayList<Character>();
		StringBuilder transString = new StringBuilder();
		char tempPunc = '.';
		boolean puncCheck = false;

		for (int i = 0; i < parsed.length; i++) {
//			loops though every word in the text and clears out the
//			word character array
			
			word.clear();
			for(char c: parsed[i].toCharArray()){
//				creates array of individual letters in word
				if(punc.contains(c)){
					tempPunc = c;
					puncCheck = true;
				}
				else{
					word.add(c);
				}
			}
			for (int j = 0; j < word.size(); j++) {
//				loops through every character in word and checks if it is a vowel
//				checks for 1 letter words like "I" and "a" and handles them special
//				if not a vowel -- move character to end
//				if it is a vowel -- append "ay", reassemble characters into word
//					with a space, and break
//				also checks for common punctuation and holds the character until the 
//					end to append on before space
				if(word.size()==1){
					transString.append(word.get(0));
					transString.append("yay ");
					break;
				}else if(vowels.contains(word.get(0))
						|| (word.size()==2 && word.get(0) == 'y')){
					word.add('a');
					word.add('y');
					
					
					for(int k=0; k< word.size();k++){
						transString.append(word.get(k));
					}
					if (puncCheck == true){
						transString.append(tempPunc);
						puncCheck = false;
					}
					transString.append(" ");
					break; 
				}
				else{
					word.add(word.get(0));
					word.remove(0);
				}
			}
			
		}
		
		return transString.toString();
	}
		
	private static String getInput(String prompt){
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.print(prompt);
		System.out.flush();
		
		try {
			return stdin.readLine();
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}
}
