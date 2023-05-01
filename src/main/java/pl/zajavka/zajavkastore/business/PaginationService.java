package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;
import pl.zajavka.zajavkastore.infrastructure.database.jparepositories.CustomerDatabaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PaginationService {
        private final CustomerDatabaseRepository customerDatabaseRepository;
        
        public void callPaginate(){
                paginate(0,10);
                paginate(1,10);
                paginate(2,10);
                paginate(12,10);
        }
        
        public void paginate(int pageNr, int pageSize){
                System.out.printf("## PAGINATION NR: %s, size: %s #%n",pageNr,pageSize);
        
                Sort sort = Sort.by("name").ascending()
                                    .and(Sort.by("dateOfBirth").ascending());
                
                Pageable pageable = PageRequest.of(pageNr, pageSize,sort);
                Page<CustomerEntity> page = customerDatabaseRepository.findAll(pageable);
                List<CustomerEntity> content = page.getContent();
                
                if(content.isEmpty()){
                        System.out.println("##Empty");
                }
        
                System.out.println("getTotalElements: "+page.getTotalElements());
                System.out.println("getTotalPages: "+page.getTotalPages());
                System.out.println("getNumberOfElements: "+page.getNumberOfElements());
                System.out.println("getSize: "+page.getSize());
                System.out.println("isLast: "+page.isLast());
                System.out.println("isFirst: "+page.isFirst());
                
                
                
        }
                
      
       
}
