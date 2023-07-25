public class permutations_of_array {
    
    public void permutations(int[] arr, boolean[] visited,ArrayList<ArrayList<Integer>> permuteSet, ArrayList<Integer> list){
        if(arr.length == list.size())
        {
            permuteSet.add(new ArrayList<>(list)); // or print the list
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]) // check for unique elements
            {
                visited[i] = true;
                list.add(arr[i]);
                permutations(arr,visited,permuteSet,list);
                //backtracking remove last element
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
