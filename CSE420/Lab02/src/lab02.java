import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class lab02 {
	
	
	public static final int start = 0,s1=1,s2=2,s3=3,s4=4,final1=5,invalid1=200;
	static int pState = start;
	
	static localChecker l1;
	static domainChecker d1;
	
	public static String reverser(String str) {
		char arr[] = str.toCharArray();
		str="";
		for(int i=arr.length-1;i>=0;i--)str+=arr[i];
		return str;
	}
	
	
	public static void printer(String a, String b) {
		System.out.println(a+" is "+b);
	}
	
	
	public static boolean localCheck(String str) {
		l1 = new localChecker(str);
		l1.checker();
		return l1.value();
	}	
	
	public static boolean domChecker(String str) {
		d1 = new domainChecker(str);
		d1.checker();
		return d1.value();
	}
	
	public static void readFromFile(String fileName) {
		BufferedReader br = null;
		String line;
		
		try {
			br = new BufferedReader(new FileReader("src\\"+fileName));
			while((line = br.readLine())!=null) {
				String ss = line;
				String a = "valid";
				String b = "invalid";			
				line = reverser(line);
				line = line.replaceFirst("@"," ");
				line = reverser(line);
				String starr[] = line.split(" ");
				if(starr.length==1||starr.length>2) {
					printer(ss,b);
					continue;
				}
				
				if(localCheck(starr[0])) {
					if(domChecker(starr[1]))printer(ss,a);
					else printer(ss,b);
				}
				else printer(ss,b);
			}			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		readFromFile("lab02");
	}

}
