public class subsets_of_array {
    public void sub(int[] arr, int i, ArrayList<ArrayList<Integer>> powerSet, ArrayList<Integer> list){

        if(i==arr.length) {
           // if(!powerSet.contains(list)) // for unique subsets
                 powerSet.add(new ArrayList<Integer>(list));
            return;
        }
        else
        {
            // pick or add
            list.add(arr[i]);
            sub(arr, i + 1, powerSet, list);

            // dont pick or remove
            list.remove(list.size() - 1);
            sub(arr, i + 1, powerSet, list);
        }

    }
}
