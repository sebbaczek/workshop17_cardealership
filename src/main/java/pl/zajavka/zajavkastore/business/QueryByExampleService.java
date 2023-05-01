package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;
import pl.zajavka.zajavkastore.infrastructure.database.jparepositories.CustomerDatabaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class QueryByExampleService {
        private final CustomerDatabaseRepository customerDatabaseRepository;
        
        public void queryByExample(){
                CustomerEntity example = CustomerEntity.builder().name("Florian").build();
                Example<CustomerEntity> entityExample = Example.of(example);
        
                List<CustomerEntity> all = customerDatabaseRepository.findAll(entityExample);
                System.out.println(all);
        }
        public void queryByExample2(){
                ExampleMatcher exampleMatcher= ExampleMatcher.matchingAll().withIgnoreCase();
                CustomerEntity example = CustomerEntity.builder().name("florian").build();
                Example<CustomerEntity> entityExample = Example.of(example, exampleMatcher);
        
                List<CustomerEntity> all = customerDatabaseRepository.findAll(entityExample);
                System.out.println(all);
        }
        public void queryByExample3(){
                ExampleMatcher exampleMatcher= ExampleMatcher.matchingAll()
                       .withMatcher("email",
                        ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                           .withMatcher("name",
                        ExampleMatcher.GenericPropertyMatchers.startsWith().ignoreCase());
                        
                CustomerEntity example = CustomerEntity.builder()
                                                 .email("com")
                                                 .name("g")
                                                 .build();
                Example<CustomerEntity> entityExample = Example.of(example, exampleMatcher);
        
                List<CustomerEntity> all = customerDatabaseRepository.findAll(entityExample);
                System.out.println(all);
        }
}
