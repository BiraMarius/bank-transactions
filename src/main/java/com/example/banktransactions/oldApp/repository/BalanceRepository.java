package com.example.banktransactions.oldApp.repository;

import com.example.banktransactions.oldApp.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
/*
    @Query(nativeQuery = true,
            value = "SELECT accountId, amount, currency FROM balance " +
            "WHERE accountId= :accountId " +
            "AND amount= :amount " +
            "AND currency= :currency")
    public Balance getBalancebyParams(@Param("accountId") Long accountId,
                                      @Param("amount") BigDecimal amount,
                                      @Param("currency") String currency);

    public Balance getBalanceByAccount_AccountIdAndAmountAndCurrency(@Param("accountId") Long accountId,
                                                                     @Param("amount") BigDecimal amount,
                                                                     @Param("currency") String currency);
*/

            //@Select("SELECT account_id, amount, currency FROM balances WHERE account_id=#{accountId} AND currency=#{currency}::valid_currencies")
    //    @Results(value = {
    //            @Result(property = "accountId", column = "account_id"),
    //            @Result(property = "amount", column = "amount"),
    //            @Result(property = "currency", column = "currency"),
    //    })
    //    Balance getBalance(Long accountId, Currency currency);

//@Query(nativeQuery = true, value = "SELECT * FROM Student ORDER BY age")
//Optional<Student> findSortedStudentByAge();

//"SELECT e FROM Employee e WHERE e.empNumber = :number" , Employee.class);


    //@Query("select u from User u where u.firstname = :#{#customer.firstname}")
    //List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);
}
