/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midterm;

import java.util.Scanner;


public class palindrome {
	public static void main(String args []) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a word or number: ");
		String input = scanner.nextLine();

		String reverse = "";

		for (int i = input.length() - 1; i >= 0; i--) {
			reverse += input.charAt(i);
		}
		if (input.equalsIgnoreCase(reverse)) {
			System.out.println("It is a Palindrome!");
		} else {
			System.out.println("It is not a Palindrome!");
		}

	}
    
}
