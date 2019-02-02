import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.*;

/*
 * 
 * @Author: B.M.Fahad-ul-Amin
 * 
 * Onek majha peyechi code kore
 * 
 * Date:03/03/19 
 * 
 * Time:12:55AM
 * 
 */


public class lab01 {
	
	
	ArrayList<String> keyWords = new ArrayList<String>();
	
	
	public static final String idWithComasRegx = "^(int|float|String|double|byte|char)[ ]+[^\\d\\s](([{[\\w$_]*]*)*)(,?[ ]*(([{[\\w$_]*]*)*))*;";
	public static final String idwithValueRegx = "(char|int|double|String|byte)[ ]+[^\\d\\s](([{[\\w$_]*]*)*)[ ]*=[ ]*([.]*)";
	public static final String numericValuesRegx = "([-]?([\\d]*[\\.]?[\\d]+))";
	public static final String stringRegx = "\"[\\w\\d\\s\\S]*";
	public static final String charRegx = "'[\\w\\d\\s\\S.]'";
	public static final String keywordsRegx =  "(byte|short|int|float|double|long|char|boolean|String|if|else|else if|for|public|static|void|main)";
	public static final String mathOpRegx = "(\\*)|(\\+\\+)|\\/|\\%|(\\-\\-)|\\-|\\=";
	public static final String conOpRegx = "(>=)|(==)|(<=)|<|>";
	public static final String OtherRegx = "[\\{\\}\\(\\)\\[\\]\\;]";

	
	public static Set<String> keySet = new HashSet<String>();
	public static Set<String> stringSet = new HashSet<String>();
	public static Set<String> charSet = new HashSet<String>();
	public static Set<String> mathOpSet = new HashSet<String>();
	public static Set<String> conOpSet = new HashSet<String>();
	public static Set<String> neumerSet = new HashSet<String>();
	public static Set<String> otherSet = new HashSet<String>();
	public static Set<String> idSet = new HashSet<String>();
	
	public static String idParserforValue(String str) {
		str = str.replaceAll("(int|float|String|double|byte|char)", "").replaceAll("\\=", "");
		return str;
	}
	
	public static String idParserforComma(String str) {
		str = str.replaceAll("(int|float|String|double|byte|char)", "").replaceAll(" ", "").replaceAll(","," ").replaceAll(";", "");
		return str;
	}
	
	public static void Setting(String str, Set<String> ss) {
		String strArr[] = str.split(" ");
		for (String s:strArr)ss.add(s);
	}
	
	public static void printer(String str,Set<String>ls) {
		System.out.print(str+":");
		for(String l: ls) {
			System.out.print(" "+l);
		}
		System.out.println();
	}
	
	public static boolean OthersChecker(String str) {
		String theRegex = OtherRegx;
		
		boolean ret = false;
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str);
		while(regexMatcher.find()) {
			if(regexMatcher.group().length()!=0) {
				Setting(regexMatcher.group().trim(),otherSet);
				ret = true;
			}
		}
		
		return ret;
		
	}
	
	public static boolean conOpChecker(String str) {
		String theRegex = conOpRegx;
		
		boolean ret = false;
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str);
		while(regexMatcher.find()) {
			if(regexMatcher.group().length()!=0) {
				Setting(regexMatcher.group().trim(),conOpSet);
				ret = true;
			}
		}
		
		return ret;
		
	}
	
	public static boolean MathOpChecker(String str) {
		String theRegex = mathOpRegx;
		
		boolean ret = false;
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str);
		while(regexMatcher.find()) {
			if(regexMatcher.group().length()!=0) {
				Setting(regexMatcher.group().trim(),mathOpSet);
				ret = true;
			}
		}
		
		return ret;
		
	}

	
	
	
	public static boolean CharChecker(String str) {
		String theRegex = charRegx;
		
		boolean ret = false;
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str);
		while(regexMatcher.find()) {
			if(regexMatcher.group().length()!=0) {
				Setting(regexMatcher.group().trim(),charSet);
				ret = true;
			}
		}
		
		return ret;
		
	}
	
	
	public static boolean StringChecker(String str) {
		String theRegex = stringRegx;
		
		boolean ret = false;
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str);
		while(regexMatcher.find()) {
			if(regexMatcher.group().length()!=0) {
				String strr = regexMatcher.group().trim();
				strr=strr.replaceAll(";", "");
				Setting(strr,stringSet);
				ret = true;
			}
		}
		
		return ret;
		
	}

	public static boolean neumericChecker(String str) {
		String theRegex = numericValuesRegx;
		
		boolean ret = false;
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str);
		while(regexMatcher.find()) {
			if(regexMatcher.group().length()!=0) {
				//System.out.println(regexMatcher.group().trim());
				Setting(regexMatcher.group().trim(),neumerSet);
				ret = true;
			}
		}
		
		return ret;
		
	}
	
	public static boolean identifierWithValueChecker(String str) {
		String theRegex = idwithValueRegx;
		
		boolean ret = false;
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str);
		while(regexMatcher.find()) {
			if(regexMatcher.group().length()!=0) {
				String strr = regexMatcher.group().trim();
				strr = idParserforValue(strr);
				Setting(strr,idSet);
				ret = true;
			}
		}
		
		return ret;
		
	}
	
	
	public static boolean identifiercommaChecker(String str) {
		String theRegex = idWithComasRegx;
		
		boolean ret = false;
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str);
		while(regexMatcher.find()) {
			if(regexMatcher.group().length()!=0) {
				String strr = regexMatcher.group().trim();
				strr = idParserforComma(strr);
				Setting(strr,idSet);
				ret = true;
			}
		}
		
		return ret;
		
	}
	
	public static boolean keywordChecker(String str) {
		String theRegex =keywordsRegx;
		
		boolean ret = false;
		
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str);
		while(regexMatcher.find()) {
			if(regexMatcher.group().length()!=0) {
				Setting(regexMatcher.group().trim(),keySet);
				ret = true;
			}
		}
		
		return ret;
		
	}
	
	public static String perserForneumeric(String str) {
		
		
		for(String ss:idSet) {
			str = str.replaceAll(ss, "");
		}
		
		str = str.replaceAll(charRegx, "");
		str = str.replaceAll(stringRegx, "");
		
		
		return str;
	}
	
	public static void checker(String str) {
		keywordChecker(str);
		MathOpChecker(str);
		conOpChecker(str);
		OthersChecker(str);
		identifierWithValueChecker(str);
		identifiercommaChecker(str);
		StringChecker(str);
		CharChecker(str);
		str=perserForneumeric(str);

		neumericChecker(str);
		
	}
	
	public static void readFromFile(String fileName) {
		BufferedReader br = null;
		String line;
		
		try {
			br = new BufferedReader(new FileReader("src\\"+fileName+".txt"));
			while((line = br.readLine())!=null) {
				checker(line);
			}			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		readFromFile("task1");
		printer("KeyWords",keySet);
		printer("Identifiers",idSet);
		printer("String values",stringSet);
		printer("Character values",charSet);
		printer("Mathematical operators",mathOpSet);
		printer("Logical operators",conOpSet);
		printer("Numerical values",neumerSet);
		printer("Others",otherSet);
	}

}
