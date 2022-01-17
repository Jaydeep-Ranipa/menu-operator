package com.jaydeepranipa.menuoperator.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSimpleMenu {
	
	private static SimpleMenu<Integer, MenuAction> menu;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		menu = new SimpleMenu<>(999, "Simple Menu");
		menu.put(1, new MenuAction() {
			
			@Override
			public String describe() {
				return "Display Day";
			}
			
			@Override
			public void act() {
				System.out.println("Name: Monday");
			}
		});
		
		menu.put(2, new MenuAction() {
			
			@Override
			public String describe() {
				return "Display Date";
			}
			
			@Override
			public void act() {
				System.out.println("Date: 17 Jan 2022");
			}
		});
	}

	@AfterEach
	void tearDown() throws Exception {
		menu.start();
	}

	@Test
	void test() {
		
	}

}
