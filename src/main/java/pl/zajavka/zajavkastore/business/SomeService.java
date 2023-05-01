package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.zajavkastore.infrastructure.database.entity.Stars;
import pl.zajavka.zajavkastore.infrastructure.database.jparepositories.*;

import java.util.Set;

@Service
@AllArgsConstructor
public class SomeService {

    private final CustomerDatabaseRepository customerDatabaseRepository;
    private final OpinionDatabaseRepository opinionDatabaseRepository;
    private final ProducerDatabaseRepository producerDatabaseRepository;
    private final ProductDatabaseRepository productDatabaseRepository;
    private final PurchaseDatabaseRepository purchaseDatabaseRepository;

    public void call() {
        System.out.println("#Customer: " + customerDatabaseRepository.findById(52));
        System.out.println("#Opinion: " + opinionDatabaseRepository.findById(13));
        System.out.println("#Producer: " + producerDatabaseRepository.findById(2));
        System.out.println("#Product: " + productDatabaseRepository.findById(22));
        System.out.println("#Purchase: " + purchaseDatabaseRepository.findById(117));
    }
    public void call2(){
        System.out.println(opinionDatabaseRepository.findByCustomerEmail("afirsby7@skype.com"));
    }
    @Transactional
    public void call3(){

        System.out.println(opinionDatabaseRepository.countWrongOpinions());
        //używając ORDINAL w entity, trzeba pamiętać że jest on mapowany od zera więc Stars.THREE = 2
        opinionDatabaseRepository.updateWrongOpinions(Stars.FOUR, Set.of(Stars.THREE));
        
        System.out.println(opinionDatabaseRepository.countWrongOpinions());
    }
    public void call4(){
        System.out.println(opinionDatabaseRepository.countOpinions());
    }
    @Transactional
    public void call5(){
        opinionDatabaseRepository.deleteOpinionsContaining("rhv");
    }
    public void call6(){
        System.out.println(opinionDatabaseRepository.countMsxStars());
    }
    
}
