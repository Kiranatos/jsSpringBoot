# jsSpringBoot

- Інформацію по аннотаціям винесено в AnnotationsVocabulary.docx. Тому додаткову інформацію читати там !!!
- Додаткова інформація по базах даних в jsJDBC/ifiles/SQL.xlsx
- Конспект по Lombok виніс в окремий проект без Спрінга: jsLombokWithoutSpring.

01. jsBootDemo01Application
    Просто аплікація на Java, яка піддіймає веб-сервер!
02. jsBootDemo02
    Те що й в 01-м + приклад entity, repository, service, application.yml, application.properties та підключення H2 БД+
    Без Ломбока.
    Повторювати класи в наступному порядку: Applications > InitiateUtils > FruitRepository > FruitService > FruitEntity > application.yml > application.properties > pom.xml
    Task: В pom.xml закоментовані декілька залежностей. Потрібно їх дослідити докладніше та можливо законспектувати деінде.
03. jsBootDemo03QueryMethods
    Spring Data JPA надає можливість генерувати SQL-запити автоматично на основі іменованих методів у репозиторіях. Цей підхід називається "запити, генеровані по імені методу" (Query Methods)

05. jsBootDemo05JavaRushSpringNotScare 
    Приклад з джавараш. Спочатку повтори проекти: jsBootDemo01Application, jsBootDemo02, jsLombokWithoutSpring так як основна інформація винесена і законспектована в ті проекти.
    Це тільки приклад з викрутасами, тому можна і пропустити. Однак оставив, тому-що не знаю, що з ним робити.
    Task: в классі FruitService є exist(Example<? extends FruitEntity> example), розібрать, що за Example і пригадати "?"
    Task: @GenericGenerator та @GeneratedValue приклади в Entity классах, можливо варто зробити окремий проект, де розписати докладно, як з ними працювати або записати все в AnnotationsVocabulary.docx.

jsBootDemo98MinExample - мінімальна копія jsBootDemo02 для різних експерементів

8. Hibernate
9. jsSpringBoot99 (Thymeleaf + Mustache + Freemaker)
    
FAILS:
03. jsBootDemo03JPAQueriesByNameMethods (Spring Data JPA: запросы, генерируемые по имени метода)
    Приклад з https://sysout.ru/spring-data-jpa-zaprosy-generiruemye-po-imeni-metoda/
    ( Завдання:
        - не запустився, продивитись і взнати, де тут була моя помилка пізніше
        - навчитись ініціалізувати бд з файлу data.sql)




SoftServe Spring Tasks:
1) @Component == @Service == @Repository == @Controller - Одинаковые и служат только для логики developer-a(напр в MVC). - розписать логику => jsSpringDemo02xmlAnnotations Language.java
S12:
  [опрацювати посилання в infoS12.txt]
    spring-ioc-m7-s12-team-2-5, SpringIocXML, SpringIocAnnotation:
        - check JUnit tests
        - pom -> mvn summary repo
        - readme.md -> mvn summary repo
        V Spring переглянутий -> nothing new there    
S13:
  [опрацювати посилання в infoS13.txt]
    hibernate-1-m7-s13-team-2-6
        - check JUnit tests
        - pom -> mvn summary repo
        - readme.md -> mvn summary repo
            - extends JpaRepository<Role, Long>
            - implements CommandLineRunner / @Override    public void run(String... args)
            - public static void main(String[] args) {  SpringApplication.run(ToDoListApplication.class, args);   }
            - data.sql / application.properties(H2) / html files
S14:
  [опрацювати посилання в infoS14.txt]
    hibernate_2-m7-s14-team-2-7
        - same as above
    S14Demo01SpringBootCommandLineRunner
        V Spring переглянутий -> nothing do here -> all info summarized into jsBootDemo02
    S14Demo02ProjectNotWorking
        - extends CrudRepository<Author, Integer>
        - не працююча CommandLineRunner. Пропрацювати, коли прочитаю и вивчу проект вище
    S14Demo03SpringJavaRush
        V Spring переглянутий -> nothing do here -> all info summarized into jsBootDemo02 
 

Як і навіщо заінжектити бін(впровадити залежність)?
Які є способи "інжекта", скільки їх, який краще, який гірший і чому?



Sources of Breviary (теория из sources, которая незаконспектированна в данном коде): 
################################################################################ 
YouTube channel:  alishev
https://www.youtube.com/channel/UCK5d3n3kfkzlArMccS0TTXA
https://www.udemy.com/javarussia/?couponCode=ADVANCED_JAVARUSSIA 
alishev.neil@gmail.com
https://github.com/NeilAlishev/SpringCourse
***
Бин - похоже на объект. Бины создает Спринг из переданных ему классов.

################################################################################ 
Spring Framework - The Basics
https://www.youtube.com/playlist?list=PL6jg6AGdCNaWF-sUH2QDudBRXo54zuN1t
YouTube channel: Онлайн уроки по Java
https://www.youtube.com/channel/UCdXqgQdGW5go6nkkBbUVSMA
teacher: Yuriy Tkach
***
Dependency Injection (Inversion of Control) - Objects get their dependencies and do not create them.
AOP (Aspect Oriented Programming) - Separation of cross-cutting concerns into separate modules.
***
Modules of Spring:
1) Core container: Beans, Core, Context, Expression
    Beans and Core managing beans and realize DI
    Contex управляет контекстом, где хранятся бины и обеспечивает доступ к ним
    Expression - специальный язык виражений, который может использоваться для поиска и модификации графа бинов во время выполнения программы.
2) AOP: AOP and Aspects(поддержка библиотеки AspectJ)
3) Instrumentation - необходим, когда используем Spring в сервере приложений(Tomcat, WildFly), обеспечивает загрузку классов в контейнер и позволяет управлять контекстом и бинами.
4) Data access and integration: JDBC, JMS, ORM, Transaction, JPA
5) Web & Remoting: Web, Servlet, Struts - компоненты для роботы с web-приложениями. Базовые вещи, например - загрузка файла на сервер, паттерн MVC, web-сервисы, безопасность, интеграция с др. web-технологиями 
6) Testing
***
Главные Dependencies <artifactId>spring-context and <artifactId>spring-context-support, которые подтянут все остальные модули. Зависимость spring-tx для поддержки транзакций.
***
bean scope or lifecycle of the objects in the container
***
Классы по которым создаем бины нечего не знают про Спринг. 
Реализация Aware Interfaces позволяет узнать в каком контексте находится класс, имя бина, ссылка на контекст, сервлет-контекст веб-приложения.
Это нужно редко, например в коде тестирования.
Aware Interfaces:
public class Aaa implements ApplicationContextAware {
    public void setApplicationContext(ApplicationContext ctx){...}
}
- ApplicationContextAware
- ApplicationEventPublisherAware
- BeanFactoryAware
- BeanNameAware
- ResourceLoaderAware
- ServletContextAware
- ...
***
[утилитарная функция] Реагировать на события контекста such as creation, completion, updating
Container Events:
public class Monitor implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent event){...}
}
- ContextStartedEvent
- ContextStoppedEvent
- ContextRefreshedEvent
- ContextClosedEvent
***

################################################################################



https://spring.io/guides/gs/serving-web-content/

JSP-замена.
1) Apache FreeMarker
    artifactId: spring-boot-starter-freemarker (расскомментровать в pom.xml и метод homePageMethod/закомментировать 2-3 иначе может падать проект)
    *.ftl(old version) / *.ftlh
    https://freemarker.apache.org/docs/index.html
    FreemakerController
2) Mustache
    artifactId: spring-boot-starter-mustache (расскомментровать в pom.xml и метод homePageMethod/закомментировать 1,3 иначе может падать проект)
    *.mustache
    MustacheController
    http://mustache.github.io/mustache.5.html
3) Thymeleaf
    artifactId: spring-boot-starter-thymeleaf (расскомментровать в pom.xml и метод homePageMethod/закомментировать 1-2 иначе может падать проект)
    *.html
    ThymeleafController
4) velocity????

***************************
@GetMapping vs @RequestMapping

@GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET). @GetMapping is the newer annotaion. It supports consumes
Consume options are :
consumes = "text/plain"
consumes = {"text/plain", "application/*"}
For Further details see: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html
or read: https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/request-mapping-variants.html
RequestMapping supports consumes as well
GetMapping we can apply only on method level and RequestMapping annotation we can apply on class level and as well as on method level
***************************
Sources:
GrabDuck! - Spring на практике - Знакомство с Spring Boot
https://www.youtube.com/watch?v=BV4EQnz-KG4&list=PLaWfw53gNyzaDTEmrlCCj1jjqr6770Nnp&index=2
letsCode - Spring Boot: делаем простое веб приложение на Java (простой сайт)
https://www.youtube.com/watch?v=jH17YkBTpI4&list=PLU2ftbIeotGoGSEUf54LQH-DgiQPF2XRO&index=3
https://gist.github.com/drucoder/6b9e912701e7c2f9c1e99a229c0eb22e
https://github.com/drucoder/sweater/tree/mvc-web
***************************
links to work:
https://hellokoding.com/spring-boot-hello-world-example-with-freemarker/
https://spring.io/guides/gs/serving-web-content/
https://github.com/spring-guides/gs-serving-web-content
https://spring.io/guides#getting-started-guides
***************************



TASK TO CHECK FOR FUTURE:
***************************
делал GrabDuck!, я не делал этого:
IDEA: Edit Configuration > Spring Boot > Name | Main Class | Enable Debug Output | Program Arguments
я в нетбинсе только менял в Project Properties > Run > Main Class когда переименовывал класс.
***************************
в Program Arguments можно задать те же свойства, что и в application.properties только с 2-я минусами:
--server.port=8090
Program Arguments имеет больший приоритет чем application.properties.
***************************
mvn spring-boot:run должен запустить все и без манифеста <- мне это нужно проверить
***************************