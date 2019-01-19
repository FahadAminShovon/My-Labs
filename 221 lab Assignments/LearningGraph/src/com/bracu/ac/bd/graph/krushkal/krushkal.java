/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bracu.ac.bd.graph.krushkal;

import com.bracu.ac.bd.graph.*;
import com.bracu.ac.bd.graph.Disjointset.DisjointSet;
import java.util.*;

/**
 *
 * @author Shovon
 */
public class krushkal {
    
    private ArrayList<Edge> ed;
    DisjointSet dis;
    private ArrayList<Edge> ans ;
    private int sum;

    public krushkal(Set<Edge> a) {
        ed = new ArrayList<Edge>();
        sum =0;
        ans = new ArrayList<Edge>();
        dis = new DisjointSet();
        
        //System.out.println(a.size());
        Iterator<Edge> it = a.iterator();
        int s=0;
        while(it.hasNext()){
          ed.add(it.next());
          //System.out.println(++s);
        }
        Collections.sort(ed);
        
    }
    
    public void makeSets(){
        int sz = ed.size();
        
        for(int i=0;i<sz;i++){
            Edge temp = ed.get(i);
            Vertex a = temp.getOne();
            Vertex b = temp.getTwo();
            dis.make_set(a);
            dis.make_set(b);
        }
    }
    
    
        public void getSum(){
        int sz = ans.size();
        for(int i=0;i<sz;i++){
            Edge temp = ans.get(i);
            sum+=temp.getWeight();
        }
    }
    
    public void make_MST(){
        makeSets();
        int sz = ed.size();
        for(int i=0;i<sz;i++){
            Edge temp = ed.get(i);
            Vertex a = temp.getOne();
            Vertex b = temp.getTwo();
            
            Vertex pA = dis.find_par(a);
            Vertex pB = dis.find_par(b);
            
            if(pA!=pB){
                dis.set_union(pA,pB);
                ans.add(temp);
                
            }
            
        }
        getSum();
    }
    
    
    public int result(){
        return this.sum;
    }
    
    
    public ArrayList<Edge> getMSTedges(){
        return  this.ans;
    }
    
    public void printMST(){
        int sz = ans.size();
        for(int i=0;i<sz;i++){
            Edge temp = ans.get(i);
            System.out.println(temp.toString());
        }
        
        System.out.println("total cost "+result());
        
    }
       
}
