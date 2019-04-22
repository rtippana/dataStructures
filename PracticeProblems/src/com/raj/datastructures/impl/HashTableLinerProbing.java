/**
 * 
 */
package com.raj.datastructures.impl;

/**
 * @author rajeev
 *
 */
public class HashTableLinerProbing<Key, Value> {
	
	private int size;
	public static int INITIAL_SIZE = 20; 
	private Key[] keys;
	private Value[] values;
	private int bucketSize;
	
	public HashTableLinerProbing() {
		this(INITIAL_SIZE);
	}
	
	public HashTableLinerProbing(int capactiy) {
		this.size =0;
		this.bucketSize=capactiy;
		keys = (Key[])new Object[capactiy];
		values = (Value[])new Object[capactiy];
		
	}
	
	public int size() {
		return this.size;
	}
	
	private void resize(int capacity) {
		
		this.bucketSize = capacity;
		HashTableLinerProbing<Key, Value> temp = new HashTableLinerProbing<Key,Value>(capacity);
		for(int i=0; i<this.size; i++) {
			temp.keys[i]=this.keys[i];
			temp.values[i]=this.values[i];
		}
		this.keys=temp.keys;
		this.values=temp.values;
		
		
	}
	
	public void put(Key key, Value value) {
		
		if(key == null) {
			throw new IllegalArgumentException("Null Keys are not allowed");
		}
		
		//resize if threshold is passed
		if((1.0*this.size)/this.bucketSize >0.60) {
			this.resize(bucketSize*2);
		}
		
		//Get the has code and traverse through the array 
		//to find the next spot that is null
		int hashInd = key.hashCode()%this.bucketSize;
		while(keys[hashInd]!=null) {
			
			//If the value is present update it.
			if(keys[hashInd].equals(key)) {
				values[hashInd] = value;
				return;
			}
			
			hashInd = (key.hashCode()+1)%this.bucketSize; //linear probing
			//Use below for quadratic probing. Initialize i=1.
			//hashInd = (key.hashCode()+i*i)%this.bucketSize; i++; //quadratic probing
			
		}
		keys[hashInd] = key;
		values[hashInd] = value;
		
		this.size++;
		
	}
	
	public Value get(Key key) {
		if(key == null) {
			throw new IllegalArgumentException("Null Keys are not allowed");
		}
		
		int hashInd = key.hashCode() % this.bucketSize;
		while(keys[hashInd]!=null) {
			if(keys[hashInd].equals(key)) {
				return values[hashInd];
			}
			hashInd = (hashInd +1) & this.bucketSize;
		}
		//Key not found
		return null;
	}
	
	public boolean contains(Key key) {
		return get(key)!=null;
	}
	
	public void delete(Key key) {
		
		if(key == null) {
			throw new IllegalArgumentException("Null Keys are not allowed");
		}
		int hashInd = key.hashCode() % this.bucketSize;
		while(!keys[hashInd].equals(key)) {
			hashInd = (hashInd +1) % this.bucketSize;
		}
		keys[hashInd] = null;
		values[hashInd]=null;
		this.size--;
		//Rehash the values to make sure this index can be used later.
		//Beacuase if we leave a gap the getMethod will stop looking as this finds the null
		hashInd = (hashInd+1)%this.bucketSize;
		while(keys[hashInd]!=null) {
			Key curKey = keys[hashInd];
			Value curVal = values[hashInd];
			keys[hashInd] = null;
			values[hashInd] = null;
			this.size--;
			put(curKey, curVal);
			hashInd = (hashInd+1)%this.bucketSize;
		}
		
		if(this.bucketSize >0 && (1.0*this.size)/this.bucketSize <0.5) {
			resize(this.bucketSize/2);
		}
		
		
	}

}
