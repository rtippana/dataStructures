package com.raj.test;

import com.raj.datastructures.impl.HashTable;
import com.raj.datastructures.impl.HashTableLinerProbing;

public class HahsTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable<Integer,String> map = new HashTable<Integer,String>();
		map.put(1,"Abc");
		map.put(4,"Dude");
		System.out.println(map.get(1));
		System.out.println(map.get(4));
		System.out.println(map.size());

		//Arrays HashTable linear probing
		HashTableLinerProbing<Integer, String> hashTable = new HashTableLinerProbing<Integer, String>();
		System.out.println(hashTable.size());

		hashTable.put(1, "Rudy");
		hashTable.put(3, "Gen");
		System.out.println(hashTable.size());
		System.out.println(hashTable.get(1));
		System.out.println(hashTable.get(2));
		System.out.println(hashTable.get(3));

		hashTable.delete(3);
		System.out.println(hashTable.get(3));
		System.out.println(hashTable.size());

	}

}
