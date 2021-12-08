package _02分类算法._01队列栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 题目描述:猫狗队列 【题目】 宠物、狗和猫的类如下：
	public class Pet { 
		private String type;
		public Pet(String type) { 
			this.type = type; 
		}
		public String getPetType() { 
			return this.type; 
		}
	}
	public class Dog extends Pet { 
		public Dog() { super("dog"); } 
	}
	public class Cat extends Pet { 
		public Cat() { super("cat"); } 
	}
	
描述:实现一种狗猫队列的结构，要求如下： 用户可以调用add方法将cat类或dog类的
	实例放入队列中； 用户可以调用pollAll方法，将队列中所有的实例按照进队列
	的先后顺序依次弹出； 用户可以调用pollDog方法，将队列中dog类的实例按照
	进队列的先后顺序依次弹出； 用户可以调用pollCat方法，将队列中cat类的实
	例按照进队列的先后顺序依次弹出； 用户可以调用isEmpty方法，检查队列中是
	否还有dog或cat的实例； 用户可以调用isDogEmpty方法，检查队列中是否有dog
	类的实例； 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例
思路:分别创建两个猫队列和两个狗队列还有一个计数器,
	以两个猫队列为例,其中一个猫队列存放创建的猫对象,另一个猫队列存放计数器,
	每次添加对象时,就将对象放到相应的队列中,然后在再将计数器结果放到相应的队列中,然后计数器加一
	在获取全部是,就会比较两个存放计数器的队列那个存放的数字更小,在存放数字更小的队列下获取宠物,
	并且相应的计数器队列也去除
 * @author Administrator
 *
 */
public class _08猫狗队列 {
	public static void main(String[] args) {
		Cat cat1 = new Cat("c1");
		Cat cat2 = new Cat("c2");
		Cat cat3 = new Cat("c3");
		Cat cat4 = new Cat("c4");
		Cat cat5 = new Cat("c5");
		Dog dog1 = new Dog("d1");
		Dog dog2 = new Dog("d2");
		Dog dog3 = new Dog("d3");
		Dog dog4 = new Dog("d4");
		Dog dog5 = new Dog("d5");
		
		PetQueue qu = new PetQueue();
		qu.add(cat1);
		qu.add(dog1);
		qu.add(cat2);
		qu.add(cat3);
		qu.add(cat4);
		qu.add(cat5);
		qu.add(dog2);
		qu.add(dog3);
		qu.add(dog4);
		qu.add(dog5);
		Pet[] pets = qu.pollAll();
		for (int i = 0; i < pets.length; i++) {
			System.out.println(pets[i].getPetType());
		}
		System.out.println(qu.isEmpty());
		System.out.println(qu.isDogEmpty());
		System.out.println(qu.isCatEmpty());
	}
}

class Pet { 
	private String type;
	public Pet(String type) { 
		this.type = type; 
	}
	public String getPetType() { 
		return this.type; 
	}
}
class Dog extends Pet { 
	public Dog(String name) {
		super(name); 
	} 
}
class Cat extends Pet { 
	public Cat(String name) { 
		super(name);
	} 
}

//--------------------队列---------------------------------
class PetQueue{
	int count = 0;
	Queue<Pet> DogQueue;
	Queue<Pet> CatQueue;
	Queue<Integer> DogCount;
	Queue<Integer> CatCount;
	public PetQueue(){
		DogQueue = new LinkedList<Pet>();
		CatQueue = new LinkedList<Pet>();
		DogCount = new LinkedList<Integer>();
		CatCount = new LinkedList<Integer>();
	}
	
	//添加宠物队列
	public void add(Pet pet){
		if (pet instanceof Cat) {
			CatQueue.add(pet);
			CatCount.add(count++);
		}else if (pet instanceof Dog) {
			DogQueue.add(pet);
			DogCount.add(count++);
		} else {
			throw new RuntimeException("输入的宠物类型不是猫或狗");
		}
	}
	
	//删除并拿出队列所有宠物
	public Pet[] pollAll(){
		Pet[] pet = new Pet[count]; //创建一个总队列大小的数组用于盛放从队列中poll出的宠物
		for (int i = 0; i < pet.length; i++) {
			//那个宠物对应的下标小就先叫那个队列的宠物放到数组中
			if (CatCount.size()>0 && DogCount.size()>0) {
				if (CatCount.peek() < DogCount.peek()) {
					pet[i] = CatQueue.poll();
					CatCount.poll();
				} else {
					pet[i] = DogQueue.poll();
					DogCount.poll();
				}
				continue;
			}
			if (CatCount.size()>0) {
				pet[i] = CatQueue.poll();
				continue;
			}
			if (DogCount.size()>0) {
				pet[i] = DogQueue.poll();
				continue;
			}
		}
		return pet;
	}
	
	//删除并拿出队列所有猫
	public Pet[] pollCat(){
		Pet[] pet = new Pet[CatQueue.size()];
		for (int i = 0; i < pet.length; i++) {
			pet[i] = CatQueue.poll();
		}
		return pet;
	}
	
	//删除并拿出队列所有狗
	public Pet[] pollDog(){
		Pet[] pet = new Pet[DogQueue.size()];
		for (int i = 0; i < pet.length; i++) {
			pet[i] = DogQueue.poll();
		}
		return pet;
	}
	
	//判断队列中是否还有宠物
	public boolean isEmpty(){
		return CatQueue.isEmpty() && DogQueue.isEmpty();
	}
	
	//判断队列中是否还有猫
	public boolean isCatEmpty(){
		return CatQueue.isEmpty();
	}
	
	//判断队列中是否还有狗
	public boolean isDogEmpty(){
		return DogQueue.isEmpty();
	}
}