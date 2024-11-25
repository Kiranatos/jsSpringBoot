package net.kiranatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Аплікація на Java, яка піддіймає веб-сервер!
Запускається через Shift+F6, для F6 треба настроїти main class in project properties.
Преднастройок і установок робити не треба.
TomcatWebServer стартує на порту 8080.
Так як сервер не відправляє ніяку інформацію, то в браузері за посиланням http://localhost:8080/
буде відображатись стандартна Whitelabel Error Page */

@SpringBootApplication
public class Applications {
    public static void main(String[] args) {
        System.out.println(" <<<RUN Applications class>>> ");
        SpringApplication.run(Applications.class, new String[]{" [args-данні, які передаються від класса Applications до InitiateUtils] "});
    }
}

/*
SELECT * FROM FRUIT_TABLE ;

Task 1: Дореалізовать приклади (Demonstration 2-4, 8-14) в jsBootDemo201QueryMethodsBiDir ті, які вже є в jsBootDemo200QueryMethods
    https://sysout.ru/spring-data-jpa-zaprosy-generiruemye-po-imeni-metoda/

Task 2: В FruitRepository є коммент про PagingAndSortingRepository. Я не знаю, як те працює, тому потрібно буде дослідити PagingAndSortingRepository докладніше пізніше.

Task 3: В Demonstration #14 падала помилка при видаленні елементів з БД. Рішення: поставити анотацію @Transactional на методи сервісу, щоб зробити їх транзикційними.
        Потрібно розібратись і дослідити це глибше.

Task 4: Розібратись, погратись з можливими повертаємими значаннями в методах репозиторіїв більш глибше.

Task 5: Search plugins for NetBeans, eclipse, vscode ide for repository requests methods.

Task 6: In FruitRepository in the end, there are comments for other possible demonstrations, that waiting to be implemented.

Task 50: проекти jsBootDemo200QueryMethods, jsBootDemo201QueryMethodsBiDir і jsBootDemo300JavaRushSpringNotScare можуть мати спільні Task, що перетинаються.


********************************************************************************
********************************************************************************
********************************************************************************

                    Класи в яких реалізовані демонстрації і на які звернуть увагу:
Demonstration #0 methods that exist in repository from the beginning
    jsBootDemo200QueryMethods [FruitService]
    jsBootDemo201QueryMethodsBiDir []
Demonstration #1 - [ find…By, read…By, get…By, query…By, search…By, stream…By ]
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir [AccountRepository, AccountService, UserRepository, UserService, InitiateUtils] <- stream return
Demonstration #2 - returned type
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir []
Demonstration #3 - findFirst
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir []
Demonstration #4
    jsBootDemo201QueryMethodsBiDir [AccountRepository, AccountService, UserRepository, UserService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir []
Demonstration #5
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir [AccountRepository, AccountService, UserRepository, UserService, InitiateUtils]
Demonstration #6
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir [AccountRepository, AccountService, UserRepository, UserService, InitiateUtils]
Demonstration #7 - AND
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir [AccountRepository, AccountService, UserRepository, UserService, InitiateUtils]
Demonstration #8 - OR
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir []
Demonstration #9 - Iterable
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir []
Demonstration #10 - Pagination
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir []
Demonstration #11 - orderBy sort
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir []
Demonstration #12 - class Sort
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir []
Demonstration #13 - count
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir []
Demonstration #14 - remove/delete
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir []

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