import java.io.*;
import java.util.*;
    
class candies {
        public static void main (String[] args) {
            Scanner sc=new Scanner(System.in);
           
            int n=sc.nextInt(); 
            ArrayList<Integer> arr= new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                int x=sc.nextInt();
                arr.add(x);
            }
            
            Solution ob=new Solution();
            System.out.println(ob.candies(arr,n));
            
        }
    }
    
    
    class Solution {
        public int candies(ArrayList<Integer> A,int n) {
            
            int candies[] = new int[n];
            for(int i = 0;i<A.size()-1;i++){
                // right neighbour
                if(A.get(i+1)>A.get(i)){
                    candies[i+1]++; 
                }
            }
    
            for(int i = A.size()-1;i>=1;i--){
                // left neighbour
                if(A.get(i-1)<A.get(i)){
                    // left neighbour should have candies equal to or greater than curr
                    if(candies[i]>=candies[i-1])
                        candies[i-1]++;
                }
            }
    
            int s = 0;
            for(int x:candies){
                s+=x;
            }
    
            return n+s;
        
        }
    }
       
