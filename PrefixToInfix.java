package prefix2infix;
import java.util.HashMap;
import java.util.Map;


public class PrefixToInfix
{
	static final Map<String, Integer> oper = new HashMap<String,Integer>();
	
    static 
    { 
    	oper.put("+", 1); oper.put("-", 1); oper.put("*", 2); oper.put("/", 2); 
    	
    }

    static class Source
    {
    	int index = 0;
        String token;
        final String s;
        Source(String s) 
        { 
        	this.s = s; 
        	
        }
        
        String next() 
        {
        	return token = index >= s.length() ? null : s.substring(index, ++index);

        }
    }

    static String parse(String s)
    {
    	return parse(new Source(s), 0);
    	
    }

    static String parse(Source t, int prec) 
    {
        Integer self = oper.get(t.next());
        if (self != null)
        {
            String op = t.token;
            String result = String.format("%s%s%s",parse(t, self), op, parse(t, self));
            if (self < prec) result = "(" + result + ")";
            return result;
        }
        else
            return t.token;
    }

    static void test(String prefix)
    { 
    	System.out.println("Prfix Expression : "+prefix + "\nInfix Expression: " + parse(prefix));
    
    }

    public static void main(String[] args)
    {
    
    	System.out.println("Prfix Expression to Infix Expression:");
    	test("-4/+1*327");
    	System.out.println();
        test("+-a*bc/de");
        System.out.println();
        test("*-ab+cd");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}