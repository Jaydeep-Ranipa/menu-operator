package com.jaydeepranipa.menuoperator.core;

/**
 * Specifies the Menu Action description and action. The instance of this is to
 * be put into {@link SimpleMenu} object in order to perform menu related
 * actions.
 *
 * @author <a href="mailto:work.jaydeep.ranipa@gmail.com">Jaydeep Ranipa</a>
 *
 */
public interface MenuAction {

	/**
	 * Specifies the menu action description.
	 * 
	 * @return menu action description
	 */
	public String describe();

	/**
	 * Specifies the actual menu action task.
	 * 
	 * @throws Exception for any problems while performing the specified task as
	 *                   menu action.
	 */
	public void act() throws Exception;
}
