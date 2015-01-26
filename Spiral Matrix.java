/*Given a matrix of m x n elements (m rows, n columns), 
return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].*/

public class Solution{
	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> res=new ArrayList<Integer>();
		if(matrix==null||matrix.length==0||matrix[0].length==0)
			return res;

		//Like rotate image, split the matrix into layers

		int layerNum=(Math.min(matrix.length, matrix[0].length))/2;
		for(int layer=0; layer<layerNum; layer++){
			for(int i=layer; i<matrix[0].length-1-layer; i++){
				res.add(matrix[layer][i]);
			}
			for(int i=layer; i<matrix.length-1-layer; i++){
				res.add(matrix[i][matrix[0].length-1-layer]);
			}
			for(int i=matrix[0].length-1-layer;i>layer;i--){
				res.add(matrix[matrix.length-1-layer][i]);
			}
			for(int i=matrix.length-1-layer; i>layer; i--){
				res.add(matrix[i][layer]);
			}
		}
		//Take notice of the odd number of length
		if((Math.min(matrix.length, matrix[0].length))%2==1){
			if(matrix.length<matrix[0].length){
				for(int i=layerNum; i<matrix[0].length-layerNum; i++){
					res.add(matrix[layerNum][i]);
				}
			}else{
				for(int i=layerNum; i<matrix.length-layerNum; i++){
					res.add(matrix[i][layerNum]);
				}
			}
		}

		return res;
	}
}