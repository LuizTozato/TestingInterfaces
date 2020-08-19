package services;

public interface OnlinePaymentService {
	
	//são dois métodos que serão definidos por outra classe
	double paymentFee(double amount);
	double interest(double amount,int months);
	
}
