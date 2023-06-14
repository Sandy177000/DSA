public class print_N_to_1 {
    void printNos(int N) {
         if(N==0){
            return ;
        }
        System.out.print(N+" ");
        printNos(N-1);
    }
}
