package pl.zajavka.zajavkastore.infrastructure.database.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.zajavkastore.infrastructure.database.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductDatabaseRepository extends JpaRepository<ProductEntity,Integer> {
        List<ProductEntity> findByProductNameLike(String name);
        List<ProductEntity> findByProductNameContaining(String name);
        List<ProductEntity> findByProductPriceGreaterThan(BigDecimal price);
        List<ProductEntity> findByProductPriceBetween(BigDecimal price1, BigDecimal price2);
}
