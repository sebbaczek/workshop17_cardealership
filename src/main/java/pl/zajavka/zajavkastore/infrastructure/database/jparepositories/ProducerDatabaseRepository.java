package pl.zajavka.zajavkastore.infrastructure.database.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.zajavkastore.infrastructure.database.entity.ProducerEntity;

@Repository
public interface ProducerDatabaseRepository extends JpaRepository<ProducerEntity,Integer>  {

}
