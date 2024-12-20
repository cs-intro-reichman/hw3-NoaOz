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
		if (str1 == "" && str2 == "") {
			return true;
		}
		String newstr1 = preProcess2(str1);
		String newstr2 = preProcess2(str2);
		boolean check = false;
		for (int i = 0; i < newstr1.length(); i++){
			for (int j =0; j < newstr2.length(); j++){
				if (newstr1.charAt(i)==newstr2.charAt(j)){
					check = true;
				}
			}
			if (check==false){
				return false;
			}
	
		}
		return check;
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
	  
	public static String preProcess2(String str) {
		str = preProcess(str); 
		String pre2 = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch != 32){
				pre2 = pre2 + ch ;
			}
		}
		return pre2;
	} 

	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String finalStr = "" ;
		while (str.length() > 0){
			int random = (int)(Math.random()*(str.length()-1));
			finalStr = finalStr + str.charAt(random);
			str = str.substring(0, random) + str.substring(random+1,str.length());
		}
		return finalStr;
			 
    }
	
}
