package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dueDate;  //data de vencimento
	private Double amount; //valor da parcela
	
	//construtor
	public Installment(Date dueDate, Double amount) {
		super();
		this.dueDate = dueDate;
		this.amount = amount;
	}

	//getters e setters
	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	//method
	@Override
	public String toString() {
		return sdf.format(dueDate) + " - " + String.format("%.2f",amount);
	}
	
	
	
}
