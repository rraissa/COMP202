public class Sudoku {

	public static void main (String[] args){	
		int[][] sudokuBoard = { 
		        {5, 3, 4, 6, 7, 8, 9, 1, 2}, 
		        {6, 7, 2, 1, 9, 5, 3, 4, 8},
		        {1, 9, 8, 3, 4, 2, 5, 6, 7},
		        
		        {8, 5, 9, 7, 6, 1, 4, 2, 3},
		        {4, 2, 6, 8, 5, 3, 7, 9, 1},
		        {7, 1, 3, 9, 2, 4, 8, 5, 6},
		        
		        {9, 6, 1, 5, 3, 7, 2, 8, 4},
		        {2, 8, 7, 4, 1, 9, 6, 3, 5},
		        {3, 4, 5, 2, 8, 6, 1, 7, 9}};
		
		
		//boolean newArray = checkLength(sudokuBoard);
		//boolean newArray2 = checkRange(sudokuBoard);
		//boolean newArray5 = checkGrids(sudokuBoard);
		//boolean newArray4 = checkColumns(sudokuBoard);
		//boolean newArray3 = checkLines(sudokuBoard);
		boolean newArray6 = isSudoku(sudokuBoard);
		
		
	}

	
	//HELPER METHODS!
	private static boolean checkLength(int[][] sudokuBoardInput){
		int rows = sudokuBoardInput.length;
		//System.out.println("Number of rows is: " + rows);
		if (rows != 9){
			System.out.println("Rows size is invalid.");
			return false;
			}
		for(int i = 0; i < rows; i++){
			int columns = sudokuBoardInput[i].length;
			//System.out.println("Number of columns is: " + columns);
		}
		//System.out.println("Size is valid.");
	    return true;
	}
	
	private static boolean checkRange(int[][] sudokuBoardInput){
		for(int i = 0; i< sudokuBoardInput.length; i++){
			int[] row = sudokuBoardInput[i];
			for(int j = 0; j < row.length; j++){
				if(row[j] > 9 || row[j] < 1){
					//System.out.println("Range is invalid. (See entry at row " + (i+1) + " and column " + (j+1) + ")");
					return false;
				}
			}
		}
		//System.out.println("Range is valid.");
		return true;
	}
	
	private static int[] sort(int[] lcg){
		 int[] sortedArray = lcg;
		 int temp = 0;
		 int n = sortedArray.length;
        int positionOfSmallest = 0;
       
        for (int i = 0; i < n-1; i++){
       	 positionOfSmallest = i;
       	 for (int j = i + 1; j < n; j++){
                        if (sortedArray[positionOfSmallest] > sortedArray[j]){
                                positionOfSmallest = j;
                        }
                                                              
     }
       	 temp = sortedArray[i];
       	 sortedArray[i] = sortedArray[positionOfSmallest];
            sortedArray[positionOfSmallest] = temp; 
        
       	 
   }
       // System.out.println("Sorted array:");
        //for(int i=0; i < sortedArray.length; i++){
                //System.out.print(sortedArray[i] + " ");
       // }
         return sortedArray;  
	}
	
	private static boolean uniqueEntries(int[] subArray){
		//System.out.println();
		for(int k = 0; k < subArray.length; k++){
			//System.out.print(subArray[k]);
		}
		int[] lineArray = subArray;
		lineArray = sort(lineArray);
			for(int j = 0; j < subArray.length; j++){
				//System.out.print(subArray[j]);
				//System.out.print(lineArray[j]);
			}
		for(int i = 0; i < lineArray.length-1; i++){
				if(lineArray[i] == lineArray[i+1]){
					return false;
		    }
		}
		return true;
	}
	
	private static int[] getColumn(int[][] jColumn, int j){
		int[] columnArray = new int[jColumn.length];
		//System.out.println("Length of jColumn is: " + jColumn.length);
		for(int i = 0; i < jColumn.length; i++){
			//System.out.println();
			for(int k = 0; k < jColumn.length; k++){
			//System.out.print(" " + jColumn[i][k]);
			}
		}
		
		for(int i = 0; i < columnArray.length; i++){
		columnArray[i] = jColumn[i][j-1];
		//System.out.println(jColumn[i][j-1]);
		      }
		
		/*System.out.println("");
		System.out.println("jth column is:");
			for(int i= 0; i < columnArray.length; i++){
                System.out.print(columnArray[i] + " ");
		}*/
        
		return columnArray;
		
	}	
	

	private static boolean checkLines(int[][] sudokuBoardInput){
		int[] line = new int[sudokuBoardInput.length];
		for(int i = 0; i < sudokuBoardInput.length; i++){
			line = sudokuBoardInput[i];
			if(uniqueEntries(line) == false){
				//System.out.println("Row contains duplicates.");
				return false;
			}
		}
		//System.out.println("Row doesn't contain duplicates.");
		return true;
	}
	
	private static boolean checkColumns(int[][] sudokuBoardInput){
		int[] column = new int[sudokuBoardInput.length];
		for(int j = 0; j < sudokuBoardInput.length; j++){
			column = getColumn(sudokuBoardInput, j+1);
				if(uniqueEntries(column) == false){
					//System.out.println("Column contains duplicates.");
					return false;
				}	
		 }		
		//System.out.println("Column doesn't contain duplicates.");
		return true;
	}
	
	public static int[] flatten(int[][] squareArray){
		int length = squareArray.length * squareArray.length;
		int[] singleArray = new int [length];
		int h = 0;
		for(int i = 0; i < squareArray.length; i++){
			for(int j = 0; j < squareArray.length; j++){
				singleArray[h] = squareArray[i][j];
				h = h+1;
			}
		}
		/*System.out.println("");
		System.out.println("Flattened array is: ");
        for(int i = 0; i < singleArray.length; i++){
                System.out.print(singleArray[i] + " ");
        }*/
		return singleArray;
	}
	
	public static int[][] subGrid(int[][] nxnArray, int i, int j, int m){
		int[][] mxmArray = new int[m][m];
		for(int x = 0; x < m; x++){
			for(int y = 0; y < m; y++){
				mxmArray[x][y] = nxnArray[i+x][j+y];
			}
		}
		//System.out.println("");
		//System.out.println("Sub grid is: ");
        //for(int k = 0; k < m; k++){
        	//for(int l = 0; l < m; l++){
               // System.out.print(mxmArray[k][l] + " ");
        	//}
        	//System.out.println();
        //}
		return mxmArray;
		
	}
	
	
	private static boolean checkGrids(int[][] sudokuBoardInput){
		int m = 3;
		int i = 0;
		int j = 0;
		int[] flattenGrid = new int[m*m];
		int [][] sub = new int[m][m];
		for(int x = 0; x < m; x++){
			i = x * m;
			for(int y = 0; y < m; y++){
				j = y * m;
				sub = subGrid(sudokuBoardInput, i, j, m);
				flattenGrid = flatten(sub);
				if(uniqueEntries(flattenGrid) == false){
				//System.out.println("Grid contains duplicates.");
				return false;
			}
			}
		}
		//System.out.println("Grid doesn't contain duplicates.");
		return true;
	}
	
	public static boolean isSudoku(int[][] sudokuBoardInput){
		if(checkRange(sudokuBoardInput) && checkLength(sudokuBoardInput)  && checkGrids(sudokuBoardInput) && checkColumns(sudokuBoardInput) && checkLines(sudokuBoardInput)){
			System.out.println("Sudoku is correct.");
			return true;
		}
		System.out.println("Sudoku is incorrect.");
		return false;
	}
	
}
