package com.jaydeepranipa.menuoperator.core;

public class SystemExit implements MenuAction {

	@Override
	public String describe() {
		return "Exit the application";
	}

	@Override
	public void act() {
		System.exit(0);
	}

}
