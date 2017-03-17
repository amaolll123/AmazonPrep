package com.amao.prep;

public class LC48RotateMatrix {
	
	public static void rotateMatrix(int[][] m){
		int zsx = 0;
		int zsy = 0;
		int yxx = m.length-1;
		int yxy = yxx;
		while(zsx<yxx){
			rotateEdge(m,zsx++,zsy++,yxx--,yxy--);
		}
	}
	
	public static void rotateEdge(int[][] m,int zsx,int zsy,int yxx,int yxy){
		
		for(int i=0;i<yxx-zsx;i++){
			int temp = m[zsx][zsy+i];
			m[zsx][zsy+i] = m[yxx-i][zsy];
			m[yxx-i][zsy] = m[yxx][yxy-i];
			m[yxx][yxy-i] = m[zsx+i][yxy];
			m[zsx+i][yxy] = temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = {{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}};
		rotateMatrix(m);
		for(int[] iList:m){
			System.out.print("[");
			for(int i:iList){
				System.out.print(i+",");
			}
			System.out.print("]"+"\n");
		}
	}

}
