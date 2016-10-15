package org.server;

import java.util.Scanner;

import org.server.rmi.RMIHelper;

public class Main {
	public static void main(String[] args){
		Scanner myScanner=new Scanner(System.in);

		RMIHelper.getinstance().buildConnection();
		int n=myScanner.nextInt();
		RMIHelper.getinstance().releaseConnection();

	}
}
