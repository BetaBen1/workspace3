package com.betaben.collegeapp;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FamilyMemberPanel extends JPanel {
	
	public static int familyMemberYPos = 0;
	
	public FamilyMemberPanel(String firstName, String lastName, String age, String gpa) {
		setBorder(new LineBorder(Color.black));
		
		setBounds(0, familyMemberYPos, 150, 92);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{73, 0};
		gridBagLayout.rowHeights = new int[]{16, 16, 23, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblFirstname = new JLabel(firstName);
		GridBagConstraints gbc_lblFirstname = new GridBagConstraints();
		gbc_lblFirstname.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblFirstname.insets = new Insets(0, 0, 5, 0);
		gbc_lblFirstname.gridx = 0;
		gbc_lblFirstname.gridy = 0;
		add(lblFirstname, gbc_lblFirstname);
		
		JLabel lblLastName = new JLabel(lastName);
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 0);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 1;
		add(lblLastName, gbc_lblLastName);
		
		JLabel lblGpa = new JLabel(gpa);
		GridBagConstraints gbc_lblGpa = new GridBagConstraints();
		gbc_lblGpa.insets = new Insets(0, 0, 5, 0);
		gbc_lblGpa.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblGpa.gridx = 0;
		gbc_lblGpa.gridy = 2;
		add(lblGpa, gbc_lblGpa);
		
		JLabel lblAge = new JLabel(age);
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 3;
		add(lblAge, gbc_lblAge);
	}
}
