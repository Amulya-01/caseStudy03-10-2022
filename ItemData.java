package com.gl.caseStudy2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;



public class ItemData {
	public static  Map<String,SnackItem> getAllItems(){
		return itemMap;
	}
	
	public static SnackItem getItem(String itemName) {
		
		SnackItem snackItem1 = itemMap.get(itemName);
		return snackItem1;
	}
	
	public static boolean isAvailable(String itemName) {
		boolean flag=itemMap.containsKey(itemName);
		return flag;
		
	}



	private static Map<String,SnackItem> itemMap=new LinkedHashMap<String,SnackItem>();
	static{
		try {
			
		FileReader fileReader = new FileReader("D:/Globallogic/SnackItem.txt");
		BufferedReader bReader=new BufferedReader(fileReader);
		boolean flag=false;
		while(true) {
			String str=bReader.readLine();
			if (str==null)
				break;
			String a[]=str.split("-");
			String status=a[2];
			if(status.equals("N")){
				continue;
			}
			
			String iName=a[0];
			String rate=a[1];
			String discountAmt=a[3];
			String disQty=a[4];
			itemMap.put(iName, new SnackItem());
	}
	
}catch(Exception ex) {}
	}
}


