package com.raj.datastructures.impl;

import java.util.ArrayList;

import com.raj.datastructures.nodes.HashNode;

public class HashTable<K,V> {

	//Size of the array
	int size;
	
	//Initial Bucket Size
	int bucketSize;
	
	//Bucket List to store the data - key value pairs
	ArrayList<HashNode<K,V>> bucketLst;
	
	private int getHashIndex(K key) {
		return key.hashCode()%bucketSize;
	}
	
	/*
	 *Uer Defined Hash Code for any Object
	 *  * Returns a hash code for this transaction.
     *

    public int hashCode() {
        int hash = 1;
        hash = 31*hash + who.hashCode();
        hash = 31*hash + when.hashCode();
        hash = 31*hash + ((Double) amount).hashCode();
        return hash;
        // return Objects.hash(who, when, amount);
    } 
	 * 
	 * 
	 
	 */
	//HashTable vs Binary Search Tree when to choose
	/*BST - has a sorting order, this can get max and min quickly
	 * and can traverse on a order, Hash table cannot
	 * We can use hash table when we need to lookup something fast - O(1)
	 * BST lookup is O(log n)
	 * 
	 * why Hasing is used
	 * hashing for web based apps may be used in many areas.. afew that come to my mind are to do with security... 

if u download a a chunk of data, its good practice to calculate its md5 hash and verify it with its precalculated correct md5 signature. 
hashing is also used for password security 
hashing can be used to maintain a hash of a previously fetched web page in browser caches and periodically the web page is retrieved and hashed if it has changed
	
	*/
	//Constructor to initialize the arrayList
	public HashTable() {
		this.size =0;
		this.bucketSize=20;
		this.bucketLst = new ArrayList<HashNode<K,V>>();
		for(int i=0; i<bucketSize; i++) {
			bucketLst.add(null);
	 	}
	 
	}
	
	//Methods
	
	public int size() {
		return this.size;
	}
	
	/*
	 * To put it to list
	 * 1. get the hash code to get the index of the bucketLst
	 *   if the threshold is > 80% increase the list.
	 * 2. If there no node at that index, then add it to it
	 * 3. If there is a node at this index -- collision
	 * 	 Get the Node and add it to the next node there the next node is null.
	 * 4. Increase size and done.
	 * 
	 */
	
	public void put(K key, V value) {
		int hashIndex =this.getHashIndex(key) ;
		if(bucketLst.get(hashIndex)==null) {
			bucketLst.set(hashIndex,new HashNode<K, V>(key, value));
		} else {
			HashNode<K,V> head = bucketLst.get(hashIndex);
			while(head != null) {
				if(head.key.equals(key)) {
					head.value=value;
					return;
				}
				head = head.next;
			}
			//insert into this position as head 
			HashNode<K,V> newNode = new HashNode<K,V>(key, value);
			newNode.next=bucketLst.get(hashIndex);
			bucketLst.set(hashIndex,newNode);
		}
		this.size++;
		
		//Check for the threshold say 80%
		this.reSize();
	}
	
	private void reSize() {
		if((size*1.0)/bucketSize >.80) {
			ArrayList<HashNode<K,V>> temp = this.bucketLst;
			this.bucketLst = new ArrayList<HashNode<K,V>>();
			this.bucketSize = 2*this.bucketSize;
			for(int i=0; i< this.bucketSize; i++) {
				this.bucketLst.add(null);
			}
			//copy the data and rehash
			for(HashNode<K,V> node: temp) {
				while(node!=null) {
					put(node.key, node.value);
					node = node.next;
				}				
			}
		}
	}
	
	/*
	 * Get the index based on the key
	 * Then get the Node from that index 
	 * search the linked list
	 */
	public V get(K key) {
		int hashIndex = this.getHashIndex(key);
		HashNode<K,V> current = this.bucketLst.get(hashIndex);
		while(current != null) {
			if(current.key.equals(key)) {
				return current.value;
			}
			current= current.next;
		}
		return null;
	}
	
	/*
	 * Find and remove the index
	 */
	public V remove(K key) {
		int hashIndex = this.getHashIndex(key) ;
		HashNode<K,V> current = this.bucketLst.get(hashIndex);
		HashNode<K,V> prev = null;
		while(current != null) {
			if(current.key.equals(key)) {
				//found value
				break;
			}
			prev = current;
			current= current.next;
		}
		if(current == null) {
			return null;
		}
		this.size--;
		if(prev!=null) {
			prev.next=current.next;
		} else {
			this.bucketLst.set(hashIndex, current.next);
		}

		return current.value;
	}
	
	
}
