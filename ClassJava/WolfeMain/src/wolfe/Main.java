package wolfe;

public class Main {

	public static void main(String[] args) {

		toPigLatin("apple");
		toPigLatin("therapy");
		toPigLatin("yellow");
		toPigLatin("school");
		toPigLatin("quick run fast");
	}

	public static String toPigLatin(String string) {
		int alpha = 0;
		String start = "";
		String end = "";
		String pLatinFull = "";
		int vwlPoint = 0;
		int counter1 = 0;
		int counter2 = 0;
		
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		String[] words = string.split("[^a-z]");
		String[] pLatin = new String[words.length];
		
		int j = 0;
		for (int i = 0; i < words.length; i++) {
			
			for (j = 0; j < words[i].length(); j++) {
				for (int k = 0; k < vowels.length; k++) {
					
					if (words[i].charAt(j) == vowels[k]) {
						int omega = words[i].length();
						vwlPoint = j;
						
						if (alpha != vwlPoint || alpha == vwlPoint) {
							start = words[i].substring(vwlPoint, omega);
							end = words[i].substring(alpha, vwlPoint) + "ay";
							pLatin[i] = start+end;	
							
							counter1++;
							counter2++;
						}
						
					}
					
				}
				if(counter1 == 1) {
					break;
				}
			}
			pLatinFull = pLatinFull + " " + pLatin[i];	
		}
		System.out.println(pLatinFull);
		return pLatinFull;
	}
}
