package pl.zajavka.zajavkastore.infrastructure.database.jparepositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDatabaseRepository extends JpaRepository<CustomerEntity,Integer> {

        List<CustomerEntity> findByNameAndSurname(String name, String surname);
        List<CustomerEntity> findByNameOrEmail(String name, String email);
        List<CustomerEntity> findByNameAndEmail(String name, String email);
        CustomerEntity findByEmail(String email);
       CustomerEntity findDistinctByEmail(String email);
        
        Optional<CustomerEntity> findByCustomerId(Integer integer);
        
        //zapytania HQL w springData definiowane w CustomerEntity
        List<CustomerEntity> findAllCustomers();
        CustomerEntity findCustomerByEmail(String email);
        //zapytania NNQ w springData definiowane w CustomerEntity
        List<CustomerEntity> findAllCustomersNNQ();
        CustomerEntity findCustomerByEmailNNQ(String email);
        
        @EntityGraph(
                type= EntityGraph.EntityGraphType.FETCH,
            attributePaths = {
                        "purchaseEntities",
                     "purchaseEntities.opinionEntity"
            }
        )
        List<CustomerEntity> findAllByEmailContaining(String s);
}
