package assignments;

public class StringReverse {

	public static void main(String[] args) {
		String str = "word";
		char[] c = str.toCharArray();
		System.out.println(str);
		
		for (int i = str.length() -1; i > -1 ; i--) {
			System.out.println(c[i]);
		}

	}

}
