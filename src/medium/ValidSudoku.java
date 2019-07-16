package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1. 暴力解法
 *  依次判断每行，每列，每个方格
 * 2. 记录
 *  使用空间换时间的方法，将结果记录下来，只需要遍历依次，时间复杂度为n^2
 *  规定如下格式，
 *     第i行出现数字x记为x in row i
 *     第j列出现数组y记为y in col j
 *     第i行第j列的元素同时还出现在块(i / 3, j / 3)中记为 x in block (i / 3) - (j / 3)
 * @author tortoiselala
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                if(board[i][j] != '.'){
                    if(!set.add(board[i][j] + " in row " + i)
                            || !set.add(board[i][j] + " in col " + j)
                            || !set.add(board[i][j] + " in block " + (i / 3) + " - " + (j / 3))
                    ){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
