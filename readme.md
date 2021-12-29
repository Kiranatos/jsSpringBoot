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