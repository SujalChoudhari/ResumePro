package com.sujal.resumepro.ui;

import com.sujal.resumepro.controller.InputGuide;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactPanel extends JPanel implements Progressable {

    private InputGuide mInputGuide;
    private JTextField emailTextField;
    private JTextField phoneTextField;

    public ContactPanel(InputGuide inputGuide) {
        mInputGuide = inputGuide;
        setLayout(new BorderLayout());

        // Create components for the contact page
        JLabel titleLabel = Factory.createTitleLabel("Contact Information");
        JTextArea addressTextField = Factory.createTextArea(4, 20);
        addressTextField.setMinimumSize(addressTextField.getPreferredSize());

        // Create panel to hold the input fields
        JPanel inputPanel = Factory.createPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressTextField);
        inputPanel.add(new JLabel("Email:"));
        
        JPanel emailHolder = Factory.createPanel();
        emailHolder.setLayout(new GridBagLayout());
        inputPanel.add(emailHolder);
        emailHolder.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        emailTextField =Factory.createTextField(20);
        emailHolder.add(emailTextField);
        inputPanel.add(new JLabel("Phone:"));
        
        
        
        JPanel phoneHolder = new JPanel();
        inputPanel.add(phoneHolder);
        phoneHolder.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        phoneTextField = Factory.createTextField(20);
        phoneHolder.add(phoneTextField);
        
        inputPanel.add(new JLabel("Website:"));
        JPanel websiteHolderJPanel = Factory.createPanel();
        JTextField websiteField = Factory.createTextField(20);
        websiteHolderJPanel.add(websiteField);
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
}
