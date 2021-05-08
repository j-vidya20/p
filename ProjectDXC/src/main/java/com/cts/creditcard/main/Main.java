package com.cts.creditcard.main;
import java.io.IOException;
import java.sql.SQLException;

import com.cts.creditcard.exception.CreditCardAdminSystemException;
import com.cts.creditcard.service.CreditCardAdminService;


public class Main {
	public static void main(String args[])throws ClassNotFoundException,IOException,SQLException,CreditCardAdminSystemException {
		CreditCardAdminService obj=new CreditCardAdminService();
		if(obj.addCreditCardDetails("inputFeed.txt"))
			System.out.println("Elements addes succesfully");

		
	}

}
