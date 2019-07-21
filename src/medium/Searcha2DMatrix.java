package medium;

/**
 * @author tortoiselala
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int height = matrix.length - 1;
        int width = matrix[0].length - 1;

        int wLoop = width;
        int hLoop = 0;
        while(hLoop <= height && wLoop >= 0){
            if(matrix[hLoop][wLoop] == target){
                return true;
            }else if(matrix[hLoop][wLoop] < target){
                ++hLoop;
            }else{
                --wLoop;
            }
        }
        return false;
    }
}
