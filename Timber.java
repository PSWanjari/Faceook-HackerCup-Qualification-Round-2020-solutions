package FaceBook;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class QualifingRoundC {

	public static void main(String[] args) throws FileNotFoundException {
		
	
		Scanner sc = new Scanner(new File("C:\\Users\\mswan\\eclipse-workspace\\Coding\\src\\FaceBook\\input.txt"));
		int test_cases=sc.nextInt();
		for(int i=0;i<test_cases;i++)
		{
			ArrayList<int[]> parent= new ArrayList<int[]>();
			int[] dummyArray = new int[3];
			int N = sc.nextInt();
			//getting the input and storing it in the arraylist of array with the same tree having same id
			for(int j=1;j<=N;j++)
			{
				int a =sc.nextInt();
				int b = sc.nextInt();
				parent.add(new int[] {a-b,a,j});
				parent.add(new int[] {a,a+b,j});
	
			}
			
			/*
			 * for (int[] tempArray : parent) {
			 * System.out.println(tempArray[0]+"->"+tempArray[1]+"|"+tempArray[2]); }
			 */
			 
			//sorting the parent arraylist on basis of the source the first element of the child array
			//defining a custom comparator
			Collections.sort(parent, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
				
					return o2[0]-o1[0];
					
				}
			});
			
			
			/*
			 * System.out.
			 * println("-----------------Arraylist After Sorting-----------------------------"
			 * );
			 * 
			 * for (int[] tempArray : parent) {
			 * System.out.println(tempArray[0]+"->"+tempArray[1]+"|"+tempArray[2]); }
			 */
			 
			/*iterrate the map from bottom to top 
			*creating a two hashmap 
			*1 mapSrcToDest -> to store the source and destination having the largest length
			*2 mapSrcToId	-> to store the source and index
			*/
			HashMap<Integer, TreeMap<Integer, Integer>> FinalMap = new HashMap<Integer, TreeMap<Integer,Integer>>();
			int[] tempArray;
			for(int j=0;j<parent.size();j++)
			{
				tempArray=parent.get(j);
				int src = tempArray[0];
				int dest=tempArray[1];
				int id = tempArray[2];
				if(FinalMap.containsKey(src) && FinalMap.containsKey(dest))
				{
					int value=0;
					int f=0;
					TreeMap<Integer, Integer> tempmap = FinalMap.get(dest);
					for (Entry<Integer, Integer> item : tempmap.entrySet()) {
						if(id!=item.getValue())
						{
							f=1;
							value=item.getKey();
							break;
						}
					}
					TreeMap<Integer, Integer> temp = new TreeMap<Integer, Integer>(Collections.reverseOrder());
					//value not found
					if(f==0)
					{   
						temp.put(dest-src, id);
					}else {
						
						temp.put((dest-src)+value, id);
						
					}
					FinalMap.put(src, temp);
					
				}else if(FinalMap.containsKey(src) && !FinalMap.containsKey(dest)){
				
					TreeMap<Integer, Integer> tempmap = FinalMap.get(src);
					tempmap.put(dest-src, id);
					
				}else if(!FinalMap.containsKey(src) && FinalMap.containsKey(dest))
				{	
					int value=0;
					int f=0;
					TreeMap<Integer, Integer> tempmap = FinalMap.get(dest);
					for (Entry<Integer, Integer> item : tempmap.entrySet()) {
						if(id!=item.getValue())
						{
							f=1;
							value=item.getKey();
							break;
						}
						
					}
					TreeMap<Integer, Integer> temp = new TreeMap<Integer, Integer>(Collections.reverseOrder());
					//value not found
					if(f==0)
					{   
						temp.put(dest-src, id);
					}else {
						
						temp.put((dest-src)+value, id);
						
					}
					FinalMap.put(src, temp);
					
				}else if(!FinalMap.containsKey(src) && !FinalMap.containsKey(dest)) {
					TreeMap<Integer, Integer> tempmap = new TreeMap<Integer, Integer>(Collections.reverseOrder());
					tempmap.put(dest-src, id);
					FinalMap.put(src, tempmap);
				}
			}
			int ans =-2147483648;
			//System.out.println("--------------------------After processing---------------------");
			for (Entry<Integer, TreeMap<Integer, Integer>> item : FinalMap.entrySet()) {
				//System.out.print(item.getKey()+"-->\n");
				for (Entry<Integer, Integer> key : item.getValue().entrySet()) {
					if(ans<key.getKey())
					{
						ans=key.getKey();
					}
					//System.out.println("-------"+key.getKey()+"|"+key.getValue());
				}
			}
			System.out.println("Case #"+(i+1)+": "+ans);
		}
		
		

	
	}

}

