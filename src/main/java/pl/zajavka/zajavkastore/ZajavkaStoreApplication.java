package pl.zajavka.zajavkastore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.zajavka.zajavkastore.business.*;
import pl.zajavka.zajavkastore.infrastructure.configuration.ApplicationConfiguration;

public class ZajavkaStoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        SomeService someService = context.getBean(SomeService.class);
        NamedQueryService namedQueryService = context.getBean(NamedQueryService.class);
        //        someService.call();
        
        //zapytania NamedQuery
//        namedQueryService.call();
//        namedQueryService.call2();
        
        //zapytanie @Query - można pisać updaty
//        someService.call2();
//        someService.call3();
//        someService.call4();
        
        //delete opinion
//        someService.call5();
        
//        someService.call4();
//        someService.call6();
    
        //queryByExample
//        QueryByExampleService queryByExampleService = context.getBean(QueryByExampleService.class);
//        queryByExampleService.queryByExample3();

//        //podanie swoich ustawień eager/lazy
//        EntityGraphService entityGraphService = context.getBean(EntityGraphService.class);
//        entityGraphService.call();
    
/*        SortingService sortingService = context.getBean(SortingService.class);
        sortingService.callSorted();*/
        
        PaginationService paginationService = context.getBean(PaginationService.class);
        paginationService.callPaginate();
        
        
    }
}
