package _04JianZhiOffer;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * ��Ŀ :
 */
public class _51�������ظ������� {

	@Test
	public void main() {
		
	}
	
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if (numbers == null || numbers.length == 0) {
			return false;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (set.contains(numbers[i])) {
				duplication[0] = numbers[i];
				return true;
			} else{
				set.add(numbers[i]);
			}
		}
        return false;
    }
}
