package com.op.demo;


import com.op.util.Stack2;

import java.util.*;

import static com.op.util.Print.println;

/**
 * 持有对象
 *
 * @Author: NZY
 * @Date: 2020/6/6 9:07 下午
 */
public class MyHoldObjects {
	public static void main(String[] args) {
		MyHoldObjects myHoldObjects = new MyHoldObjects();
		myHoldObjects.myCollectionDemo();
		println();
		myHoldObjects.myListDemo();
		println();
		myHoldObjects.myLinkedListDemo();
		println();
		myHoldObjects.myStackDemo();
		println();
		myHoldObjects.mySetDemo();
		println();
		myHoldObjects.myLinkedHashMapDemo();
		println();
		myHoldObjects.myHashMapDemo();
		println();
		myHoldObjects.myArrayDemo();
	}

	/**
	 * 数组拷贝 数组扩容
	 */
	void myArrayDemo() {
		// 数组拷贝
		int size = 10000;
		int[] src = new int[size];
		int[] des = new int[size];
		System.arraycopy(src, 0, des, 0, size);

		// 数组扩容
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		println(Arrays.toString(arr));
		println("arr length : " + arr.length);
		// 使用 System.arraycopy()
		int[] newArr = new int[10];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		println(Arrays.toString(newArr));
		println("newArr length : " + newArr.length);

	}

	void myCollectionDemo() {
		Collection<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3));
		for (Integer i : c) {
			println(i);
		}

		println();
		Integer[] m = {4, 5, 6};
		// 初始 Collection 为某对象
		c.addAll(Arrays.asList(m));

		for (Integer i : c) {
			println(i);
		}
	}

	void myListDemo() {
		// List 初始如果初始对象直接使用 Arrays.asList() 不可以进行 resize
		List<Integer> list = new ArrayList<>(Arrays.asList(7, 8, 10, 10));
		Iterator<Integer> it = list.iterator();
		// 获取List专属的迭代器
		ListIterator<Integer> lit = list.listIterator();

		list.set(2, 9);
		// 截取一段
		list = list.subList(0, 4);
		println(list.toString());

		// 使用 listIterator 实现正序 倒序遍历
		lit = list.listIterator();
		while (lit.hasNext()) {
			println(lit.next());
		}
		while (lit.hasPrevious()) {
			println(lit.previous());
		}
		it = list.iterator();
		// 使用迭代器清空集合
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		// 如果调用remove之前没有调用next是不合法的，会抛出IllegalStateException
		// 如果迭代器的指针已经指向了集合的末尾，那么如果再调用next()会返回NoSuchElementException异常
		println(list.toString());
	}

	void myLinkedListDemo() {
		LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		println(ll.peek());
		println(ll.element() + ll.getFirst());
	}

	void myArrayListDemo() {
		// ArrayList
	}

	void myStackDemo() {
		// 不建议使用 ava.util.stack ， 推荐使用 deque——double ended queue（双端队列）实现 LIFO
		// 栈
		Stack<String> s = new Stack<>();
		String hello = "hello it's me";
		String blank = " ";
		for (String s1 : hello.split(blank)) {
			s.push(s1);
		}
		while (!s.empty()) {
			println(s.pop());
		}

		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		// 使用 ArrayList 实现栈
		Stack2<Integer> s2 = new Stack2<>();
		for (Integer i : al) {
			s2.push(i);
		}
		// 相当于 peek()
		println(s2.peek());
		println(s2.toString());
	}

	void mySetDemo() {
		Random rand = new Random(47);
		Set<Integer> s = new HashSet<>();
		// 需要对结果排序就需要使用 TreeSet 替代 HashSet
		SortedSet<Integer> ss = new TreeSet<>(Arrays.asList(100, 200, 300));
		for (int i = 0; i < 10000; i++) {
			s.add(rand.nextInt(10));
		}
		println(ss);
		s.addAll(ss);
		println(s.contains(1));
		println(s);// HashSet的迭代器在输出时“不保证有序”，但也不是“保证无序”
	}

	void myLinkedHashMapDemo() {
		// 取 LinkedHashMap 中的某顺序值
		LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>();
		lhm.put(1, 2);
		lhm.put(2, 3);
		println(lhm.entrySet().iterator().next());
		println(lhm.entrySet().toArray()[0]);
	}

	void myHashMapDemo() {
		Random random = new Random(47);
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < 10000; i++) {
			// Produce a number between 0 and 20
			int r = random.nextInt(10);
			Integer freq = m.get(r);
			m.put(r, freq == null ? 1 : freq + 1);
		}
		println(m);
	}

}
