package org.server;

import java.util.Scanner;

import org.server.mySQL.DatabaseCommunicator;
import org.server.timer.UpdateOrderTimer;

public class Main {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		test myframe = new test();
		DatabaseCommunicator.databaseInit();
		
		UpdateOrderTimer updateOrderTimer = new UpdateOrderTimer();
		updateOrderTimer.startTimer();
	}
}
