package com.cts.creditcard.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cts.creditcard.dao.CreditCardDao;
import com.cts.creditcard.exception.CreditCardAdminSystemException;
import com.cts.creditcard.util.ApplicationUtil;
import com.cts.creditcard.vo.CreditCard;


public class CreditCardAdminService {
	public static List<CreditCard>buildMasterCreditCardList(List<String> records){
		List<CreditCard> l=new ArrayList<>();
		for(String s:records) {
			String s1[]=s.split(",");
			long id=Long.parseLong(s1[0]);
			String name=s1[1];
			String mail=s1[2];
			long phone=Long.parseLong(s1[3]);
			double amount=Double.parseDouble(s1[4]);
			Date dueDate=ApplicationUtil.convertStringToDate(s1[5]);
			Date paidDate=null;
			if(s1.length==7)
			{
				paidDate=ApplicationUtil.convertStringToDate(s1[6]);
				if(dueDate.compareTo(paidDate)<0)
					amount=getBillAmountWithLatePaymentCharges(amount);
			}
			CreditCard c=new CreditCard(id,name,mail,phone,amount,dueDate,paidDate);
			l.add(c);
			System.out.println(id+""+name+""+amount);
			
		}
		return l;
	}
	public static Double getBillAmountWithLatePaymentCharges(Double billAmount) {
		return billAmount+500;
	}
	public Boolean addCreditCardDetails(String inputFeed) throws
	CreditCardAdminSystemException{
		List<CreditCard> cd=buildMasterCreditCardList(ApplicationUtil.readFile("inputFeed.txt"));
		CreditCardDao obj1=new CreditCardDao();
		try {
			if(obj1.addCreditCardDetails(cd))
				return true;
		}catch(NullPointerException e1)
		{
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
