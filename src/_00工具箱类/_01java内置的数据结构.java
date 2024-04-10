package _00��������;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * ̽��һ��java���õ����ݽṹ�Լ�������÷�
 * @author Super PC
 */
public class _01java���õ����ݽṹ {
	
	
	public static void main(String[] arge) {
	//����(����java���������,�Ǿ���̸̸�����������Ӧ�ð�)
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);	//���һ��Ԫ��
		list.add(2);	//���һ��Ԫ��
		list.add(3);	//���һ��Ԫ��
//		list.add(1, 4);	//ָ��λ�ò���һ��ֵ,�����ֵ����ƶ�
		list.set(0, 2);	//�޸�ָ��λ�õ�ֵ
		list.remove(0); //��������ʹ�±�Ҳ������Ԫ��
		list.get(0);  	//��ȡָ���±��Ԫ��
//		list.addAll(null); //�������һ������
//		list.clear();	//ɾ������
//		list.indexOf(1);  //���ص�һ�����ִ�Ԫ�ص��±�(û�з���-1)
		list.size();	//��ȡԪ�ظ���
		
		//ע��:������ɾ��ָ��λ��,ɾ��֮��Ԫ�ػ�������,ʼ����������(����ڱ����Ĺ�����,һ�㲻Ҫɾ��Ԫ��)
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
	//����  ʵ�ֵ�˫�� ����(FIFO β����� ͷ��ȡ��)
		LinkedList<Integer> link = new LinkedList<Integer>();
		link.addFirst(1); //ͷ�����
		link.getLast();   //β����ȡ
		link.removeLast(); //β��ɾ��
		link.addLast(1); //β����� ...
//--------------------------------------------------------------------------------------------------
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1); //β�����
		queue.add(2); //β�����
		queue.add(3); //β�����
//		queue.peek(); //ͷ����ȡ
//		queue.poll(); //ͷ����ȡ��ɾ��
//		queue.remove(); //ͷ����ȡ��ɾ��(����ǿն��лᱨ��)
		System.out.println("------------����----------------");
		while (queue.size()!=0) {
			System.out.print(queue.poll()+"-");
		}
		System.out.println();
		
	//���м�����
		
	//ջ(�Ƚ����)
		Stack<Integer> stack =new Stack<Integer>();
//		stack.add(1);	//ջ�����Ԫ��(��ʱ)
		stack.push(1);  //ջ�����Ԫ��
		stack.push(2);  //ջ�����Ԫ��
		stack.push(3);  //ջ�����Ԫ��
		stack.peek();	//ջ��Ԫ�صĶ�ȡ
//		stack.pop();	//ɾ��ջ��Ԫ��
		
		System.out.println("------------ջ----------------");
		while (stack.size()!=0) {
			System.out.print(stack.pop()+"-");
		}
		System.out.println();
		
		
	//��(java�������ȼ�������ʵ�ֶѽṹ)
		//��java�п��������ȼ�����ʵ�ֶѽṹ
//		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); //Ĭ���γ�С����
		//ʵ�ִ󶥶ѵĲ���-->��д�Ƚ���
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
		//heap.peek()	��ȡԪ�أ�����ɾ����
		//heap.poll()	ȡ��Ԫ�أ���ɾ����
		
		System.out.println("------------��----------------");
		while (heap.size()!=0) {
			System.out.print(heap.poll()+"-");
		}
		System.out.println();
		
		//-------------------------------���з������--------------------------------------
		//ͨ�����Comparator��ʵ�ֶ����ö�����������
		PriorityQueue<Student> queue1=new PriorityQueue<Student>(1,new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o2.score-o1.score;
			}
		});

//        Student p1=new Student(95,"����");
//        Student p2=new Student(89,"����");
//        Student p3=new Student(89,"����");
//        Student p4=new Student(67,"����");
//        Student p5=new Student(92,"����");
//        queue1.add(p1);
//        queue1.add(p2);
//        queue1.add(p3);   //add ��offerЧ��һ����
//        queue1.offer(p4); //add ����ʵ�֣���ʵ���ǵ�����offer
//        queue1.offer(p5);
//        
        System.out.println("------------��(�Ŷ���)----------------");
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
	        return "������"+name+"-"+score+"��";
	    }
	}
	
	
}
