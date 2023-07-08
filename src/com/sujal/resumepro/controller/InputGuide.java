package com.sujal.resumepro.controller;

import java.util.Vector;

import javax.swing.JPanel;

import com.sujal.resumepro.ui.ContactPanel;
import com.sujal.resumepro.ui.EducationPanel;
import com.sujal.resumepro.ui.EndDataPanel;
import com.sujal.resumepro.ui.ExperiencePanel;
import com.sujal.resumepro.ui.IntroPanel;
import com.sujal.resumepro.ui.MainFrame;
import com.sujal.resumepro.ui.DataPanel;
import com.sujal.resumepro.ui.SkillPanel;

public class InputGuide {

	MainFrame mMainFrame;
	Vector<DataPanel> mDataPanels;
	private int mCurrentIndex = -1;
	
	
	public InputGuide() {
		mMainFrame = new MainFrame("Resume Pro");
		mDataPanels = new Vector<DataPanel>();
		mDataPanels.add(new IntroPanel(this));
		mDataPanels.add(new ContactPanel(this));
		mDataPanels.add(new SkillPanel(this));
		mDataPanels.add(new ExperiencePanel(this));
		mDataPanels.add(new EducationPanel(this));
		mDataPanels.add(new EndDataPanel(this));
		next();
	}
	
	public void start() {
		mMainFrame.render();
		
	}
	
	public void addNewAt(int index,DataPanel panel) {
		mDataPanels.add(index, panel);
	}
	
	public int getCurrentIndex() {
		return mCurrentIndex;
	}
	
	public void next() {
		if(mCurrentIndex < mDataPanels.size()) {
			mCurrentIndex ++;
			mMainFrame.showPanel((JPanel) mDataPanels.get(mCurrentIndex));

		}
		
	}
	
	public void previous() {
		if(mCurrentIndex >=0) {
			mCurrentIndex --;
			mMainFrame.showPanel((JPanel) mDataPanels.get(mCurrentIndex));
		}
	}
	
	public void updateData() {
		for(DataPanel panel: mDataPanels) {
			panel.updateData();
		}
	}

}
