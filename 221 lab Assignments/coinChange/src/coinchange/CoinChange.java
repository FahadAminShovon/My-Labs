/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinchange;

/**
 *
 * @author Shovon
 */

import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class CoinChange {

    /**
     * @param args the command line arguments
     */
    
    public static int n;
    public static int dp[][]=new int[100][10000];
    public static int coin[]=new int[100];
    public static int nCoin[]=new int[100000];
    public static int vCoin[]=new int[100000];
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("input");
        BufferedReader br = new BufferedReader(fr); ;
        Scanner sc;
        String str = br.readLine();
        sc = new Scanner(str);
        n = sc.nextInt();
        //System.out.println(n);
        str = br.readLine();
        
        sc = new Scanner(str);
        
        for(int i=0;i<n;i++){
            coin[i]=sc.nextInt();
            //System.out.println(coin[i]);
        }
        str = br.readLine();
        sc = new Scanner(str);
        int q=sc.nextInt();
        
        clear();
        
        for(int i=0;i<q;i++){
            str = br.readLine();
            sc=new Scanner(str);
            int m = sc.nextInt();
            //System.out.println(m);
            System.out.println("Ways to make the value :"+coinchange(0,m));
            minCoinChange(m);
            System.out.println("Minimum coins needed :"+nCoin[m]);
            printMinCoin(m);
            
        }
        
        
        
    }
    
    public static void clear(){
        
        for(int i=0;i<n;i++)
            for(int j=0;j<10000;j++)
                dp[i][j]=-1;
        
        nCoin[0]=0;
        vCoin[0]=-1;
        
        for(int i=1;i<100000;i++){
            nCoin[i]=Integer.MAX_VALUE-1;
            vCoin[i]=-1;
        }
        
    }
    
    public static void printMinCoin(int m){
        System.out.println("coins used ");
        while(m!=0){
        int ans = vCoin[m];
        System.out.println(ans);
        m=m-ans;
        }
        
    }
    
    public static void minCoinChange(int make){
        
        for(int i=0;i<n;i++){
            int c = coin[i];
            for(int j=0;j<=make;j++){
                if(c<=j){
                    if(nCoin[j-c]+1<nCoin[j]){
                        nCoin[j]=nCoin[j-c]+1;
                        vCoin[j]=coin[i];
                    }
                }
            }
        }
    }
    
    public static int coinchange(int i,int amount){
        if(i>=n){
            if(amount==0)return 1;
            return 0;
        }
        if(dp[i][amount]!=-1)return dp[i][amount];
        int ret1=0,ret2=0;
        if(amount-coin[i]>=0)ret1=coinchange(i,amount-coin[i]);
        ret2=coinchange(i+1,amount);
        
        dp[i][amount]=ret1+ret2;
        return dp[i][amount];
        
    }
    
}
