package com.jaydeepranipa.menuoperator.core;

/**
 * A menu item to exit the application.
 *
 * @author <a href="mailto:work.jaydeep.ranipa@gmail.com">Jaydeep Ranipa</a>
 *
 */
public class SystemExit implements MenuAction {

	@Override
	public String describe() {
		return "Exit the application";
	}

	/**
	 * Exit the JVM.
	 */
	@Override
	public void act() {
		System.exit(0);
	}

}
