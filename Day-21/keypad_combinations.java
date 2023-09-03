public class keypad_combinations {


class Main {
    static ArrayList <String> OldPhone(int n, int[] keys){
		//Write your code here
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<keys.length;i++){
			sb.append(keys[i]);
		}
		ArrayList<String> ans = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		list.add("ABC");
		list.add("DEF");
		list.add("GHI");
		list.add("JKL");
		list.add("MNO");
		list.add("PQRS");
		list.add("TU");
		list.add("VWX");
		list.add("YZ");

		//System.out.println(sb.toString());
		helper(sb.toString(),0,"",ans, list);
		return ans;
    }
	public static void helper(String up, int index,String p, ArrayList<String> ans, ArrayList<String> list){

		 if(index==up.length()){
			 ans.add(p);
			 return;
		 }
		 // Pick a char at ith index and convert it to digit
		 int digit = up.charAt(index) -'0';
		 // loop through the corresponding string of the digit
		 for(int i=0;i<list.get(digit).length();i++)
		 {
			 // pick the character
			 char ch = list.get(digit).charAt(i);
			 // jump to the next char in the main string
			 helper(up,index+1,p+ch,ans,list);
		 }
	}
	
	public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keys = new int[n];
        for(int i=0;i<n;++i){
            keys[i] = sc.nextInt();
        }
        ArrayList <String> ans=OldPhone(n,keys);
        for(String i:ans) System.out.print(i+" ");
    }
}

///////////////////////////////////////////leetcode//////////////////////////////////////////////
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> list = new ArrayList<>();
            helper(digits,"", list);
            return list;
        }
    
        public void helper(String up, String p, List<String> list){
            if(up.isEmpty()){
                if(!p.isEmpty())
                     list.add(p);
                return;
            }
    
            int digit = up.charAt(0)-'1';
    
            if(digit<=5 && digit>=1)
            {
                for(int i= (digit-1)*3; i<=(digit-1)*3 + 2;i++){
                    char ch = (char)(i +'a');
                    helper(up.substring(1),p+ch,list);
                }
            }
            else if(digit==7){
                
                for(int i= (digit-1)*3+1; i<=(digit-1)*3 + 3;i++){
                    char ch = (char)(i +'a');
                    helper(up.substring(1),p+ch,list);
                }
            }
            else if(digit==8){
                for(int i=22; i<=25;i++){
                    char ch = (char)(i +'a');
                    helper(up.substring(1),p+ch,list);
                }
            }
            else{//digit: 6
                
                for(int i= (digit-2)*4-1; i<=(digit-2)*4 + 2;i++){
                    char ch = (char)(i +'a');
                    helper(up.substring(1),p+ch,list);
                }
            }
        }
    }   
}
