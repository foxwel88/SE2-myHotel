package org.server;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.server.mySQL.DatabaseCommunicator;
import org.server.rmi.RMIHelper;


import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class test extends JFrame {

	private JPanel contentPane;
	
	JButton stopbutton;
	
	JButton startbutton;
	
	private JButton btnStartstub;
	
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 82);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		
		startbutton = new JButton("Start");
		stopbutton = new JButton("Stop");
		btnStartstub = new JButton("StartStub");
		stopbutton.setEnabled(false);
		startbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RMIHelper.getinstance().buildConnection();
				DatabaseCommunicator.databaseInit();
				stopbutton.setEnabled(true);
				startbutton.setEnabled(false);
				btnStartstub.setEnabled(false);
			}
		});
		
		
		
		
		stopbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RMIHelper.getinstance().releaseConnection();
				startbutton.setEnabled(true);
				btnStartstub.setEnabled(true);
				stopbutton.setEnabled(false);
			}
		});
		
		btnStartstub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RMIHelper.getinstance().buildStubConnection();;
				startbutton.setEnabled(false);
				stopbutton.setEnabled(true);
				btnStartstub.setEnabled(false);
				
			}
		});
		
		
		
		
		btnStartstub.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		startbutton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		stopbutton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		
		contentPane.add(btnStartstub);
		contentPane.add(stopbutton);
		contentPane.add(startbutton);
		setVisible(true);
	}

}
