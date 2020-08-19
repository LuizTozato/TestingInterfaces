package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	//construtor
	/*veja que ao criar um processamento de contrato, eu apenas preciso
	  fornecer o serviço de pagamento online, que é a interface genérica
	  Quem irá implementá-la será a classe do Paypal mas eu poderia
	  colocar qualquer outro tipo de serviço de cobrança e reconectar
	  aqui. Assim, fica fácil a manutenção. 
	 */
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	//metodo para processar o pedido e não retornar nada
	public void processContract(Contract contract, int months) {
		//pega o valor do contrato e divide no número meses
		double parcelaBasica = contract.getValue() / months; //200
	for (int i=1; i<=months; i++) {	
		double parcelaUmPorcento = parcelaBasica * (0.01 * i + 1); //202
		double parcelaDoisPorcento = parcelaUmPorcento * 1.02; //206.04
		//data
		Date dataFinal = adicionarMes(contract.getDate(), i);
		//parcela	
		Installment parcelaFinal = new Installment(dataFinal, parcelaDoisPorcento);
		contract.getInstallments().add(parcelaFinal);
	}
	
	}
	
	private Date adicionarMes(Date dataInicial, int mesesParaSomar) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataInicial);
		cal.add(Calendar.MONTH, mesesParaSomar);
		return cal.getTime();
	}
	
	
	
	
	
}
