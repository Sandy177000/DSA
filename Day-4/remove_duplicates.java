public class remove_duplicates {
    // in place algorithm
    int remove_duplicate(int A[],int N)
    {
        int index=1;

        // traverse entire array
        for(int i=0;i<N-1;i++){

        // check for the adjacent element which is different,
        // place it at index update the index
        // Note: Think of the array as newly declared array starting from index 1
          
            if(A[i]!=A[i+1]){

                A[index] = A[i+1];
                
                index++;

            }
          // Skipping the elements which are equal
        }
        return index;
    }
}
