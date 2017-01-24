package com.betaben.animalactivity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class Animal {

	public abstract String say();
	
	private int x;
	private int y;
	
	private String animalName;
	
	public JButton button = new JButton();
	public Animal(int x, int y){
		this.x = x;
		this.y = y;
		button.setBounds(x, y, 100, 100);
		button.setText(getAnimalName());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Main.display.setText(say());
			}
		});
		button.setVisible(true);
	}

	public void Animate(int x, int y){
		int xCounter = 0;
		int yCounter = 0;
		
		while(true){
			if(x<xCounter){
				this.x ++;
				xCounter ++;
			}
			if(y<yCounter){
				this.y ++;
				yCounter ++;
			}
		}
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}
	
}
