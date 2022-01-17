package com.jaydeepranipa.menuoperator.core;

import java.util.Scanner;
import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Creates interactive Menu interface for the Java Console application. Takes
 * Sorted entries of Index and Action to perform the specified task on given
 * index. Once started, it will loop infinitely until exited. It will display
 * the menu, take the index input from Standard Input channel and perform the
 * task for that specified index.
 *
 * @author <a href="mailto:work.jaydeep.ranipa@gmail.com">Jaydeep Ranipa</a>
 *
 * @param <I> Menu Item Index Type
 * @param <T> Menu Item Action Type
 */
@NoArgsConstructor
@AllArgsConstructor
public class SimpleMenu<I, T extends MenuAction> extends TreeMap<I, T> {
	/**
	 * serialVersionUID = 6557398708948006726L
	 */
	private static final long serialVersionUID = 6557398708948006726L;

	/**
	 * for taking choice inputs from Standard Input channel
	 */
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * termination index for the menu-loop
	 */
	private Integer exitIndex;
	/**
	 * menu display header
	 */
	private String header;

	/**
	 * Describes each menu item along with its index in a sorted fashion. If
	 * 'header' is supplied, it will display that before all menu items. If
	 * 'exitIndex' is supplied, it will also describe the loop-termination action.
	 */
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

	/**
	 * Start the menu-loop. The menu-loop will display the menu, take the choice
	 * input and perform the action specified by the choice.
	 * 
	 * @throws Exception for any problems while performing the specified task as
	 *                   menu action.
	 */
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

	private String describeMenuItem(I index) {
		return index + ". " + get(index).describe();
	}

}
