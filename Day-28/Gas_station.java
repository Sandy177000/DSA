public class Gas_station {
    
class Solution
{
	int tour(int petrol[], int distance[])
	{

		// without queue/stack
		int PETROL = 0;
		int DIST = 0;
		int START = 0;
		int PETROL_LEFT = 0;
		for(int i=0;i<petrol.length;i++){

			PETROL+= petrol[i];
			DIST+=distance[i];

			PETROL_LEFT += petrol[i] - distance[i];
			if(PETROL_LEFT<0){
				START = i+1;
				PETROL_LEFT = 0;
			}
		}

		if(PETROL<DIST){
			return -1;
		}

		return START;
	}
}
}
