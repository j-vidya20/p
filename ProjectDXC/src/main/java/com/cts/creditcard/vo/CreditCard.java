package com.cts.creditcard.vo;
import java.util.Date;

public class CreditCard {
	public long creditCardNum;
	public String customerName;
	public String customerEmail;
	public long customerPhone;
	public double billAmount;
	public Date dueDate;
	public Date paymentDate;
	public CreditCard(long creditCardNum,String customerName,String customerEmail,long customerPhone,double billAmount,Date dueDate,Date paymentDate) {
		super();
		this.creditCardNum=creditCardNum;
		this.customerName=customerName;
		this.customerEmail=customerEmail;
		this.customerPhone=customerPhone;
		this.billAmount=billAmount;
		this.dueDate=dueDate;
		this.paymentDate=paymentDate;
		
		
		
	}
	

}
