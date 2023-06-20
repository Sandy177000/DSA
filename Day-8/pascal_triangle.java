import java.util.ArrayList;
import java.util.List;

public class pascal_triangle {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows==1){
            
                List<Integer> s = new ArrayList<>();
                s.add(1);
                ans.add(s);

        }

        else if(numRows>=2){


                List<Integer> prev = new ArrayList<>();
                prev.add(1);
                ans.add(prev);

                for(int i=2;i<=numRows;i++){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(1);

                    for(int j = 0; j<prev.size()-1;j++){
                        int sum = prev.get(j) + prev.get(j+1);
                        curr.add(sum);
                    }

                    curr.add(1);
                    ans.add(curr);
                    prev = curr;
                }

        }

        return ans;

    }
}
