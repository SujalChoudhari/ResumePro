package com.sujal.resumepro.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Factory {

	// Theme variables
	public static final Color PRIMARY_COLOR = new Color(41, 128, 185);
	public static final Color SECONDARY_COLOR = new Color(236, 240, 241);
	public static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 24);
	public static final Font SUBTITLE_FONT = new Font("Arial", Font.PLAIN, 16);
	public static final Font NOTMAL_FONT = new Font("Arial", Font.PLAIN, 14);

	public static JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(SECONDARY_COLOR);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add some padding
		return panel;
	}

	public static JLabel createTitleLabel(String text) {
		JLabel label = new JLabel(text);
		label.setFont(TITLE_FONT);
		return label;
	}

	public static JLabel createSubtitleLabel(String text) {
		JLabel label = new JLabel(text);
		label.setFont(SUBTITLE_FONT);
		return label;
	}

	public static JTextField createTextField(int columns) {
		JTextField textField = new JTextField(columns);
		textField.setMargin(new Insets(5, 5, 5, 5));
		textField.setFont(NOTMAL_FONT);
		return textField;

	}

	public static JTextArea createTextArea(int rows, int columns) {
		JTextArea textField = new JTextArea(rows, columns);
		textField.setMargin(new Insets(5, 5, 5, 5));
		textField.setFont(NOTMAL_FONT);
		return textField;

	}

	public static JButton createButton(String text) {
		JButton button = new JButton(text);
		button.setBackground(PRIMARY_COLOR);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		return button;
	}

	// You can add more static methods here for creating other components

}
