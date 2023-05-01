package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;
import pl.zajavka.zajavkastore.infrastructure.database.jparepositories.CustomerDatabaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class NamedQueryService {
        private final CustomerDatabaseRepository customerDatabaseRepository;
        
        public void call(){
                List<CustomerEntity> allCustomers = customerDatabaseRepository.findAllCustomers();
                System.out.println("All "+ allCustomers);
                
                CustomerEntity customerEntity = customerDatabaseRepository.findCustomerByEmail("aohearn4@behance.net");
                System.out.println("email"+customerEntity);
        }
        public void call2(){
                List<CustomerEntity> allCustomers = customerDatabaseRepository.findAllCustomersNNQ();
                System.out.println("All "+ allCustomers);
                
                CustomerEntity customerEntity = customerDatabaseRepository.findCustomerByEmailNNQ("aohearn4@behance.net");
                System.out.println("email"+customerEntity);
        }





}
