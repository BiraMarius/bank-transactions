package com.example.banktransactions.repository;

import com.example.banktransactions.oldApp.entity.Account;
import com.example.banktransactions.oldApp.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    public void AccountRepository_SaveAll(){

        //Arrange
        Account account = Account.builder()
                .country("Japonia")
                .balances(null)
                .build();

        //Act
        Account savedAccount = accountRepository.save(account);

        //Assert
        //Assertions.assertThat(savedAccount).isNotNull();
        //Assertions.assertThat(savedAccount.getAccountId().isGreaterThan(0));



    }
}
