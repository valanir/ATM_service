package app.service;

import app.model.Transaction;
import app.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TransactionService extends GeneralService<Transaction>{
  private final TransactionRepository transactionRepository;
}
