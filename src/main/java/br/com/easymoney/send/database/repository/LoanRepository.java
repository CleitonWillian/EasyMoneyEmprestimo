package br.com.easymoney.send.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easymoney.send.database.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, String> {

}
