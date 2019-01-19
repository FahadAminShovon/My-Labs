/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bracu.ac.bd.graph.Disjointset;

import com.bracu.ac.bd.graph.Vertex;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Shovon
 */
public class DisjointSet {
     Map<Vertex,Vertex>par = new HashMap<Vertex,Vertex>();
     
     public void make_set(Vertex a){
         par.put(a,a);
     }
     
     public Vertex find_par(Vertex a){
         Vertex temp = par.get(a);
         if(temp==a)return a;
         return par.put(a,find_par(temp));
     }
     
     public void set_union(Vertex a,Vertex b){
         Vertex u = find_par(a);
         Vertex v = find_par(b);
         
         par.put(u,v);
     }    
}
