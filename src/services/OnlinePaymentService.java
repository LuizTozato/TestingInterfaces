package services;

public interface OnlinePaymentService {
	
	//s�o dois m�todos que ser�o definidos por outra classe
	double paymentFee(double amount);
	double interest(double amount,int months);
	
}
