package org.server;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.server.rmi.RMIHelper;
import org.server.rmi.RMIHelper;


import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class test extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton;
	JButton btnNewButton_1;
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 81);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton_1 = new JButton("Start");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RMIHelper.getinstance().buildConnection();
				btnNewButton.setEnabled(true);
				btnNewButton_1.setEnabled(false);
			}
		});
		contentPane.add(btnNewButton_1);
		
		btnNewButton = new JButton("Stop");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RMIHelper.getinstance().releaseConnection();
				btnNewButton_1.setEnabled(true);
				btnNewButton.setEnabled(false);
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(btnNewButton);
		setVisible(true);
	}

}
