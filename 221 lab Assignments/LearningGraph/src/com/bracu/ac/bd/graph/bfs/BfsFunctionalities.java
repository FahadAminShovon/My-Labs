/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bracu.ac.bd.graph.bfs;

import com.bracu.ac.bd.graph.*;
import static com.bracu.ac.bd.graph.readFile.GraphRead.visit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Shovon
 */
public class BfsFunctionalities {
    
    public void runBfs(Vertex s){
        
        
        
     Map<Vertex,Vertex>parent = new HashMap<Vertex,Vertex>();
        parent.put(s, null);
        visit.put(s,0);
        Queue<Vertex> q=new PriorityQueue<Vertex>();
        q.add(s);
        while(q.isEmpty()==false){
            Vertex temp = q.poll();
            ArrayList<Edge> e = temp.getNeighbors();
            int sz = e.size();
            for(int i=0;i<sz;i++){
                Edge top = e.get(i);
                Vertex a = top.getOne();
                Vertex b = top.getTwo();
               if(visit.containsKey(a)==false){
                    int d = visit.get(temp);
                    d++;
                    visit.put(a,d);
                    parent.put(a,temp);
                    q.add(a);
                }
                if(!visit.containsKey(b)){
                    int d = visit.get(temp);
                    d++;
                    visit.put(b,d);
                    parent.put(b,temp);
                    q.add(b);
                }
            }
        }
        
      System.out.println("Vertex  Parent  level");
      //System.out.println(s.getLabel()+"       null      0");
    for (Map.Entry<Vertex, Vertex> entry : parent.entrySet())
  {
      String str="";
      if(parent.get(entry.getKey())==null){
          str = null;
      }
      else str = entry.getValue().getLabel();
    System.out.println(entry.getKey().getLabel()+
            "         " + str+"       "+visit.get(entry.getKey()));
   }
        
    }
    
    
}
