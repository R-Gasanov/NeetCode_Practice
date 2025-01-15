package NeetCode_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Neetcode150_08 
{ //Sudoku problem, we've done these before ;)
	public static void main(String args[])
	{
		char[][] sudoku = 
	        {{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
	         {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
	         {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
	         {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
	         {'4', '.', '.', '8', '.', '3', '.', '.', '5'},
	         {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
	         {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
	         {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
	         {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		System.out.println(isValidSudoku(sudoku));
	}
	
	public static boolean isValidSudoku(char[][] board) 
	{
        // So first we need to check horizontally
		// Then vertically
		// Then the hard part is to check within the 9x9 box
		ArrayList<Character> line_handler = new ArrayList<>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
		
		
		// board[i] row - board[i][j] 
		Map<Integer, List<Integer>> square_handler = new TreeMap<>();
		square_handler.put(1, new ArrayList<>(Arrays.asList(0,1,2)));
		square_handler.put(2, new ArrayList<>(Arrays.asList(3,4,5)));
		square_handler.put(3, new ArrayList<>(Arrays.asList(6,7,8)));
		//ArrayList<Character> horizontal = line_handler;
		//ArrayList<Character> vertical = line_handler;
		//int counter = 18;
		
		// Below we are checking in a 3 x 3
		for (int index_squarerow = 0; index_squarerow < 3; index_squarerow++)
		{
			for (int index_squarecol = 0; index_squarecol < 3; index_squarecol++)
			{
				ArrayList<Character> square = new ArrayList<>(line_handler);
				// We will be checking with this above
				for (int interiorrow = 0; interiorrow < 3; interiorrow++)
				{
					for (int interiorcol = 0; interiorcol < 3; interiorcol++)
					{
						/* In order to change from the different squares, we will have to multiply 
						*  via the index_square and index_col
						*/ 
						int currentrow = index_squarerow * 3 + interiorrow;
						int currentcol = index_squarecol * 3 + interiorcol;
						
						if (board[currentrow][currentcol] != '.')
						{
							if (square.contains(board[currentrow][currentcol]))
							{
								square.remove(Character.valueOf(board[currentrow][currentcol]));
							}
							else
							{
								return false;
							}
						}
					}
				}
			}
			
		}
		
		
		// Below is for the checking horizontally and then vertically
		
		for (int index_row = 0; index_row < board.length; index_row++)
		{ // Here we are iterating through the rows
			ArrayList<Character> horizontal = new ArrayList<>(line_handler);
			ArrayList<Character> vertical = new ArrayList<>(line_handler);
			
			for (int index_col = 0; index_col < board[index_row].length; index_col++)
			{ // Then we are iterating through the columns 
				// Below checks horizontally
				if (board[index_row][index_col] != '.')
				{
					if (horizontal.contains(board[index_row][index_col]))
					{
						horizontal.remove(Character.valueOf(board[index_row][index_col]));
					}
					else
					{
						return false;
					}
				}
				// Below checks vertically now
				if (board[index_col][index_row] != '.')
				{
					if (vertical.contains(board[index_col][index_row]))
					{
						vertical.remove(Character.valueOf(board[index_col][index_row]));
					}
					else
					{
						return false;
					}
				}
			}
		}
		return true;
    }
}
