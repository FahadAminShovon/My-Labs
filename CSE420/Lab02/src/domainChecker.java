/**
 * 
 */

/**
 * @author $Fahad-ul-Amin
 *
 * $Onek majha pelum
 */
public class domainChecker {
	
	private static String str;
	
	public static final int start = 0,s1=1,s2=2,s3=3,s4=4,final1=5,invalid1=200;
	static int pState = start;
	
	public domainChecker(String str) {
		this.str = str;
		this.pState=0;
	}
	
	public static boolean specialCharDigitChecker(char a) {
		char arr[] = {'@','#','$','%','^','&','*','(',')',' ','{','}','[',']','\\','?','!','"','/','_','-','~'};
		if(Character.isDigit(a))return true;
		for(int i=0;i<arr.length;i++)
			if(a==arr[i])
				return true;
		
		return false;
	}
	
	
	public static void charChecker(char a) {
		if(pState==start) {
			if(specialCharDigitChecker(a)||a=='.')pState=invalid1;
			else if(Character.isLetter(a))pState=s1;
		}
		else if(pState == s1) {
			if(specialCharDigitChecker(a)||Character.isDigit(a))pState=invalid1;
			else if(Character.isLetter(a))pState=s1;
			else if(a=='.')pState=s2;
		}
		else if(pState==s2) {
			if(specialCharDigitChecker(a)||a=='.')pState=invalid1;
			else if(Character.isLetter(a))pState=final1;
		}
		else if(pState==final1) {
			if(specialCharDigitChecker(a))pState=invalid1;
			else if(Character.isLetter(a))pState=final1;
			else if(pState=='.')pState=s2;
		}
	}
	
	public static void checker() {
		char arr[] = str.toCharArray();
		for(int i=0;i<arr.length;i++) {
			char a = arr[i];
			charChecker(a);
			
		}
	}
	
	
	public static boolean value() {
		if(pState==final1)return true;
		return false;
	}
	

}
