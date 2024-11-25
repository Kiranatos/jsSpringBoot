package net.kiranatos.repositories;


import java.util.List;
import java.util.Optional;
import net.kiranatos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findFirstByName(String userName);
    
    /* ============= Demonstration #1 [ find…By, read…By, get…By, query…By, search…By, stream…By ] ============= */    
    List<User> streamByName(String name);
    
    /* ============= Demonstration #4 ============= */
    /* Звернення до полів вкладеної сутності.
    В запиті можна врахувати не тільки поля самого User, а й accounts. Наприклад,
    наступний запит шукає всіх користувачів, які мають у назві одного з рахунків заданий рядок: */
    List<User> findDistinctUserByAccounts_NameContaining(String str);
    /* Сюди ж метод 
        List<Account> findDistinctAccountByUser_NameContaining(String str); в класі AccountRepository
    
        Знак підкреслення "_" перед Name в даному випадку можна не писати, він необхідний для сенсового 
    змісту (відділення назви батьківських полів від полів вкладеної сутності).
    Зверніть увагу, що ми використали також ключове слово Distinct, тому що join
    може сформувати дублікати. А повторювані User у списку нам не потрібні.
        
    Task: придумати приклад про ці дублікати, щоб виводились і зрозуміти як вони працюють, якщо прибрати це слово Distinct. 
        Оскільки схоже, що структура БД в цьому проекті не дає змоги подивитись наглядно, як буде працювати з дублікатами. */
    
    /* ============= Demonstration #5 ============= */
    List<User> findByNameIsStartingWith(String partOfUserName);   
    List<User> findByNameStartingWith(String partOfUserName);
    List<User> findByNameStartsWith(String partOfUserName);
    List<User> findDistinctByNameStartsWith(String partOfUserName);
    List<User> findDistinctEntitiesByNameStartsWith(String partOfUserName);
    
    List<User> findByAccounts_NameIsStartingWith(String partOfAccountName);
    List<User> findDistinctUByAccounts_NameIsStartingWith(String partOfAccountName);
    
    /* ============= Demonstration #6 ============= */
    List<User> findByYearsIsGreaterThan(Integer n);    
    
    List<User>  findByAccounts_AmountIsGreaterThan(long n);
    List<User>  findDistinctByAccounts_AmountIsGreaterThan(long n);
    List<User>  findWORDDistinctWORDByAccounts_AmountIsGreaterThan(long n);
    /*  WORD - будь-яке слово, частіще просто вказується назва сутності, тут наприклад можна написати WORD=User=Users
        find... Distinct ... By... IsGreaterThan - зарезервовані слова
        Accounts - поле accounts в класі User
        Amount - відповідно поле amount в класі Account  */    
    
    /* ============= Demonstration #7 AND ============= */
    List<User> findDistinctByNameStartsWithAndYearsIsGreaterThan(String firstLetterOfName, int years);
    List<User> findDistinctByNameAndAccounts_AmountIsGreaterThan(String name, long amount);
    
    
    
}
