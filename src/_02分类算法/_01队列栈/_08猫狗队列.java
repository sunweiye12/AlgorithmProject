package _02�����㷨._01����ջ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 ��Ŀ����:è������ ����Ŀ�� �������è�������£�
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
	
����:ʵ��һ�ֹ�è���еĽṹ��Ҫ�����£� �û����Ե���add������cat���dog���
	ʵ����������У� �û����Ե���pollAll�����������������е�ʵ�����ս�����
	���Ⱥ�˳�����ε����� �û����Ե���pollDog��������������dog���ʵ������
	�����е��Ⱥ�˳�����ε����� �û����Ե���pollCat��������������cat���ʵ
	�����ս����е��Ⱥ�˳�����ε����� �û����Ե���isEmpty����������������
	����dog��cat��ʵ���� �û����Ե���isDogEmpty���������������Ƿ���dog
	���ʵ���� �û����Ե���isCatEmpty���������������Ƿ���cat���ʵ��
˼·:�ֱ𴴽�����è���к����������л���һ��������,
	������è����Ϊ��,����һ��è���д�Ŵ�����è����,��һ��è���д�ż�����,
	ÿ����Ӷ���ʱ,�ͽ�����ŵ���Ӧ�Ķ�����,Ȼ�����ٽ�����������ŵ���Ӧ�Ķ�����,Ȼ���������һ
	�ڻ�ȡȫ����,�ͻ�Ƚ�������ż������Ķ����Ǹ���ŵ����ָ�С,�ڴ�����ָ�С�Ķ����»�ȡ����,
	������Ӧ�ļ���������Ҳȥ��
 * @author Administrator
 *
 */
public class _08è������ {
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

//--------------------����---------------------------------
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
	
	//��ӳ������
	public void add(Pet pet){
		if (pet instanceof Cat) {
			CatQueue.add(pet);
			CatCount.add(count++);
		}else if (pet instanceof Dog) {
			DogQueue.add(pet);
			DogCount.add(count++);
		} else {
			throw new RuntimeException("����ĳ������Ͳ���è��");
		}
	}
	
	//ɾ�����ó��������г���
	public Pet[] pollAll(){
		Pet[] pet = new Pet[count]; //����һ���ܶ��д�С����������ʢ�ŴӶ�����poll���ĳ���
		for (int i = 0; i < pet.length; i++) {
			//�Ǹ������Ӧ���±�С���Ƚ��Ǹ����еĳ���ŵ�������
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
	
	//ɾ�����ó���������è
	public Pet[] pollCat(){
		Pet[] pet = new Pet[CatQueue.size()];
		for (int i = 0; i < pet.length; i++) {
			pet[i] = CatQueue.poll();
		}
		return pet;
	}
	
	//ɾ�����ó��������й�
	public Pet[] pollDog(){
		Pet[] pet = new Pet[DogQueue.size()];
		for (int i = 0; i < pet.length; i++) {
			pet[i] = DogQueue.poll();
		}
		return pet;
	}
	
	//�ж϶������Ƿ��г���
	public boolean isEmpty(){
		return CatQueue.isEmpty() && DogQueue.isEmpty();
	}
	
	//�ж϶������Ƿ���è
	public boolean isCatEmpty(){
		return CatQueue.isEmpty();
	}
	
	//�ж϶������Ƿ��й�
	public boolean isDogEmpty(){
		return DogQueue.isEmpty();
	}
}