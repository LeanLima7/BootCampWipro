package br.com.gama.wipro.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_special_account")
public class SpecialAccount extends Account {

	private Double overdraftLimit;
	
	public SpecialAccount() {
	}
	
	public SpecialAccount(Integer number, Double balance, CreditCard creditCard) {
		super(number, balance, creditCard);
		
		overdraftLimit = balance * 1.5;
	}

	public Double getOverdraftLimit() {
		return this.overdraftLimit;
	}

	@Override
	public void withdraw(Double value) {
		if ((overdraftLimit+ balance) >= value) {
			super.withdraw(value);
		}
	}
}