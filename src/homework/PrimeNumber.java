package homework;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class PrimeNumber extends JFrame {
	private static final int WIDTH = 235;
	private static final int HEIGHT = 115;
	private JTextField aBox;
	private JTextField bBox;
	private JTextField rBox;

	public PrimeNumber() {
		setTitle("Prime Number");
		setSize(WIDTH, HEIGHT);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createContents();
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void createContents() {

		JPanel Panel = new JPanel(new GridBagLayout());
		JLabel aLabel = new JLabel("A:");
		JLabel bLabel = new JLabel("B:");
		JLabel rLabel = new JLabel("Result:");

		aBox = new JTextField(4);

		bBox = new JTextField(4);

		rBox = new JTextField(6);
		rBox.setEditable(false);

		JButton minBtn = new JButton("Min");
		minBtn.setBackground(Color.red);
		minBtn.setForeground(Color.white);

		JButton maxBtn = new JButton("Max");
		maxBtn.setBackground(Color.green);
		maxBtn.setForeground(Color.white);

		JButton primes = new JButton("Primes");
		primes.setBackground(Color.darkGray);
		primes.setForeground(Color.white);

		GridBagConstraints c = new GridBagConstraints();
		getContentPane().setBackground(Color.cyan);
		Panel.setBackground(Color.cyan);

		Panel.add(aLabel);
		Panel.add(aBox);

		Panel.add(bLabel);
		Panel.add(bBox);

		c.gridx = 1;
		c.gridy = 2;
		Panel.add(minBtn, c);
		c.gridx = 3;
		c.gridy = 2;
		Panel.add(maxBtn, c);
		c.gridx = 4;
		c.gridy = 0;
		Panel.add(primes, c);
		add(Panel);
		c.gridx = 4;
		c.gridy = 3;
		Panel.add(rLabel, c);
		c.gridx = 4;
		c.gridy = 2;
		Panel.add(rBox, c);

		Listener listener = new Listener();

		aBox.addActionListener(listener);
		bBox.addActionListener(listener);

		minBtn.addActionListener(listener);
		maxBtn.addActionListener(listener);
		primes.addActionListener(listener);

	}

	private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LinkedList<String> primes = new LinkedList<>();
			int aVal;
			int bVal;
			String res = "";
			int i = 0;
			int num = 0;
			try {
				aVal = Integer.parseInt(aBox.getText());
			} catch (NumberFormatException nfe) {
				aVal = -1;
			}

			try {
				bVal = Integer.parseInt(bBox.getText());
			} catch (NumberFormatException nfe) {
				bVal = -1;
			}
			if (bBox.getText().equals(aBox.getText())) {
				if (e.getActionCommand() != null)
					JOptionPane.showMessageDialog(null,
							"Performed Values " + aBox.getText() + " & " + bBox.getText() + " are equal.");
			} else if (e.getActionCommand() != null) {
				if (aVal < 0) {
					rBox.setText("Undefined");
					// JOptionPane.showMessageDialog(null, "Undefined");
				} else if (e.getActionCommand() != null) {
					if (bVal < 0) {
						rBox.setText("Undefined");
						// JOptionPane.showMessageDialog(null, "Undefined");
					} else if (aVal < bVal) {
						for (i = aVal; i <= bVal; i++) {
							int count = 0;
							for (num = i; num >= 1; num--) {
								if (i % num == 0) {
									count = count + 1;
								}
							}
							if (count == 2) {
								// Appended the Prime number to the String
								primes.add(Integer.toString(i));

								if (e.getActionCommand().equals("Primes"))
									JOptionPane.showMessageDialog(null, "Primes: " + (res = res + i + " "));
								else if (e.getActionCommand().equals("Min"))
									rBox.setText(primes.getFirst());
								else
									rBox.setText(primes.getLast());
								//Created by Joshgun 12/17/16 7:05
							}

						}

					}
				}

			}

		}
	}
}
