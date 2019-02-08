/**
 * 
 */

/**
 * @author $Fahad-ul-Amin
 *
 * $Onek majha pelum
 */
public class localChecker {
	
	private static String str ;
	
	public localChecker(String str) {
		this.str = str+"@";
		this.pState=start;
	}
	
	public static final int start = 0,s1=1,s2=2,s3=3,s4=4,final1=5,invalid1=200;
	static int pState = start;
	
	
	public static boolean specialCharChecker(char a) {
		char arr[] = {'@','#','$','%','^','&','*','(',')',' ','{','}','[',']','\\','?','!','/','~'};
		for(int i=0;i<arr.length;i++)
			if(a==arr[i])
				return true;
		
		return false;
	}
	
	public static boolean AllowedspChar(char a) {
		char arr[] = {'-','_'};
		for(int i=0;i<arr.length;i++)
			if(a==arr[i])
				return true;
		
		return false;
	}
	
	public static boolean ldChecker(char a) {
		if(Character.isDigit(a)||Character.isLetter(a))return true;
		return false;
	}
	
	public static boolean quotedspCharChecker(char a) {
		
		char arr[] = {'(',')',',',':',';','<','>','@','[',']'};
		for(int i=0;i<arr.length;i++)
			if(a==arr[i])
				return true;
		
		return false;
	}
	
	public static void checkChar(char a) {
		
		if(pState==start) {
			if(specialCharChecker(a)||a=='.') pState = invalid1;
			else if(ldChecker(a)||AllowedspChar(a)) pState = s3;
			else if(a=='"') pState = s1;
		}
		else if(pState==s1) {
			if(a=='"')pState=s3;
			else if(a=='\\')pState=s2;
			else if(ldChecker(a)||quotedspCharChecker(a)||AllowedspChar(a)||a=='.')pState=s1;
			else pState=invalid1;
			
		}
		else if(pState==s2) {
			if(a=='\\'||a=='"')pState=s1;
			else pState=invalid1;
		}
		else if(pState==s3) {
			if(a=='@')pState=final1;
			else if(a=='.')pState=s4;
			else if(a=='"')pState=s1;
			else if(specialCharChecker(a)) pState = invalid1;
			else if(ldChecker(a)||AllowedspChar(a)) pState = s3;
		}
		else if(pState==s4) {
			if(a=='.')pState=invalid1;
			if(a=='"')pState=s1;
			else if(specialCharChecker(a)) pState = invalid1;
			else if(ldChecker(a)||AllowedspChar(a)) pState = s3;
		}
		else if(pState==final1) {
			pState=invalid1;
		}
		
		
	}
	
	public static void checker() {
		//System.out.print(str);
		char carr[] = str.toCharArray();
		
		for(int i=0;i<carr.length;i++) {
			if(pState==invalid1)return;
			checkChar(carr[i]);
		}
		
	}
	
	
	public static boolean value() {
		if(pState==final1)return true;
		return false;
	}
	
	
	

}
