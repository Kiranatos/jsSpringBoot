package net.kiranatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Applications {
    public static void main(String[] args) {        
        SpringApplication.run(Applications.class);
    }
}

/*
SELECT * FROM BANK_ACC ; 
SELECT * FROM BANK_USER ;

    Цей проект створенний на основі частини проекту jsBootDemo120EntityRelationship, 
а саме bidirectional many-to-one relationship.

Tasks:
A)      Це і завдання розібратись в майбутньому глибше + опис проблеми і моїх дій. Так як в статті 
            Spring Data JPA: запросы, генерируемые по имени метода / https://sysout.ru/spring-data-jpa-zaprosy-generiruemye-po-imeni-metoda/
    використовувались private Set<Account> accounts; замість List, всюди поставив Set.
    Через це падала помилка org.hibernate.LazyInitializationException. Після гугління знайшлося рішення:
    Проблема в жадності коллекцій, треба поставити fetch в классі User:
            @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
        Шляхом моїх подальших Set-List жонглювань, я вирахував, що помилка виникає в {1} (класи AccountService та InitiateUtils),
    при List працює нормально, а при Set падає, якщо не поставить fetch в классі User.
        Коллекції Set та List в {2} (класи User, UserService та InitiateUtils) можна міняти вільно,
    вони не падали з помилкою і не потребували fetch.
        Базову копію цього проекту з назвою jsBootDemo201QueryMethodsBiDirBase збережу в хSANDBOX на випадок моъх майбутніх досліджень по цьому питанню.
    
B)  Task to make bug output in class UserRepository, Demonstration #1B.

C)  Прочитати і законспектувати статью, якщо є що цікаве:
    NonUniqueResultException и NoResultException
    https://sysout.ru/nonuniqueresultexception-i-noresultexception/

D)  Прочитати і законспектувати статьї, якщо є що цікаве:    
    Supported Query Return Types
    https://docs.spring.io/spring-data/jpa/reference/repositories/query-return-types-reference.html
    Якщо посилання знову зміняться, то загуглити їх, або подібні їм через їх назви.
    Вивчити і розібрати ключові слова для побудови методів в репозиторіях та можливі повертаємі типи на прикладах.
    
********************************************************************************
********************************************************************************
********************************************************************************

    Статья "Repository query keywords. Supported query method subject keywords."
    https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html

    The following table lists the subject keywords generally supported by the 
Spring Data repository query derivation mechanism to express the predicate. 
Consult the store-specific documentation for the exact list of supported keywords, 
because some keywords listed here might not be supported in a particular store.

        Table 1. Query subject keywords.
[ Keywords ] - Description.

[ find…By, read…By, get…By, query…By, search…By, stream…By ] - 
General query method returning typically the repository type, a Collection 
or Streamable subtype or a result wrapper such as Page, GeoResults or any other 
store-specific result wrapper. Can be used as findBy…, findMyDomainTypeBy… or in 
combination with additional keywords.

[ exists…By ] - Exists projection, returning typically a boolean result.

[ count…By ] - Count projection returning a numeric result.

[ delete…By, remove…By ] - Delete query method returning either no result (void) 
or the delete count.

[ …First<number>…, …Top<number>… ] - Limit the query results to the first 
<number> of results. This keyword can occur in any place of the subject between 
find (and the other keywords) and by.

[ …Distinct… ] - Use a distinct query to return only unique results. Consult the 
store-specific documentation whether that feature is supported. This keyword can 
occur in any place of the subject between find (and the other keywords) and by.

    Supported query method predicate keywords and modifiers.

    The following table lists the predicate keywords generally supported by the 
Spring Data repository query derivation mechanism. However, consult the 
store-specific documentation for the exact list of supported keywords, because 
some keywords listed here might not be supported in a particular store.

    Table 2. Query predicate keywords 
Logical keyword                 Keyword expressions
AND                             And
OR                              Or
AFTER                           After, IsAfter
BEFORE                          Before, IsBefore
CONTAINING                      Containing, IsContaining, Contains
BETWEEN                         Between, IsBetween
ENDING_WITH                     EndingWith, IsEndingWith, EndsWith
EXISTS                          Exists
FALSE                           False, IsFalse
GREATER_THAN                    GreaterThan, IsGreaterThan
GREATER_THAN_EQUALS             GreaterThanEqual, IsGreaterThanEqual
IN                              In, IsIn
IS                              Is, Equals, (or no keyword)
IS_EMPTY                        IsEmpty, Empty
IS_NOT_EMPTY                    IsNotEmpty, NotEmpty
IS_NOT_NULL                     NotNull, IsNotNull
IS_NULL                         Null, IsNull
LESS_THAN                       LessThan, IsLessThan
LESS_THAN_EQUAL                 LessThanEqual, IsLessThanEqual
LIKE                            Like, IsLike
NEAR                            Near, IsNear
NOT                             Not, IsNot
NOT_IN                          NotIn, IsNotIn
NOT_LIKE                        NotLike, IsNotLike
REGEX                           Regex, MatchesRegex, Matches
STARTING_WITH                   StartingWith, IsStartingWith, StartsWith
TRUE                            True, IsTrue
WITHIN                          Within, IsWithin

    In addition to filter predicates, the following list of modifiers is supported:

    Table 3. Query predicate modifier keywords 
        Keyword                                 Description
[ IgnoreCase, IgnoringCase ] -          Used with a predicate keyword for case-insensitive comparison.
[ AllIgnoreCase, AllIgnoringCase ] -    Ignore case for all suitable properties. Used somewhere in the query method predicate.
[ OrderBy… ] -                          Specify a static sorting order followed by the property path and direction (e. g. OrderByFirstnameAscLastnameDesc).

*/