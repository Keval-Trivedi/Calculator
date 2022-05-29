package calc.main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Calc {

    public static int add(String str) throws InvalidInputException
    {
        if(str.length() == 0)
        {
            return 0;
        }
        else if(str.startsWith("//"))
        {
            Matcher mchr = Pattern.compile("//(.)\n(.*)").matcher(str);
            boolean matched = mchr.matches();
            if(!matched)
            {
                String msg = "The given input is invalid : " + str;
                throw new InvalidInputException(msg);
            }

            String delim = mchr.group(1);
            str = mchr.group(2);
            return calculateSum(str, delim);
        }
        else
        {
            return calculateSum(str);
        }
    }

    private static int calculateSum(String str) throws InvalidInputException
    {
        return calculateSum(str,",|\n");
    }

    private static int calculateSum(String str, String delim) throws InvalidInputException
    {
        String[] tokens = str.split(delim);
        List<Integer> numbers = getInt(tokens);
        if(numbers.isEmpty())
        {
            throw new InvalidInputException("The given input is invalid and does not match with any criteria : " + str);
        }
        
        String negatives = numbers.stream().filter(number-> number < 0 ).map(Object::toString).collect(Collectors.joining(","));
        
        if(!negatives.isEmpty())
        {
            throw new InvalidInputException("Nagatives not allowed : " + negatives);
        }

        return numbers.stream().reduce(0,Integer::sum);
    }

    private static List<Integer> getInt(String[] tokens)
    {
        List<Integer> list = new ArrayList<>();
        for(String str : tokens)
        {
            list.add(Integer.valueOf(str));
        }
        return list;
    }

    
}
