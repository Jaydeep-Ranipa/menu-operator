package com.jaydeepranipa.menuoperator.core;

import java.util.Scanner;
import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SimpleMenu<I, T extends MenuAction> extends TreeMap<I, T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6557398708948006726L;

	private static Scanner scanner = new Scanner(System.in);

	private Integer exitIndex;
	private String header;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n--------------------------------------------------------------------------------");
		
		if (null != header) {
			builder.append("\n---<< " + header + " >>---");
		}
		
		builder.append("\n--------------------------------------------------------------------------------");
		keySet().forEach(index -> builder.append("\n" + describeMenuItem(index)));
		
		if (null != exitIndex) {
			builder.append("\n" + exitIndex + ". Exit");
		}
		
		builder.append("\n--------------------------------------------------------------------------------");
		return builder.toString();
	}

	private String describeMenuItem(I index) {
		return index + ". " + get(index).describe();
	}

	public void start() throws Exception {

		while (true) {
			System.out.println(this);
			System.out.print("Choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			if (!containsKey(choice) && choice != exitIndex) {
				System.out.println("Invalid Choice!!!");
			}

			if (choice == exitIndex) {
				scanner.close();
				break;
			}

			get(choice).act();
		}
	}

}
