/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		String newstr1 = ""; 
		String newstr2 = "";
		for (int i=0; i<str1.length(); i++){
			char ch = str1.charAt(i);
			if (ch != 32){
				newstr1 = newstr1 + ch; 
			}
		}
		str2 = preProcess(str2);
		for (int i=0; i<str2.length(); i++){
			char ch = str2.charAt(i);
			if (ch != 32){
				newstr1 = newstr2 + ch; 
			}
		}

		String check = "";
		if (newstr1.length() != newstr2.length()) {
			return false;
		}
		for (int i = 0; i < newstr1.length(); i++){
			for(int j = 0 ; j < newstr2.length(); j++){
				{
					if (newstr1.charAt(i) == newstr2.charAt(j)){
					check = check + newstr1.charAt(i);
					break;
				}
			}
			}
		}
		if (check.length() == newstr2.length()){
			return true; 
		}
		return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase(); 
		String pre = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ((ch >= 97 && ch <= 122) || ch == 32){
				pre = pre + ch ;
			}
		}
		return pre;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int random = 0;
		String str2 = "";
		String check = str; 
		for (int i = 0; i < str.length()-1; i++){
			random = i + (int) (Math.random() * (str.length()-i));
			str2 = str2 + str.charAt(random);
			check = "";
			for (int j = 0; j < str.length(); j++){
				if (j != random) {
					check = check + str.charAt(j);

				}
			}
			str = check;
			
		}
		return str2;
	}
}
