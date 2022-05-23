package nexturn.assesment;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

@jakarta.persistence.Entity
public class Bill {
	
	@Id
	  @Column(name = "billId", length = 100)

	private String billId;
	private double billAmount;
	private String billCurrency;
	
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public String getBillCurrency() {
		return billCurrency;
	}
	public void setBillCurrency(String billCurrency) {
		this.billCurrency = billCurrency;
	}
	public Bill(String billId, double billAmount, String billCurrency) {
		super();
		this.billId = billId;
		this.billAmount = billAmount;
		this.billCurrency = billCurrency;
	}
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
       
}
