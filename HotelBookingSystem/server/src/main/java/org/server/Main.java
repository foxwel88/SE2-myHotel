package org.server;

import java.util.Scanner;

import mySQL.DatabaseCommunicator;

public class Main {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		test myframe = new test();
		DatabaseCommunicator.databaseInit();
	}
}
