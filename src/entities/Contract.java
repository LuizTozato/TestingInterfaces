package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	Integer number;
	Date date;
	Double value;
	
	List <Installment> installments = new ArrayList<>(); //lista de parcelas
	
	//construtor
	public Contract(Integer number, Date date, Double value) {
		this.number = number;
		this.date = date;
		this.value = value;
	}
	
	//getters e setters
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	public List<Installment> getInstallments() {
		return installments;
	}

	//methods
	public void addInstallment(Installment installment) {
		installments.add(installment);
	}
	
	public void removeInstallment(Installment installment) {
		installments.remove(installment);
	}	
	
}
