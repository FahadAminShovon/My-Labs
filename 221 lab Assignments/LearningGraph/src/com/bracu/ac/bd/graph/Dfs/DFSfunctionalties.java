/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bracu.ac.bd.graph.Dfs;

import com.bracu.ac.bd.graph.*;
import static com.bracu.ac.bd.graph.readFile.GraphRead.visit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Shovon
 */
public class DFSfunctionalties {
    int time =0;
    Map<Vertex,Integer> intime =new HashMap<Vertex,Integer>();
    Map<Vertex,Integer> outtime =new HashMap<Vertex,Integer>();
    public void DFS(Vertex v){
        visit.put(v,1);
        time++;
        intime.put(v,time);
        
        ArrayList<Edge> e = v.getNeighbors();
        int sz = e.size();
        
        for(int i=0;i<sz;i++){
            Vertex a = e.get(i).getOne();
            Vertex b = e.get(i).getTwo();
            if(visit.containsKey(a)==false)DFS(a);
            if(visit.containsKey(b)==false)DFS(b);  
        }
        visit.put(v,2);
        time++;
        outtime.put(v,time);
    }
    
    public void printDFS(){
        
        System.out.println("Vertex   InTime   Outtime");
        
   for (Map.Entry<Vertex, Integer> entry : visit.entrySet())
   { 
       Vertex temp=entry.getKey();
       String name=temp.getLabel();
       int it = intime.get(temp);
       int ot = outtime.get(temp);
       System.out.println("  "+name+"        "+it+"        "+ot);
      
   }
    }
    
}
