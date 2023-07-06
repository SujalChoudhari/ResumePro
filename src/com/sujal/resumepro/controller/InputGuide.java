package com.sujal.resumepro.controller;

import java.util.Vector;

import javax.swing.JPanel;

import com.sujal.resumepro.ui.ContactPanel;
import com.sujal.resumepro.ui.IntroPanel;
import com.sujal.resumepro.ui.MainFrame;
import com.sujal.resumepro.ui.Progressable;

public class InputGuide {

	MainFrame mMainFrame;
	Vector<Progressable> mProgressables;
	private int mCurrentIndex = -1;
	
	
	public InputGuide() {
		mMainFrame = new MainFrame("Resume Pro");
		mProgressables = new Vector<Progressable>();
		mProgressables.add(new IntroPanel(this));
		mProgressables.add(new ContactPanel(this));
		next();
	}
	
	public void start() {
		mMainFrame.render();
		
	}
	
	public void next() {
		if(mCurrentIndex < mProgressables.size()) {
			mCurrentIndex ++;
			mMainFrame.showPanel((JPanel) mProgressables.get(mCurrentIndex));

		}
		
	}
	
	public void previous() {
		if(mCurrentIndex >=0) {
			mCurrentIndex --;
			mMainFrame.showPanel((JPanel) mProgressables.get(mCurrentIndex));
		}
	}

}
