public class asteroid_collision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            
    
            Stack<Integer> ast = new Stack<>();
            
    
            for(int a: asteroids)
            {
                
               if(a>0){
                   ast.push(a);
               }
                   
               else
               {
                   while(!ast.isEmpty() && ast.peek()>0 && -a >ast.peek())
                   {
                       ast.pop();
                   }
                   if(!ast.isEmpty() && ast.peek()==-a){
                       ast.pop();
                   } 
                   else if(!ast.isEmpty() && -a<ast.peek()){
                       
                   }
                   else{
                       ast.push(a);
                   }
                   
                    
               }
            }
            int[] ans = new int[ast.size()];
            for(int i=ans.length-1;i>=0;i--){
               ans[i]=ast.pop();
            }
    
            return ans;
        }
    }   
}
