package ma.naf.calculator;

import java.util.Arrays;

public class Calculator {

    public int add(String numbers){

        String delimeter = "" ;


        if (numbers.startsWith("//")){
            delimeter = String.valueOf(numbers.charAt(2));
            if (delimeter.equals("[")){
                delimeter=getDelimitedDelimeter(numbers);
                numbers=numbers.substring(delimeter.length()+5,numbers.length());
            }else {
                numbers=numbers.substring(3,numbers.length());
            }
        }else {
            delimeter = "[,\\r\\n]" ;
        }
        if ("".equals(numbers)){
            return 0 ;
        }
        else if(!numbers.contains(",") && !numbers.contains("\n") && !numbers.contains(delimeter)){
            isNegative(numbers);
            if (!isBiggerThan1000(Integer.valueOf(numbers))){
                return Integer.valueOf(numbers) ;
            }else {
                return 0 ;
            }

        }else {
            int somme = 0;

            //return Arrays.asList(numbers).stream().map().reduce();

            String[] extractedNumbers = numbers.split(delimeter);

            for (String number: extractedNumbers) {
                String[] fromExtraxtedNumbers = number.split("[,\\r\\n]") ;
                for (String aNumber: fromExtraxtedNumbers) {
                    isNegative(aNumber) ;
                    if (! "".equals(aNumber) && !isBiggerThan1000(Integer.valueOf(aNumber))){
                        somme += Integer.valueOf(aNumber);
                    }
                }
            }
            return somme ;
        }

    }

    boolean isBiggerThan1000(Integer number){
        if (number > 1000){
            return true ;
        }else {
            return false ;
        }
    }
    public void isNegative(String number){
        if (number.startsWith("-")){
            throw new NegativeNumberException("Negative");
        }

    }

    public String getDelimitedDelimeter(String text){
        String tt = text.substring(3);
        String [] tt2 = tt.split("]");
        return tt2[0];

    }
}

/*
Arrays.asList(numbers).stream().reduce
 */