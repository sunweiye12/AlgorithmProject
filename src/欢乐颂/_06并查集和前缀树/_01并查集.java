package 欢乐颂._06并查集和前缀树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * 并查集可以解决岛问题:
 * 		1.快速判断两个与元素是否属于同一集合
 * 		2.将两个元素所在的集合合并成一个集合
 * 	条件:必须将所有元素在初始化的时候全部给定,不接受动态的添加元素
 * 
 * 	原理:使用一种类似链表的结构来实现,在链表中头节点的Father的指针是指向自己的,非头结点的Father指针都指向的是自己的上一个节点
 * 		每一个集合的头结点可以作为此集合的代表节点
 * 		功能1:可以通过判断两个节点所在集合的代表节点是否相同,来判断两个集合是否在同一集合
 * 		功能2:将两个元素所在的集合合并成一个集合;可以将节点数少的那个集合的代表节点连接到另一个集合代表节点的下表面
 * 		-->用链表来实现上面两个功能都很容易,但是判断链表中是否存在某元素则需要O(n)的复杂度,因此在实践中使用HashMap结构来模拟链表
 * 		-->为了进行优化可做如下改进,初始化时将每个元素本身封装成一个集合,每次在查询元素的所在代表节点的时候都将查询路径中的
 * 			所有节点直接连接到代表节点上
 * 
 * 时间复杂度分析:假设原始的样本量为N ,则当查询和合并的方法电泳次数大于等于N时  ,再每次调用这两个方法的时间复杂度接近于O(1)
 * @author Administrator
 *
 */
public class _01并查集 {
	
	@Test
	public void main() {

		List<Node> list = new ArrayList<Node>();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.add(node5);
		
		//创建并查集
		UnionFindSet unionSet = new UnionFindSet(list);
		
		System.out.println(unionSet.isSameSet(node1, node2));
		unionSet.union(node1, node2);
		System.out.println(unionSet.isSameSet(node1, node2));
		System.out.println("很骄傲和数据库的哈接口");
	}
	
	//创建Node类型
	public class Node{
		//node可以设置成任何你喜欢的类型
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	
	//创建并查集结构
	public class UnionFindSet{
		HashMap<Node, Node> fatherMap;	//第一个用来存节点,第二个用来存其父节点
		HashMap<Node, Integer> sizeMap;	//用于存储此节点所在集合中包含的节点数
		
		public UnionFindSet(List<Node> list){	//只提供有参构造,初始化时必须将所有参数给完
			fatherMap = new HashMap<Node,Node>();
			sizeMap = new HashMap<Node,Integer>();
			//将每一个节点创建成一个独立的集合
			for (Node node : list) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}
		
		//查找给定节点所对应的代表节点,并给出优化(路径所有节点都指向代表节点)
		public Node findHead(Node node){
			//找到集合代表节点
			Node father = fatherMap.get(node);//得到此节点的父节点
			while (father != fatherMap.get(father)) {
				father = fatherMap.get(father);
			}
			//将沿途的节点都指向代表点
			while (node != fatherMap.get(node)){
				fatherMap.put(node, father);
				node = fatherMap.get(node);
			}
			return father;
		}
		
		//判断两个节点是否属于同一个集合
		public boolean isSameSet(Node a,Node b){
			return findHead(a)==findHead(b);
		}
		
		//将两个节点所在的集合合并成同一个集合
		public void union(Node a,Node b){
			if (a==null||b==null) {
				return;
			}
			Node ahead = findHead(a);
			Node bhead = findHead(b);
			//如果两个元素不存在一个集合则进行合并
			if (ahead!=bhead) {
				int asize = sizeMap.get(a);	//集合存在的节点数只记录在代表节点上
				int bsize = sizeMap.get(b);
				if (asize<bsize) {
					fatherMap.put(ahead, bhead);	//将a添加到b上
					sizeMap.put(bhead, asize + bsize);	//修改代表节点的中节点数
				} else {
					fatherMap.put(bhead, ahead);	//将b添加到a上
					sizeMap.put(ahead, asize + bsize);
				}
			}
		}
		
	}
}
