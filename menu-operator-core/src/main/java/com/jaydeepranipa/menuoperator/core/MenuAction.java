package com.jaydeepranipa.menuoperator.core;

public interface MenuAction {

	public String describe();
	
	public void act() throws Exception;
}
