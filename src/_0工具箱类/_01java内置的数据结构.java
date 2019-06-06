package _0工具箱类;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 * 探究一下java内置的数据结构以及其基本用法
 * @author Super PC
 */
public class _01java内置的数据结构 {
	
	@Test
	public void main() {
	//数组(本身java是有数组的,那就来谈谈集合中数组的应用吧)
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);	//添加一个元素
		list.add(2);	//添加一个元素
		list.add(3);	//添加一个元素
//		list.add(1, 4);	//指定位置插入一个值,后面的值向后移动
		list.set(0, 2);	//修改指定位置的值
		list.remove(0); //参数可以使下表也可以是元素
		list.get(0);  	//获取指定下表的元素
//		list.addAll(null); //可以添加一个集合
//		list.clear();	//删除所有
//		list.indexOf(1);  //返回第一个出现此元素的下表(没有返回-1)
		list.size();	//获取元素个数
		
		//注意:无论是删除指定位置,删除之后元素会填充过来,始终是连续的(因此在遍历的过程中,一般不要删除元素)
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i)+" ");
//		}
		
	//链表  实现的双端 队列(FIFO 尾部添加 头部取出)
		LinkedList<Integer> link = new LinkedList<Integer>();
		link.addFirst(1); //头部添加
		link.getLast();   //尾部读取
		link.removeLast(); //尾部删除
		link.addLast(1); //尾部添加 ...
//--------------------------------------------------------------------------------------------------
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1); //尾部添加
		queue.add(2); //尾部添加
		queue.add(3); //尾部添加
//		queue.peek(); //头部读取
//		queue.poll(); //头部读取并删除
//		queue.remove(); //头部读取并删除(如果是空队列会报错)
		System.out.println("------------队列----------------");
		while (queue.size()!=0) {
			System.out.print(queue.poll()+"-");
		}
		System.out.println();
		
	//队列见上面
		
	//栈(先进后出)
		Stack<Integer> stack =new Stack<Integer>();
//		stack.add(1);	//栈顶添加元素(过时)
		stack.push(1);  //栈顶添加元素
		stack.push(2);  //栈顶添加元素
		stack.push(3);  //栈顶添加元素
		stack.peek();	//栈顶元素的读取
//		stack.pop();	//删除栈顶元素
		
		System.out.println("------------栈----------------");
		while (stack.size()!=0) {
			System.out.print(stack.pop()+"-");
		}
		System.out.println();
		
		
	//堆(java中用优先级队列来实现堆结构)
		//在java中可以用优先级队列实现堆结构
//		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); //默认形成小顶堆
		//实现大顶堆的策略-->重写比较器
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		}); 	
		
		heap.add(1);
		heap.add(5);
		heap.add(2);
		heap.add(4);
		heap.add(9);
		//heap.peek()	读取元素，（不删除）
		//heap.poll()	取出元素，（删除）
		
		System.out.println("------------堆----------------");
		while (heap.size()!=0) {
			System.out.print(heap.poll()+"-");
		}
		System.out.println();
		
		//-------------------------------堆中放入对象--------------------------------------
		//通过添加Comparator来实现对引用对象的排序策略
		PriorityQueue<Student> queue1=new PriorityQueue<Student>(1,new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o2.score-o1.score;
			}
		});

        Student p1=new Student(95,"张三");
        Student p2=new Student(89,"李四");
        Student p3=new Student(89,"李四");
        Student p4=new Student(67,"王五");
        Student p5=new Student(92,"赵六");
        queue1.add(p1);
        queue1.add(p2);
        queue1.add(p3);   //add 和offer效果一样。
        queue1.offer(p4); //add 方法实现，其实就是调用了offer
        queue1.offer(p5);
        
        System.out.println("------------堆(放对象)----------------");
        while(!queue1.isEmpty()){
            System.out.println(queue1.poll());
        }    
	
		
	}

	class Student{
	    private int score;
	    private String name;
	    
	    public Student(int age,String name){
	        this.score=age;
	        this.name=name;
	    }
	    public int getScore() {
	        return score;
	    }
	    public void setScore(int score) {
	        this.score = score;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String toString(){
	        return "姓名："+name+"-"+score+"分";
	    }
	}
	
	
}
