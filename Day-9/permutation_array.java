import java.util.*;

public class permutation_array {
        public void printPermutations(int n,int[] arr) {
		//Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> final_list = new ArrayList<ArrayList<Integer>>();
		permute(arr,0,final_list);
	    	
		for(int i=0;i<final_list.size();i++){
			for(int j=0;j<final_list.get(i).size();j++){
				System.out.print(final_list.get(i).get(j)+ " ");
			}	
			System.out.println();
		}
    }


	public void permute(int nums[], int index, ArrayList<ArrayList<Integer>> final_list){

        // base case
        if(index >nums.length-1){
			ArrayList<Integer> l = new ArrayList<Integer>();
            for(int j=0;j<nums.length;j++){
				l.add(nums[j]);
            }
			
			final_list.add(l);
        }
		

        for(int i=index;i<nums.length;i++){
            swap(i, index,nums); // swapping elements
            permute(nums, index+1,final_list);
            swap(i,index,nums); // swapping back to get original array
        }
    }

    public void swap(int i, int j, int [] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
