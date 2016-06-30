package com.thoughtworks.marchant_guide.ui.fragment;

/*
 * Interface to give callaback to HomeFragment when user wish to change Galexy system. 
 * The callback onClodeDialog is used to inform Home Fragment that user have choose to change galaxy conversion system
 *  Thus we need to update keybinding according to new galaxy system
 */
public interface DialogCloseListener {

	/*
	 * User have changed galaxy update keyboard binding according to new galaxy
	 * system
	 */
	void OnCloseDialog(int pageIndex);
}