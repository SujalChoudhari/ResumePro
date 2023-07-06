package com.sujal.resumepro.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class MainFrame extends JFrame {

	private JPanel mContentPane;

	public MainFrame(String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		mContentPane = new JPanel();
		mContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mContentPane);
	}
	
	public void render() {
		setVisible(true);
	}
	
	public void showPanel(JPanel panel) {
	    mContentPane.removeAll();
	    mContentPane.setLayout(new GridBagLayout()); // Set BorderLayout for the content pane
	    mContentPane.add(panel); // Position the panel in the center
	    mContentPane.revalidate();
	    mContentPane.repaint();
	}


}
