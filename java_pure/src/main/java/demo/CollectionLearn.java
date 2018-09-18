package demo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@SuppressWarnings("all")
/**
 ������Դ洢�����������ͺ͵�һ���Ͷ��󣬵����ȹ̶� | ���Ͽ��Դ洢��ͬ���Ͷ��󣬵����ȿɱ�

 Collection====���Է���

 ------List��Ԫ��������ظ���������ϵ������====���Է���(���Ǳ����ɾ�Ĳ鷽��) | �б������
 ------ArrayList������ | ���ҿ���ɾ��
 ------LinkedList������ | ��������ɾ��
 getFirst()/getLast()/removeFirst()/removeLast()--����nosuchelement�쳣
 1.6-->  offerFirst()/offerLast()/peekFirst()/peekLast() -- ��ȡ��ɾ��| pollFirst()/pollLast() -- ��ȡɾ�� --����null

 ------Vector������ | ͬ������ArrayList���

 ------Set��Ԫ�����򲻿��ظ�====���Է��� | ֻ�е�����ȡ��
 ------HashSet����ϣ��
 HashSet��α�֤Ԫ��Ψһ��
 ͨ��hashCoe()��equals()���������
 ���Ԫ�ص�HashCodeֵ��ͬ���Ż��ж�equals�Ƿ�Ϊtrue
 ���HashCodeֵ��ͬ���������equals����

 ע�⣡�����ж�Ԫ���Ƿ���ڣ��Լ�ɾ���Ȳ����������ķ�����Ԫ�ص�hashCode��equals����

 ------TreeSet�������� | ���Զ�Ԫ������






 */
public class CollectionLearn {


    public static void main(String[] args) {

        ArrayList<String> alist = new ArrayList<>();
        alist.add("zhangsan");
        alist.add("wangwu");
        alist.add("lisi");
        alist.add("shanghai");
        alist.add("sb");
        alist.add("shanghai");

        ArrayList<Integer> iAList = new ArrayList<>();
        iAList.add(1);
        iAList.add(1);


//		readArrayList01(list);

//		readVector();

        LinkedList<String> llist = new LinkedList<>();
        llist.add("zhangsan");
        llist.add("wangwu");
        llist.add("lisi");
        llist.add("sb");

//		System.out.println(llist.removeFirst());

//		linkedListDemo01(llist);


//		System.out.println(rmRepeat(alist));

//		singlePerson();


    }


    /*******************************************************************
     * ȥ���ظ�����
     */
    private static void singlePerson() {
        ArrayList list = new ArrayList<>();

        list.add(new Person("zhangsan", 19));
        list.add(new Person("lisi", 42));
        list.add(new Person("wangwu", 25));
        list.add(new Person("lisi", 42));
        list.add(new Person("manzi", 66));

        list = singleList(list);

        Iterator it = list.iterator();
        while (it.hasNext()) {
            Person p = (Person) it.next();

            System.out.println(p.getName() + ":" + p.getAge());
        }

    }


    /**
     * ȥ��ArrayList�е��ظ�Ԫ��
     */
    private static ArrayList singleList(ArrayList srcList) {

        ArrayList list = new ArrayList<>();

        for (Iterator it = srcList.iterator(); it.hasNext(); ) {
            Object obj = it.next();
            if (!list.contains(obj)) {
                list.add(obj);
            } else {
                continue;
            }
        }

        return list;
    }


    /**
     * ʹ��LinkedListģ���ջ�Ͷ���
     */
    class Queue {
        private LinkedList list;

        public Queue() {
            list = new LinkedList<>();
        }

        public void add(Object obj) {
            list.addFirst(obj);
        }

        public Object get() {
            return list.peekLast();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }


    }


    /**
     * LinkedList
     */
    private static void linkedListDemo01(LinkedList<String> list) {
        System.out.println(list);
    }


    /**********************************************************
     * ö����Vector���еĵ�����ʽ
     */
    private static void readVector() {
        Vector<String> vector = new Vector<>();
        vector.add("zhangsan");
        vector.add("wangwu");
        vector.add("lis");
        vector.add("sb");

        Enumeration<String> en = vector.elements();
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
    }


    /*********************************************************
     * ����ArrayList--List���з���get(index)
     */
    private static void readArrayList03(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list[" + i + "]" + " = " + list.get(i));
        }
    }


    /**
     * ����ArrayList--for+������--forѭ���������ֲ�����Iterator���գ���ʡ�ڴ�
     */
    private static void readArrayList02(ArrayList<String> list) {
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }


    /**
     * ����ArrayList--while
     */
    private static void readArrayList01(ArrayList<String> list) {

        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            if (obj.equals("lisi")) {
                it.remove();
                System.out.println(it.next());
            }
        }
        System.out.println(list);
    }
}

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        } else {
            Person person = (Person) obj;
            return this.name.equals(person.name) && this.age == person.age;
        }
    }
}




























