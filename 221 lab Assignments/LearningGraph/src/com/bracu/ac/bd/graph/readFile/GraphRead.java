/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bracu.ac.bd.graph.readFile;

/**
 *
 * @author moin
 */

import com.bracu.ac.bd.graph.*;
import com.bracu.ac.bd.graph.Dfs.DFSfunctionalties;
import com.bracu.ac.bd.graph.bfs.BfsFunctionalities;
import com.bracu.ac.bd.graph.krushkal.krushkal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.*;
import static jdk.nashorn.internal.objects.NativeArray.map;
public class GraphRead {
    
    
    public static void printMatrix(int grarray[][],int n){
        System.out.println("Adjacency Matrix Presentation");
            
            for(int i=0;i<=n;i++){
                System.out.print(i+" ");
            }
            System.out.println();
            
            for(int i=1;i<=n;i++){
                System.out.print(i+" ");
                for(int j=1;j<=n;j++){
                    System.out.print(grarray[i][j]+" ");
                }
                System.out.println();
            }
        
    }
    
    public static void printList(Set<Vertex>ss){
         System.out.println("Adjacency List presentation");
            
            Iterator<Vertex> it = ss.iterator();
            while(it.hasNext()){
            Vertex temp = it.next();
            System.out.print(temp.getLabel()+"->");
             ArrayList<Edge> edd = temp.getNeighbors();
             int sz = edd.size();
             for(int i=0;i<sz;i++){
                 Edge tt=edd.get(i);
                 System.out.print(tt.toString()+" ");
             }
             System.out.println();
            }
    }
    

     public static Map<Vertex,Integer>visit = new HashMap<Vertex,Integer>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        Scanner Sc = new Scanner(System.in);
        Set<Vertex>ss = new HashSet<Vertex>(); 
        
         Graph gr = new Graph();
         int n,e;
         String a = "",b = "",str;
         int weight =1;
        BufferedReader br=new BufferedReader(new FileReader("input.txt"));
        
        
        str = br.readLine();
        Sc = new Scanner(str);
        n = Sc.nextInt();
        e = Sc.nextInt();
        
       // System.out.println(n+" "+e);
        
        
        int grarray[][]=new int[n+1][n+1];
        
        for(int i=0;i<e;i++){
            str = br.readLine();
            Scanner Scc = new Scanner(str);
            int counter=0;
                while(Scc.hasNext()){
                    if(counter==0)a=Scc.next();
                    if(counter==1)b=Scc.next();
                    if(counter==2)weight=Scc.nextInt();
                    
                    counter++;
                }
                
                //System.out.println(a+" "+b+" "+weight);
                
                int c = parseInt(a);
                int d = parseInt(b);
                
                grarray[c][d]=weight;
                grarray[d][c]=weight;
                
                Vertex one = gr.getVertex(a);
                if(one==null)one = new Vertex(a);
                
                Vertex two = gr.getVertex(b);
                if(two==null)two = new Vertex(b);
                
                //System.out.println(one.getLabel()+" "+two.getLabel()+" "+weight);
                gr.addEdge(one,two,weight);
                ss.add(one);
                ss.add(two);
        }
        
   
   

        /*
        //* 
        //*
        taking input from user using Scanner
            n = Sc.nextInt();
            e =  Sc.nextInt();
            Sc.nextLine();
            
            int grarray[][] = new int[n+1][n+1];
            
            for(int i=0;i<e;i++){
                str = Sc.nextLine();
                
                Scanner Scc = new Scanner(str);
                
                int counter=0;
                while(Scc.hasNext()){
                    if(counter==0)a=Scc.next();
                    if(counter==1)b=Scc.next();
                    if(counter==2)weight=Scc.nextInt();
                    
                    counter++;
                }
                
                int c =parseInt(a);
                int d = parseInt(b);
                
                grarray[c][d]=weight;
                grarray[d][c]=weight;
                
                Vertex one = gr.getVertex(a);
                if(one==null)one = new Vertex(a);
                
                Vertex two = gr.getVertex(b);
                if(two==null)two = new Vertex(b);
               
                gr.addEdge(one,two,weight);
                ss.add(one);
                ss.add(two);
            }
        //
        //
            */
            
         
            printList(ss);
            
            printMatrix(grarray,n);
            //System.out.println(ss.size());
           Iterator<Vertex> it = ss.iterator();
           
           System.out.println("BFS Implimentation");
            BfsFunctionalities f = new BfsFunctionalities();
            while(it.hasNext()){
                Vertex v = it.next();
                
                if(visit.containsKey(v)==false){
                    f.runBfs(v);
                }
            }
            visit.clear();
            
            it= ss.iterator();
            DFSfunctionalties d = new DFSfunctionalties();
            while(it.hasNext()){
                Vertex v = it.next();
                if(visit.containsKey(v)==false){
                    d.DFS(v);
                }
            }
            System.out.println("DFS Implimentation");
            d.printDFS();
            
            
            System.out.println("Krushkal Implimentation");
            
            Set<Edge> temp = gr.getEdges();
            
            
            krushkal k = new krushkal(temp);
            
            
            k.make_MST();
            k.printMST();
            

    }
             
        }
        
        
        
        
