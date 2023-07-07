package com.sujal.resumepro.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sujal.resumepro.controller.InputGuide;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ExperiencePanel extends JPanel implements DataPanel {

	InputGuide mInputGuide;
	private JTextField textField;
	private JTextField inputFromTextField;
	private JTextField inputToTextField;
	private JTextField textField_3;

	public ExperiencePanel(InputGuide inputGuide) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 450, 0 };
		gridBagLayout.rowHeights = new int[] { 300, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel mainPanel = new JPanel();
		GridBagConstraints gbc_rootPanel = new GridBagConstraints();
		gbc_rootPanel.fill = GridBagConstraints.BOTH;
		gbc_rootPanel.gridx = 0;
		gbc_rootPanel.gridy = 0;
		add(mainPanel, gbc_rootPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel titlePanel = new JPanel();
		mainPanel.add(titlePanel);

		JLabel lblNewLabel = Factory.createTitleLabel("Experience");
		titlePanel.add(lblNewLabel);

		JPanel dataPanel = new JPanel();
		mainPanel.add(dataPanel);
		dataPanel.setLayout(new GridLayout(0, 2, 3, 10));

		JLabel instituteLabel = Factory.createLabel("Institute");
		dataPanel.add(instituteLabel);

		textField = Factory.createTextField(20);
		textField.setColumns(20);
		dataPanel.add(textField);

		JLabel inputFromLabel = Factory.createLabel("From");
		dataPanel.add(inputFromLabel);

		inputFromTextField = Factory.createTextField(7);
		inputFromTextField.setColumns(10);
		dataPanel.add(inputFromTextField);

		JLabel inputToLabel = Factory.createLabel("To");
		dataPanel.add(inputToLabel);

		inputToTextField = Factory.createTextField(7);
		inputToTextField.setColumns(10);
		dataPanel.add(inputToTextField);

		JLabel lblNewLabel_2_1 = Factory.createLabel("Designation");
		dataPanel.add(lblNewLabel_2_1);

		textField_3 = Factory.createTextField(30);
		textField_3.setColumns(10);
		dataPanel.add(textField_3);
		mInputGuide = inputGuide;

		JPanel panel = new JPanel();
		mainPanel.add(panel, BorderLayout.SOUTH);

		JButton prevButton = Factory.createButton("Previous");
		prevButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				previous();
			}
		});
		panel.add(prevButton);

		JButton addButton = Factory.createButton("Add New Exprience");
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mInputGuide.addNewAt(mInputGuide.getCurrentIndex() + 1, new ExperiencePanel(mInputGuide));
				next();
			}
		});
		panel.add(addButton);

		JButton nextButton = Factory.createButton("Next");
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
