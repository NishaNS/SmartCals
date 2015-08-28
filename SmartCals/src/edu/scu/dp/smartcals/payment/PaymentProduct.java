package edu.scu.dp.smartcals.payment;

public interface PaymentProduct {
	public boolean getPaymentStatus();
	public double getAmtToReturn();
	public double getAmtPayable();
	public void setValues(double amtPayable,double amtPaying);
}
