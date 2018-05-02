//
// Zheng.Sun15
// ID number: 1507820
import java.util.*;

public class SocalSecurityNumberValidation {

    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Please enter the social security number(format: XXX-XX-XXXX):");

        String socialSecutityNumber = input.nextLine();
        
        if (socialSecutityNumber.length() == 11 ){
            String socialSecurityNumberToDigits = onlyDigits(socialSecutityNumber);
            
            if(furtherResrictions(socialSecutityNumber,socialSecurityNumberToDigits))
                System.out.println("The social security number entered is valid.");
            else 
                System.out.println("INVALID input!");
        }
        else{
            System.out.println("INVALID input!");
        }
    }
    
    //extract digits from input String 
    public static String onlyDigits(String x){
        String y = "";
        char[] xToArray = x.toCharArray();
        for(int i = 0; i < xToArray.length; i++){
            if (xToArray[i] >= '0' && xToArray[i]<= '9')
                y = y + String.valueOf(xToArray[i]);
        }
        return y;
    }
    
    //x, original 11-character input string, y, digits of the input string
    public static boolean furtherResrictions(String x, String y){
        
        boolean restrictionFlagSatisfied = true;
        
        //test if only contain 9 digits and "-"
        if (!(y.length() == 9)){
               restrictionFlagSatisfied = false;
        }
        if (!x.substring(3, 4).equals("-") && !x.substring(6, 7).equals("-")){
               restrictionFlagSatisfied = false;
        }
        
        //test not start with "000" or "666"
        if (y.substring(0, 3).equals("000")||y.substring(0, 3).equals("666")){
            
            restrictionFlagSatisfied = false;
        }
        
        //test not end with "0000"
        if (y.substring(5, 9).equals("0000")){
                restrictionFlagSatisfied = false;
        }       
        
        return restrictionFlagSatisfied;
    }
    
}
