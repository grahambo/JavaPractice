package tao.phys.count.utils;

public class FindVowels {
	public static void findVowels(String input){
		char[] letters = input.toCharArray();
		
		Vowel a = new Vowel();
		Vowel e = new Vowel();
		Vowel i = new Vowel();
		Vowel o = new Vowel();
		Vowel u = new Vowel();
		
		for (char c : letters) {
			switch (c) {
			case 'a':
				a.found();
				break;
			case'A':
				a.found();
				break;
			case 'e':
				e.found();
				break;
			case'E':
				e.found();
				break;
			case 'i':
				i.found();
				break;
			case'I':
				i.found();
				break;
			case 'o':
				o.found();
				break;
			case'O':
				o.found();
				break;
			case 'u':
				u.found();
				break;
			case'U':
				u.found();
				break;
			default:
				break;
			}
		}
		System.out.println("a: "+a.getNum());
		System.out.println("e: "+e.getNum());
		System.out.println("i: "+i.getNum());
		System.out.println("o: "+o.getNum());
		System.out.println("u: "+u.getNum());
	}


}
