public class print_1toN {
    
  public void printNos(int N)
    {
        if(N==0){
            return ;
        }
        printNos(N-1);
        System.out.print(N+" ");
        
    }
}