public class subsequences {
    public void subseq(String ques, String ans, ArrayList<String> list){

        if(ques.isEmpty()){
            list.add(ans);
            return;
        }
        //pick the character
        char ch = ques.charAt(0);
        subseq(ques.substring(1),ans +ch,list);

        //dont pick the character
        subseq(ques.substring(1),ans,list);

    }
}
