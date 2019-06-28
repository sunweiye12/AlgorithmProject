package _01SwordToOffer;

public class _01二维数组中的查找 {
	
	
	public boolean Find(int target, int [][] array) {
        if(array == null){
            return false;
        }
         
        int p1 = 0;
        int p2 = array[0].length - 1;
         
        while(p1 < array.length && p2 >= 0 ){
            if(array[p1][p2] > target){
                p2--;
            } else if(array[p1][p2] < target){
                p1++;
            } else{
                return true;
            }
        }
        return false;
    }
}
