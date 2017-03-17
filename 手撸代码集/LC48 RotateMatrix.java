public class Solution {
    public static void rotate(int[][] matrix){
		int zsx = 0;
		int zsy = 0;
		int yxx = matrix.length-1;
		int yxy = yxx;
		while(zsx<yxx){
			rotateEdge(matrix,zsx++,zsy++,yxx--,yxy--);
		}
	}
	
	public static void rotateEdge(int[][] m,int zsx,int zsy,int yxx,int yxy){
		
		for(int i=0;i<yxx-zsx;i++){
			int temp = m[zsx][zsy+i];

			//不迷乱，先写四个角，再想加减
			m[zsx][zsy+i] = m[yxx-i][zsy];
			m[yxx-i][zsy] = m[yxx][yxy-i];
			m[yxx][yxy-i] = m[zsx+i][yxy];
			m[zsx+i][yxy] = temp;
		}
	}
}