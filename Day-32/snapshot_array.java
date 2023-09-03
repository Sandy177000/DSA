public class snapshot_array {

public class Main
{
	// an array of hashmaps
	static HashMap<Integer, Integer>[] snapMap;
	static int snapId = 0;
	
    public static void SnapshotArray(int length) 
	{
		// initialising the array 
		 snapMap = new HashMap[length];
    }

    public static void set(int index, int val) 
	{
		if(snapMap[index]==null){
			snapMap[index] = new HashMap<Integer, Integer>();
		}

		// storing value: val with key: snap_id at index: index of array having 
		snapMap[index].put(snapId,val);
    }

    public static int snap() {
		 return snapId++;
    }

    public static int get(int index, int snap_id) 
	{
		  if(snapMap[index]==null){
			  return 0 ;
		  }

          // decreasing key until we find 
		while(snap_id>=0 && snapMap[index].containsKey(snap_id) == false){
			snap_id--;
		}

		if(snap_id<0){
			return 0;
		}
		
		return snapMap[index].get(snap_id);
    }
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String temp;
		int param1, param2;
		param1 = input.nextInt();
        SnapshotArray(param1);
        String[] arr = new String[n];
		for (int i = 0; i < n; i++){

            temp = input.next();
		    if(temp.equals("set") || temp.equals("get"))
            {
              param1 = input.nextInt();
              param2 = input.nextInt();
              if(temp.equals("set"))
              {
                  set(param1, param2);
              }
              else{
                  System.out.println(get(param1, param2));
              }
            }
            else{
                System.out.println(snap());
            }
		}
        
	}
}

}
