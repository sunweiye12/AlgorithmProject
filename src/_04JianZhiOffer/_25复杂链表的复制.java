package _04JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/*
 * ��Ŀ:����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 * 		���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * 
 * ˼·:����һ��HashMap�Ľṹ,keyΪԭ�ڵ�,valueΪkey��Ӧ���ƽڵ�
 * 		Ȼ���HashMap���������Ժ�,
 * 		��value��nextָ��ָ��,key��nextָ��ָ���value
 * 		��value��randomָ��ָ��,key��randomָ��ָ���value
 */
public class _25��������ĸ��� {
	
	public void main() {
		// TODO Auto-generated method stub

	}
	
	 public RandomListNode Clone(RandomListNode pHead){
		//basecase 
		if (pHead == null) { return null; }
		//��������
		Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		
		RandomListNode cur = pHead;
		while(cur != null){
			map.put(cur, new RandomListNode(cur.label));
			cur = cur.next;
		}
		cur = pHead;
		while(cur != null){
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		RandomListNode node = map.get(pHead);
		return node;
	 }

//------------------------------------------------------------------------------
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
}
