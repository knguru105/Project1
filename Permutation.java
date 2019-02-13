package Assingment1;

public class Permutation 
{
	public static void main(String[] args) throws Exception 
	{
	        String str = "ABC";
	        StringBuffer strBuf = new StringBuffer(str);
	        doPerm(strBuf,str.length());
	 }

	 static void doPerm(StringBuffer str, int index)
	 {

	        if(index <= 0)
	            System.out.println(str);            
	        else 
	        { 
	        	//recursively solve this by placing all other chars at current first pos1
	            doPerm(str, index-1);
	            int currPos = str.length()-index;
	            for (int i = currPos+1; i < str.length(); i++) 
	            {
	            	//start swapping all other chars with current first char
	                swap(str,currPos, i);
	                doPerm(str, index-1);
	                swap(str,i, currPos);//restore back my string buffer
	            }
	        }
	    }

	    static void swap(StringBuffer str, int pos1, int pos2)
	    {
	        char t1 = str.charAt(pos1);
	        str.setCharAt(pos1, str.charAt(pos2));
	        str.setCharAt(pos2, t1);
	    }

		public static void doPerm(String string, int index) {
			// TODO Auto-generated method stub
			
		}
	
}
