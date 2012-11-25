package com.mtk.calculator;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Container;

/**
 * Create the UI and also performs the event handling and operations of calculations.
 * @author <a href="http://www.mdtareque.in" target="_blank">mtk</a>
 * @version 1.0 Nov 25, 2012
 */
public class Calculator implements ActionListener {

	JFrame guiFrame;
	JPanel buttonPanel;
	JTextField numberCalc;
	int calcOperation = 0;
	int currentCalc;

	/**
	 * Consturct a new Calculator Frame. Sets a default
	 * <code>EXIT_ON_CLOSE</code> option. Positions the <code>JFrame</code> in
	 * the middle of the screen Also fills the UI with required components.
	 */
	public Calculator() {
		guiFrame = new JFrame();

		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Simple Calculator");
		guiFrame.setSize(300, 300);

		guiFrame.setLocationRelativeTo(null);

		numberCalc = new JTextField();
		numberCalc.setHorizontalAlignment(JTextField.RIGHT);
		numberCalc.setEditable(false);

		guiFrame.add(numberCalc, BorderLayout.NORTH);

		buttonPanel = new JPanel();

		buttonPanel.setLayout(new GridLayout(5, 3));
		guiFrame.add(buttonPanel, BorderLayout.CENTER);

		// Add the number buttons
		for (int i = 1; i < 10; i++) {
			addButton(buttonPanel, String.valueOf(i));
		}
		addButton(buttonPanel, " ");
		addButton(buttonPanel, "0");
		addButton(buttonPanel, " ");

		JButton addButton = new JButton("+");
		addButton.setActionCommand("+");

		OperatorAction subAction = new OperatorAction(1);
		addButton.addActionListener(subAction);

		JButton subButton = new JButton("-");
		subButton.setActionCommand("-");

		OperatorAction addAction = new OperatorAction(2);
		subButton.addActionListener(addAction);

		JButton equalsButton = new JButton("=");
		equalsButton.setActionCommand("=");
		equalsButton.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent event) {
				if (!numberCalc.getText().isEmpty()) {
					int number = Integer.parseInt(numberCalc.getText());
					if (calcOperation == 1) {
						int calculate = currentCalc + number;
						numberCalc.setText(Integer.toString(calculate));
					} else if (calcOperation == 2) {
						int calculate = currentCalc - number;
						numberCalc.setText(Integer.toString(calculate));
					}
				}
			}
		});

		buttonPanel.add(addButton);
		buttonPanel.add(subButton);
		buttonPanel.add(equalsButton);
		guiFrame.setVisible(true);
	}

	/**
	 * @param parent
	 *            the main container of the component to be added
	 * @param name
	 *            name of the <code>JButton</code> that is to be added
	 */
	private void addButton(Container parent, String name) {
		JButton but = new JButton(name);
		but.setActionCommand(name);
		but.addActionListener(this);
		parent.add(but);
	}

	/* (non-Javadoc)
	 * As all the buttons are doing the same thing it's easier to make the class
	 * implement the <code>ActionListener</code> interface and control the
	 * button clicks from one place
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();
		numberCalc.setText(action);
	}

	/**
	 * @author mtk
	 *
	 */
	private class OperatorAction implements ActionListener {
		private int operator;

		/**
		 * @param operation
		 */
		public OperatorAction(int operation) {
			operator = operation;
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent event) {
			currentCalc = Integer.parseInt(numberCalc.getText());
			calcOperation = operator;
		}
	}
}