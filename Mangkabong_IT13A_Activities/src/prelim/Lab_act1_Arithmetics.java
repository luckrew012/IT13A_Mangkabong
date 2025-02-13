
package prelim;

import java.util.Scanner;

/**
 *
 * @author bmang
 */
public class Lab_act1_Arithmetics {
     public static void main(String[] args) {
        // Define the integers directly in the code
      int num1 = 10; //first integer
      int num2 = 4; //second integer
      int num3 = 6; //third integer
              
        // Operation 1: Multiply the first number by the second, then add the third number
        int result1 = (num1 * num2) + num3;
        System.out.println("Operation 1 (num1 * num2 + num3): " + result1);

        // Operation 2: Subtract the second number from the first, then find the remainder when divided by the third number
        int result2 = (num1 - num2) % num3;
        System.out.println("Operation 2 (num1 - num2) % num3: " + result2);

        // Operation 3: Add the three numbers together, then divide by 3 to find the average (integer division)
        int result3 = (num1 + num2 + num3) / 3;
        System.out.println("Operation 3 (num1 + num2 + num3) / 3: " + result3);

     //Operation 4:Multiply the first and third numbers,then subract the square of the second number
     int result4 = (num1 * num3)- (num2 * num2);
     System.out.println("Operation 4 (num1 * num3 - num2^2):" +result4);
    }

    
}
