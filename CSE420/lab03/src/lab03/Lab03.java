
package lab03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 *
 * @author Fahad Amin Shovon
 */
public class Lab03 {

    /**
     * @param args the command line arguments
     */
    
    
    
    	public static void readFromFile() {
		BufferedReader br = null;
		String line;
		
		try {
			br = new BufferedReader(new FileReader("src\\lab03\\lab03.txt"));
                        line = br.readLine();
                        int x = Integer.parseInt(line);
                        
                        Pattern[] checkRegex = new Pattern[x];
                        
                        
			for(int i=0;i<x;i++) {
                            line = br.readLine();
                            checkRegex[i]=Pattern.compile(line);
                            //System.out.println(line);
			}
                        
                        
                        int y = Integer.parseInt(br.readLine());
                        String [] str = new String[y];
                        for(int i=0;i<y;i++) {
                            line = br.readLine();
                            str[i]=line;
                            //System.out.println(line);
			}
                        
                        for(int i=0;i<y;i++){
                            String ss = str[i];
                            
                            boolean checker = true;
                            
                            for(int j=0;j<x;j++){
                                if(checkRegex[j].matcher(ss).matches()){
                                    System.out.println("Yes ,"+(j+1));
                                    checker = false;
                                    break;
                                }
                            }
                            
                            if(checker)System.out.println("No "+0);
                            
                        }
                        
                        
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
    
    public static void main(String[] args) {
        readFromFile();
    }
    
}
