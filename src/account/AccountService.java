package account;

import java.util.List;

public interface AccountService {

    String deposit(Account account);  //입금
    String withdraw(Account account);  //출금
    String getBalance(String accountNumber); //잔고확인



}
