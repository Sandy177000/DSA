public class longest_route_with_hurdles {
    	
  static int findLongestPath(int mat[][], int i, int j, int x, int y, int R, int C) 
  {
	  int maxlen = -1;
	  return findLongestPath1(maxlen,0,mat,0,0,x,y,R-1,C-1,"", new boolean[R][C]);
  }

   static int findLongestPath1(int maxlen,int len,int mat[][], int i, int j, int x, int y, int R, int C,String path,boolean[][] vis) 
  {  
	  if(i==x && j==y )
	  {
		  if(mat[i][j]!=0)// edge case 
			  maxlen = Math.max(len,maxlen);
		  return maxlen;
	  }

	  if(i<0||j<0|| i>R||j>C|| mat[i][j]==0||vis[i][j]) return maxlen;
	  
	  vis[i][j] = true;
	  maxlen = findLongestPath1(maxlen,len+1,mat, i, j+1,x,y,R,C,path,vis); 
	  maxlen = findLongestPath1(maxlen,len+1,mat, i, j-1,x,y,R,C,path,vis); 
	  maxlen = findLongestPath1(maxlen,len+1,mat, i+1, j,x,y,R,C,path,vis); 
	  maxlen =  findLongestPath1(maxlen,len+1,mat, i-1, j,x,y,R,C,path,vis); 
	  vis[i][j] = false;
		  
	return maxlen;
	  
  }


}
