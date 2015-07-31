package eos.ncsu.edu.csc316.project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;


/**
 * A method used to take in a file and makes a map based on user input. The user enters a valid file,
 * then another valid file. The first file is a list of areas or cities. The second is a 
 * list of connections. The user can choose various options from the given menu. "
 * @author Michael Huffman
 */
public class Driver {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
	//System.out.println("Enter file name: ");
	Scanner s = new Scanner("cities.txt");
	String input = s.nextLine();
	File f = new File(input);
	//scan in a file
	try {
		s = new Scanner(f);
	} catch (FileNotFoundException y) {
		
		y.printStackTrace();
	}
	AJGraph test = new AJGraph();
	while(s.hasNext()) {
		String check = s.nextLine();
		
	Vertice r = new Vertice(check);
	test.insertVertex(check);
	
	}
	
	//System.out.println("Enter file name: ");
	s = new Scanner("connects.txt");
	input = s.nextLine();
	f = new File(input);
	//scan in a file
	try {
		s = new Scanner(f);
	} catch (FileNotFoundException y) {
		
		y.printStackTrace();
	}
	while(s.hasNext()) {
		String check = s.nextLine();
		//System.out.println(check);
	
		String checkfor = check;
		String[] qwe = checkfor.split(";");
		//System.out.println(qwe.length);
		String[] sarr = new String[qwe.length];
		int[] iarr = new int[qwe.length];
	
	
	
	String delims = "[:,;]+";
	String[] token1 = check.split(delims);
	
	int test1 = 0;
	int test2 = 0;
	for(int i = 1; i < token1.length; i += 2) {
		String insert = token1[i];
		int n = Integer.parseInt(token1[i+1]);
		sarr[test1] = insert;
		iarr[test1] = n;
		test1++;
		
		
	}
	
	test1 = 0;
	
	sort(sarr, iarr);
	
	for(int i = 0; i < sarr.length; i ++) {
		
		//int n = Integer.parseInt(token1[i+1]);
		String insert = sarr[i];
		int n = iarr[i];
		test.insertEdge2(token1[0], insert, n);
		
	}
	}
	
	
	
	while(true) {
	System.out.println("This program will use the traversal slected to show the data from file(s) given."); 
	System.out.println("Enter 1 to DFS. " +
			"2 for BFS. 3 for shortest path. 4 to change weights. " +
			"5 to clear. 6 to exit.");
	Scanner user = new Scanner(System.in);
	String che = user.next();
	if(che.equals("1")) {
		System.out.println("Enter a correct name of a city: ");
		Scanner ser = new Scanner(System.in);
		String sert = ser.nextLine();
		test.DFSh(sert);
		test.reset();
		//System.out.println("done");
	} else if(che.equals("2")) {
		System.out.println("Enter a correct name of a city: ");
		Scanner ser = new Scanner(System.in);
		String sert = ser.nextLine();
		test.BFSh(sert);
		test.reset();
		//System.out.println("done");
	} else if(che.equals("3")) {
		System.out.println("Enter a correct name of a city: ");
		Scanner ser = new Scanner(System.in);
		String sert = ser.nextLine();
		System.out.println("Enter a correct name of a city: ");
		ser = new Scanner(System.in);
		String sert2 = ser.nextLine();
		test.dih(sert, sert2);
		test.reset();
	} else if(che.equals("4")) {
		System.out.println("Enter a correct name of a city: ");
		Scanner ser = new Scanner(System.in);
		String sert = ser.nextLine();
		System.out.println("Enter a correct name of a city: ");
		ser = new Scanner(System.in);
		String sert2 = ser.nextLine();
		System.out.println("Enter a correct value for a wieght: ");
		ser = new Scanner(System.in);
		String sert3 = ser.nextLine();
		int sert4 = Integer.parseInt(sert3);
		test.changeWeight(sert, sert2, sert4);
		
	} else if(che.equals("5")) {
		test.superreset();
	} else if(che.equals("6")) {
		return;
	}
	}
    }
	
	
	/**
	 * Sorts the input given by the user in the second file.
	 * @param sarr
	 * @param iarr
	 */
	public static void sort(String[] sarr, int[] iarr) {
		for(int i = 0; i < sarr.length - 1; i++){
			int m = i;
			for(int j = i +1; j < sarr.length; j++) {
				//System.out.println(sarr.length);
				//System.out.println(sarr[j]);
				//System.out.println(sarr[m]);
				if(sarr[j].compareTo(sarr[m]) < 0) {
					m = j;
				}
			}
			
			if(m != i) {
				String temp = sarr[i];
				sarr[i] = sarr[m];
				sarr[m] = temp;
				
				int temp2 = iarr[i];
				iarr[i] = iarr[m];
				iarr[m] = temp2;
			}
		}
	}
	
}

