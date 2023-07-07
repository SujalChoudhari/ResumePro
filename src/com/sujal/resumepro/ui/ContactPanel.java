package com.sujal.resumepro.ui;

import com.sujal.resumepro.controller.InputGuide;
import com.sujal.resumepro.converter.InformationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactPanel extends JPanel implements DataPanel {

    private InputGuide mInputGuide;
    private JTextArea mAddressTextArea;
    private JTextField mEmailTextField;
    private JTextField mPhoneTextField;
    private JTextField mWebsiteTextField;

    public ContactPanel(InputGuide inputGuide) {
        mInputGuide = inputGuide;
        setLayout(new BorderLayout());

        // Create components for the contact page
        JLabel titleLabel = Factory.createTitleLabel("Contact Information");
        mAddressTextArea = Factory.createTextArea(4, 20);
        mAddressTextArea.setMinimumSize(mAddressTextArea.getPreferredSize());

        // Create panel to hold the input fields
        JPanel inputPanel = Factory.createPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(mAddressTextArea);
        inputPanel.add(new JLabel("Email:"));
        
        JPanel emailHolder = Factory.createPanel();
        emailHolder.setLayout(new GridBagLayout());
        inputPanel.add(emailHolder);
        emailHolder.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        mEmailTextField =Factory.createTextField(20);
        emailHolder.add(mEmailTextField);
        inputPanel.add(new JLabel("Phone:"));
        
        
        
        JPanel phoneHolder = new JPanel();
        inputPanel.add(phoneHolder);
        phoneHolder.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        mPhoneTextField = Factory.createTextField(20);
        phoneHolder.add(mPhoneTextField);
        
        inputPanel.add(new JLabel("Website:"));
        JPanel websiteHolderJPanel = Factory.createPanel();
        mWebsiteTextField = Factory.createTextField(20);
        websiteHolderJPanel.add(mWebsiteTextField);
        inputPanel.add(websiteHolderJPanel);

        // Create panel to hold the title and input panel
        JPanel contentPanel = Factory.createPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(titleLabel, BorderLayout.NORTH);
        contentPanel.add(inputPanel, BorderLayout.CENTER);

        // Create panel to hold the content and next button
        JPanel mainPanel = Factory.createPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Add the main panel to the ContactPanel
        add(mainPanel, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        mainPanel.add(panel, BorderLayout.SOUTH);
        
        JButton prevButton = Factory.createButton("Previous");
        prevButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				previous();
			}
		});
        panel.add(prevButton);
        
        JButton nextButton = Factory.createButton("Next");
        nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				next();
			}
		});
        panel.add(nextButton);
    }

    @Override
    public void next() {
        mInputGuide.next();
    }

    @Override
    public void previous() {
        mInputGuide.previous();
    }
    
    @Override
    public void updateData() {
    	InformationManager.address = mAddressTextArea.getText();
    	InformationManager.phone = mPhoneTextField.getText();
    	InformationManager.email = mEmailTextField.getText();
    	InformationManager.website = mWebsiteTextField.getText();
    }
}
