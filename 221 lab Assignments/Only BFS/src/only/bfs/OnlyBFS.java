/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package only.bfs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Shovon
 */
public class OnlyBFS {
    
    
    
    public static Map<String,Integer>visit = new HashMap<String,Integer>();
    public static Map<String,ArrayList<String> > mp = new HashMap<String,ArrayList<String>>();
    
    public static void bfs(String s){
        
        Map<String,String>parent = new HashMap<String,String>();
        System.out.println(s+" is the root");
        
        Queue<String> q = new PriorityQueue<String>();
        q.add(s);
        visit.put(s,0);
        
        while(q.isEmpty()==false){
            String temp = q.poll();
            ArrayList<String> st = mp.get(temp);
            int sz = st.size();
            for(int i=0;i<sz;i++){
                String top = st.get(i);
                if(!visit.containsKey(top)){
                    int d = visit.get(temp);
                    d++;
                    visit.put(top,d);
                    parent.put(top, temp);
                    q.add(top);
                }
            }
        }
        
        System.out.println("Vertex  Parent  level");
        
for (Map.Entry<String, String> entry : parent.entrySet())
{
    System.out.println(entry.getKey() + "         " + entry.getValue()+"       "+visit.get(entry.getKey()));
}
        
        
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner Sc = new Scanner (System.in);
        
        
        
        Set<String> nodes = new HashSet<String>();
        
        
        int n,e;
        String str="";
         BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Shovon\\Desktop//input.txt"));
         str = br.readLine();
         
         Sc = new Scanner(str); 
          n = Sc.nextInt();
          e = Sc.nextInt();
        
        
        for(int i=0;i<e;i++){
            
            str = br.readLine();
            Scanner Scc = new Scanner(str);
            String a = Scc.next();
            String b = Scc.next();
            
            if(mp.containsKey(a)==false){
                ArrayList<String> s = new ArrayList<String>();
                mp.put(a, s);
            }
            if(mp.containsKey(b)==false){
                ArrayList<String> ss = new ArrayList<String>();
                mp.put(b, ss);
            }
            mp.get(a).add(b);
            mp.get(b).add(a);
            nodes.add(a);
            nodes.add(b);
            
        }
        
        Iterator<String> it = nodes.iterator();
        while(it.hasNext()){
            String temp = it.next();
            if(!visit.containsKey(temp)){
                bfs(temp);
                System.out.println("***************************");
            } 
            
        }
        
        
        
        
    }
    
}
