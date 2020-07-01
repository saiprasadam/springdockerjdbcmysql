package com.poc.demo.jdbc.exception;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TestProj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="1. siva is good. 2. sai is good. 3. mahesh is nice person. 4. ram heart cp-1013. 5. kumar paid amt c#100.";
	//	String str01[]=str.split(".");
	//	System.out.println("value111"+str01[1]);
		String[] strArray = str.split("(?=\\d)(?<=\\-D).*");
		for(int i=0;i<strArray.length;i++) {
	//	for(String ar:strArray) {
			System.out.println("--111--**--"+strArray[i]+"\n");
				
		}
			
		String[] strArray1 = str.split("^[^\\d].*");
		
		for(int i=0;i<strArray1.length;i++) {
			//	for(String ar:strArray) {
					System.out.println("--2211--**--"+strArray1[i]+"\n");
						
				}

	/*	Pattern pattern = Pattern.compile("[1-9]. ");	
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb=new StringBuffer(".");
		
		//matcher.appendTail(sb);
		//matcher.appendReplacement(sb,"\n");
		//matcher.start(str);
		System.out.println("Using replaceAll: " + matcher.replaceAll("\n"));
		String st=(String) matcher.replaceAll("\n");
		String [] arStr=st.split(".");
		System.out.println("\n");
		int arCount=1;
		for(String ar:arStr) {
			System.out.println("----**--"+ar);
			System.out.println(arCount+". "+ar);
			arCount++;	
		}
		System.out.println("val1"+st);
		
		
		
				//("(?<=[0-9]|//.)");
			//	"(?<=\\d)(?=\\D)|(?=\\d)(?<=\\D)"
	//	System.out.println("----"+strArray[0]);
	//	System.out.println("----"+strArray1[1]);
		//System.out.println("----"+strArray1[2]);
		
		System.out.println("tes--------"+strArray[0]);
		System.out.println("tes--------"+strArray[1]);
		System.out.println("tes--------"+strArray[2]) ;
		//System.out.println("tes1--------"+strArray1[3]);
		System.out.println("tes--------"+strArray[3]);
	//	System.out.println("tes1--------"+strArray1[4]);
	//	System.out.println("tes--------"+strArray[4]);
		
	//.out.println("tes--------"+strArray[3]);
		System.out.println("test1222--------"+str.split("/[1-10]+|[^a-z]+/gi").toString());
		for(String st11:str.split("/[a-z]+|[^a-z]+/gi"))
		{
			System.out.println("test1--------\n"+st11);
		}
		//str.split("/[a-z]+|[^a-z]+/gi");
*/
	}

}
