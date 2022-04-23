package br.com.gama.wipro.entities;

import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_current_account")
public class CurrentAccount extends Account {

	public CurrentAccount() {
	}

	public CurrentAccount(Integer number, Double balance, CreditCard creditCard) {
		super(number, balance, creditCard);
	}

	@Override
	public void withdraw(Double value) {
		if (value <= this.balance) {
			super.withdraw(value);
		}
	}

	@Override
	public String toString() {
		return "\n\tConta Corrente"+ 
			   "\n\n\tNúmero da conta: " + number + 
		       "\n\tSaldo: " + balance + 
		       "\n\tCartão de crédito: "+ creditCard +
	           "\n";
	}
}