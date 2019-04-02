import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 
 */

/**
 * @author $Fahad-ul-Amin
 *
 * $Onek majha pelum
 */
public class lab05 {
	
	
	
   public static HashMap<String,ArrayList<HashMap<String,String>>> columns  = new HashMap<String,ArrayList<HashMap<String,String>>>();
   public static HashMap<Character,Integer> checker = new HashMap<Character,Integer>();
   public static Stack<Character> ss = new Stack<Character>(); 
   
   public static String stringer(char a) {
	   String str = "";
	   str+=a;
	   return str;
   }
   
   public static String printer(String a) {
	   String str1 = "";
	   char aArry[] = a.toCharArray();
	   
	   for(int i=0;i<aArry.length;i++) {
		   if(aArry[i]=='X')str1+="E'";
		   else if(aArry[i]=='Y')str1+="T'";
		   else if(aArry[i]=='i')str1+="id";
		   else str1+=aArry[i];
		   
	   }
	   
	   return str1;
	   
   }
   
   
   public static void processor(char a) {
	   
	   ArrayList<HashMap<String,String>> tempList = columns.get(stringer(a));
	   
	   while(ss.peek()!=a) {
		   
		   String str = stringer(ss.pop());
		   
		   for(int i=0;i<tempList.size();i++) {
			   if(tempList.get(i).containsKey(str)) {
				   String strr = tempList.get(i).get(str) ;
				   
				   if(strr!="e") {
					   for(int j=strr.length()-1;j>=0;j--) {
						   ss.push(strr.charAt(j));
					   }
				   }
				   
				   System.out.println("output "+printer(str)+"-->"+printer(strr));
				   break;
				   
			   }
		   }   
	   }
	   
	   
	   System.out.println("Matched "+printer(stringer(ss.pop())));
	   

	   
   }
   
	public static void processing(String str) {
		str = str.replaceAll("id", "i");
	//	System.out.println(str);
		str+="$";
		ss.clear();
		ss.push('$');
		ss.push('E');
		
		char arr[] = str.toCharArray();
		
		for(char a: arr) {
			//System.out.println(a);
			processor(a);
		}
	}
	
	
	public static void readFromFile(String fileName) {
		BufferedReader br = null;
		String line;
		
		try {
			br = new BufferedReader(new FileReader("src\\"+fileName));
			
			int x =Integer.parseInt(br.readLine());
			
			for(int i=0;i<x;i++) {
				line = br.readLine();
				processing(line);
				//System.out.println(line);

			}			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void setter(String a, String b, String c) {
		
		HashMap<String,String> xx  =new HashMap<String,String>();
		xx.put(b, c);
		if(columns.containsKey(a)==false) {
			ArrayList<HashMap<String,String>> yy= new ArrayList<HashMap<String,String>>();
			yy.add(xx);
			columns.put(a, yy);
		}
		else {
			columns.get(a).add(xx);
		}
	}

	
	public static void loader() {
		setter("i","E","TX");
		setter("i","T","FY");
		setter("i","F","i");
		setter("+","X","+TX");
		setter("+","Y","e");
		setter("*","Y","*FY");
		setter("(","E","TX");
		setter("(","T","FY");
		setter("(","F","(E)");
		setter(")","E","e");
		setter(")","Y","e");
		setter("$","E","e");
		setter("$","Y","e");	
	}
	
	
	public static void tablePrinter() {
		for (String key : columns.keySet()) {
			System.out.println(key);
			
			ArrayList<HashMap<String,String>> xx = columns.get(key);
			
			for(int i=0;i<xx.size();i++) {
				HashMap<String,String> yy = xx.get(i);
				
				for(String j : yy.keySet()) {
				System.out.println(j+"->"+yy.get(j));
				}
				
			}
			
			System.out.println("==============================");
		}
			
	}
	
	
	public static void main(String [] args) {	
		loader();
		readFromFile("lab5");
		//tablePrinter();
	}

}
