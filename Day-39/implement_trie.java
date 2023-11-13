public class implement_trie {
    class Node{
        Node[] arr;
        boolean flag;
        Node(){
            arr = new Node[26];
            for(int i = 0;i<arr.length;i++){
                arr[i] = null;
            }
            flag = false;
        }
    }
    
    class Trie {
        Node root;
        public Trie() {
            root = new Node();
        }
        
        public void insert(String word) {
            Node node = root;
            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i) - 'a';
                if(node.arr[idx]==null){
                    node.arr[idx] = new Node();
                }
                if(i==word.length()-1){
                    node.arr[idx].flag = true;
                }
                node = node.arr[idx];
            }
        }
        
        public boolean search(String word) {
            Node node = root;
            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i) - 'a';
                if(node.arr[idx]==null){
                    return false;
                }
                if(i==word.length()-1 && node.arr[idx].flag==false){
                    return false;
                }
                node = node.arr[idx];
            }
            return true;
        }
        
        public boolean startsWith(String word) {
            Node node = root;
            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i) - 'a';
                if(node.arr[idx]==null){
                    return false;
                }
    
                node = node.arr[idx];
            }
            return true;
        }
    }
    
}
