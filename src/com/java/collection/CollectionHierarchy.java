//This is copied from https://github.com/in28minutes/JavaInterviewQuestionsAndAnswers/blob/master/docs/collections.md
//This is just for my own learning
package com.java.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

interface Collection<E> extends Iterable<E> {
	int size();

	boolean isEmpty();

	boolean contains(Object paramObject);

	Iterator<E> iterator();

	Object[] toArray();

	boolean add(E paramE);

	boolean remove(Object paramObject);

	boolean containsAll(Collection<?> paramCollection);

	boolean addAll(Collection<? extends E> paramCollection);

	boolean removeAll(Collection<?> paramCollection);

	boolean retainAll(Collection<?> paramCollection);

	void clear();

	boolean equals(Object paramObject);

	int hashCode();
}

// Unique things only - Does not allow duplication.
// If obj1.equals(obj2) then only one of them can be in the Set.
interface Set<E> extends Collection<E> {

}


//Main difference between Set and SortedSet is the laterone maintains the elements in sorted order.
//Set interface does not guarantee
interface SortedSet<E> extends Set<E> {
 
  Comparator<? super E> comparator();
  
  SortedSet<E> subSet(E fromElement, E toElement);
 
  SortedSet<E> headSet(E toElement);
  
  SortedSet<E> tailSet(E fromElement);
  
  E first();
 
  E last();
}



//Set -> SortedSet -> NavigableSet
//This is also a sortedset extended with navigation methods
interface NavigableSet<E> extends SortedSet<E> {
  
  E lower(E e);

  E floor(E e);

  E ceiling(E e);

  E higher(E e);

  E pollFirst();

  E pollLast();
}

// A, X , B
// X, A ,B
class HashSet /* implements Set */{
	// unordered, unsorted - iterates in random order
	// uses hashCode()
}

// A, X, B
// A, X, B
class LinkedHashSet /* implements Set */{
	// ordered - iterates in order of insertion
	// unsorted
	// uses hashCode()
}

// A,C,B
// A,B,C
class TreeSet /* implements Set,NavigableSet */{
	// 3,5,7
	// sorted - natural order
	// implements NavigableSet
}


// LIST OF THINGS
// Cares about which position each object is in
// Elements can be added in by specifying position - where should it be added in
// If element is added without specifying position - it is added at the end
interface List<E> extends Collection<E> {

	// [1,2,3,4]
	// batsman - "Sachin", "Kohli" , "Ponting", "Lara", "Kohli"
	// 0 1 2 3 4
	// batsman.remove(1);
	// bastman.get(2);
	// bastman.set(2,"Ponting"))
	//
	boolean addAll(int paramInt, Collection<? extends E> paramCollection);

	E get(int position);

	E set(int position, E paramE);

	void add(int position, E paramE);

	E remove(int paramInt);

	int indexOf(Object paramObject);

	int lastIndexOf(Object paramObject);

	ListIterator<E> listIterator();

	ListIterator<E> listIterator(int paramInt);

	List<E> subList(int paramInt1, int paramInt2);
}

class ArrayList /* implements List<E>, RandomAccess */{
	// implements RandomAccess, a marker interface, meaning it support fast -
	// almost constant time - access
	// Insertion and Deletion are slower compared to LinkedList
}

class Vector /* implements List<E>, RandomAccess */{
	// Thread Safe - Synchronized Methods
	// implements RandomAccess, a marker interface, meaning it support fast -
	// almost constant time - access
}

class LinkedList /* implements List<E>, Queue */{
	// Elements are doubly linked - forward and backword - to one another
	// Ideal choice to implement Stack or Queue
	// Iteration is slower than ArrayList
	// Fast Insertion and Deletion
	// Implements Queue interface also. So, supports methods like peek(), poll()
	// and remove()
}

// Arranged in order of processing - A to-do list for example
// Queue interface extends Collection. So, it supports all Collection Methods.
interface Queue<E> extends Collection<E> {
	boolean add(E paramE);//Insert the elements into the queue. Throws exception in case of failure.

	boolean offer(E paramE);//Same as add. Return false in case of failure.

	E remove();//Return and remove the top element from the queue.Throws exception if queue is empty.

	E poll();//Same as remove(). Return null if queue is empty.

	E element();

	E peek();//Return the element but will NOT be removed from the queue.
}

//Queue with processing at both end
interface Deque<E> extends Queue<E> {

	void addFirst(E e);

	void addLast(E e);

	boolean offerFirst(E e);

	boolean offerLast(E e);

	E removeFirst();

	E removeLast();

	E pollFirst();

	E pollLast();

	E getFirst();

	E getLast();

	E peekFirst();

	E peekLast();

	boolean removeFirstOccurrence(Object o);

	boolean removeLastOccurrence(Object o);

	boolean add(E e);

	boolean offer(E e);

	E remove();

	E poll();

	E element();

	E peek();

	void push(E e);

	E pop();

	boolean remove(Object o);

	boolean contains(Object o);

	public int size();

	Iterator<E> iterator();

	Iterator<E> descendingIterator();

}


//Queue with wait feature
//Will wait until the element is available - Producer consumer problem
interface BlockingQueue<E> extends Queue<E> {
    boolean add(E e);//Same as Queue Interface

    boolean offer(E e);//Same as Queue Interface

    void put(E e) throws InterruptedException;

    boolean offer(E e, long timeout, TimeUnit unit)
        throws InterruptedException;//Wait for specified time to add the element, time timeout return back

    E take() throws InterruptedException;//Same offer(E e, long timeout, TimeUnit unit) but wait until availability 

    E poll(long timeout, TimeUnit unit)
        throws InterruptedException;//Wait for specified time to add the element, time timeout return null

    int remainingCapacity();

    boolean remove(Object o);

    public boolean contains(Object o);

    int drainTo(Collection<? super E> c);

    int drainTo(Collection<? super E> c, int maxElements);
}

class PriorityQueue /* implements Queue */{
	// sorted - natural order
}

class ArrayDeque /*implements Deque*/{
	
}


class ArrayBlockingQueue /*implements BlockingQueue*/{
	//uses Array. Optionally bounded.
}

class LinkedBlockingQueue /*implements BlockingQueue*/{
	//uses LinkedList. Optionally bounded.
}

// A,C,A,C,E,C,M,D,H,A

// {("A",5),("C",2)}

// "A","B","C"

// {["key1",value1],["key2",value2],["key3",value3]}

// Things with unique identifier
// Key - Value Pair
interface Map<K, V> {
	int size();

	boolean isEmpty();

	boolean containsKey(Object paramObject);

	boolean containsValue(Object paramObject);

	V get(Object key);

	V put(K key, V value);

	V remove(Object key);

	void putAll(Map<? extends K, ? extends V> paramMap);

	void clear();

	Set<K> keySet();

	Collection<V> values();

	Set<Entry<K, V>> entrySet();

	boolean equals(Object paramObject);

	int hashCode();

	public static abstract interface Entry<K, V> {
		K getKey();

		V getValue();

		V setValue(V paramV);

		boolean equals(Object paramObject);

		int hashCode();
	}
}



//Ordered Map based on the keys. Comparator can be provided
interface SortedMap<K,V> extends Map<K,V> {
    
    Comparator<? super K> comparator();

    SortedMap<K,V> subMap(K fromKey, K toKey);

    SortedMap<K,V> headMap(K toKey);

    SortedMap<K,V> tailMap(K fromKey);

    K firstKey();

    K lastKey();
}



interface NavigableMap<K,V> extends SortedMap<K,V> {
    
	Map.Entry<K,V> lowerEntry(K key);

    K lowerKey(K key);

    Map.Entry<K,V> floorEntry(K key);

    K floorKey(K key);

    Map.Entry<K,V> ceilingEntry(K key);

    K ceilingKey(K key);
    
    Map.Entry<K,V> higherEntry(K key);

    K higherKey(K key);

    
    Map.Entry<K,V> firstEntry();

   
    Map.Entry<K,V> lastEntry();

    
    Map.Entry<K,V> pollFirstEntry();

   
    Map.Entry<K,V> pollLastEntry();

    
    NavigableMap<K,V> descendingMap();

    
    NavigableSet<K> navigableKeySet();

    
    NavigableSet<K> descendingKeySet();

    
    NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
                             K toKey,   boolean toInclusive);

    
    NavigableMap<K,V> headMap(K toKey, boolean inclusive);

    
    NavigableMap<K,V> tailMap(K fromKey, boolean inclusive);
}


class HashMap /* implements Map */{
	// unsorted, unordered
	// key's hashCode() is used
}

class Hashtable /* implements Map */{
	// Synchronized - Thread Safe - version of HashMap
	// unsorted, unordered
	// key's hashCode() is used
	// HashMap allows a key with null value. Hashtable doesn't.
}

class LinkedHashMap /* implements Map */{
	// insertion order is maintained (optionally can maintain access order as
	// well)
	// slower insertion and deletion
	// faster iteration
}

// A,C,B
// A,B,C
class TreeMap /* implements Map,NavigableMap */{
	// sorted order is maintained
	// implements NavigableMap
}



//Collections.synchronizedMap(aMap) -> Decorator pattern -> 
//just need to pass the map as parameter to synchronizedMap() to make it synchronized (this is fully synchtonized map)
//Instead of using synchronizedMap(aMap), better to use java.util.ConcurrentHashMap.
//ConcurrentHashMap support full concurrency during retrieval/read.
//Writes require a lock but this does not need to be locked on entire map table. 
//The concurrentHashMap, is divided into multiple segments and each segments contains multiple buckets.
//Wirte lock may be required only on 1 segment but NOT on other segments. 
//By default the concurrent hashmap is divided into 16 segments.
//NULL key is not allowed in ConcurrentHashMap



public class CollectionHierarchy {
}
