package com.bracu.ac.bd.graph;
import java.util.ArrayList;
import java.util.*;
import java.util.Set;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moin
 */
public class Graph implements GraphInterface{

     Set<Vertex>vr= new HashSet<Vertex>() ;
     Set<Edge>edges=new HashSet<Edge>();
     public Graph(){      
     }
    
    @Override
    public boolean addEdge(Vertex one, Vertex two) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Edge e = new Edge(one,two);
        boolean c = edges.contains(e);
        if(c==true)return false;
        
        edges.add(e);
        
        one.addNeighbor(e);
        two.addNeighbor(e);
        
        vr.add(one);
        vr.add(two);
        
        return true;
    
    }

    @Override
    public boolean addEdge(Vertex one, Vertex two, int weight) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
     Edge e = new Edge(one,two,weight);
     //System.out.println(e.toString());
        boolean c = edges.contains(e);
        if(c==true)return false;
        edges.add(e);
        
        one.addNeighbor(e);
        two.addNeighbor(e);
        
        vr.add(one);
        vr.add(two);
        
        return true;
    
    }

    @Override
    public boolean containsEdge(Edge e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return edges.contains(e);
    }

    @Override
    public Edge removeEdge(Edge e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(edges.contains(e)){    
            edges.remove(e);
            return e;
        }
        
        return null;
    }

    @Override
    public boolean containsVertex(Vertex vertex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        return vr.contains(vertex);
        
    }

    @Override
    public Vertex getVertex(String label) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Iterator<Vertex> it = vr.iterator();
         while(it.hasNext()){
           Vertex v = it.next();
           if(v.getLabel().equals(label))return v;
         }
         
         return null;
    }

    @Override
    public boolean addVertex(Vertex vertex, boolean overwriteExisting) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String str = vertex.getLabel();
        
        Iterator<Vertex> it = vr.iterator();
        while(it.hasNext()){
            Vertex temp = it.next();
            String s = temp.getLabel();
            if(s==str){
                if(overwriteExisting==true){
                    temp=vertex;
                }
                else {
                    vr.add(vertex);
                    return true;
                }
                break;
            }
        }
        return false;
    }

    @Override
    public Vertex removeVertex(String label) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Iterator<Vertex> it = vr.iterator();
        while(it.hasNext()){
            Vertex v = it.next();
            if(v.getLabel().equals(label)){
                Vertex temp = v;
                vr.remove(v);
                return temp;
            }
        }
        return null;
    }

    @Override
    public Set<String> vertexKeys() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Set<String> h = new HashSet<String>();
        
        Iterator<Vertex> it = vr.iterator();
        while(it.hasNext()){
            Vertex v = it.next();
            h.add(v.getLabel());
        }
        return h;
    }

    @Override
    public Set<Edge> getEdges() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Set<Edge> arr = edges;
        return arr;
        
    }
    
}
