import java.util.Arrays;

public class merge_sorted_arrays {
//-----------------------------Optimal--------------------------
//                            TC O(n+n)
     public void merge(int[] nums1, int m, int[] nums2, int n) {
         if(n==0 || m==0){
             if(m==0){
                 for(int l=0;l<n;l++){
                     nums1[l] = nums2[l];
                 }
             }
             return;
         }
         else{
         int temp[] = new int[n+m];
         int i = 0;
         int j = 0;
         int index = 0;

         while(j<n && i<m){
             if(nums1[i]>=nums2[j]){
                 temp[index] = nums2[j];
                 j++;
             }
             else{
                 temp[index] = nums1[i];
                 i++;
             }
             index++;
         }
         
         while(i<m){
             temp[index] = nums1[i];
             index++;
             i++;
         }
         
         while(j<n){
             temp[index] = nums2[j];
             index++;
             j++;
         }

         for(int k=0;k<n+m;k++){
             nums1[k] = temp[k]; 
         }
         }
        
    }
//------------------------Brute force---------------------------

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
         
         int j = 0;
         for(int i=m;i<m+n;i++){
             nums1[i] = nums2[j];
             j++;
         }
         Arrays.sort(nums1);
        
    }


}
