package org.client.bldriver;

import java.util.ArrayList;
import java.util.Date;

import org.client.blstub.Comment_stub;
import org.client.vo.CommentVO;

public class Commentblservice_driver {
	
	public static void main(String[] args){
		Comment_stub stub = new Comment_stub();
		
		ArrayList<CommentVO> vo=stub.getComment("GodHotel");
		for (int i=0;i<vo.size();i++)
		{
	    	System.out.println(vo.get(i).comment);
	    }
		
		System.out.println(stub.addComment(new CommentVO("me", "you", new Date(), 110, "Too Bad!")));		
	}
}
