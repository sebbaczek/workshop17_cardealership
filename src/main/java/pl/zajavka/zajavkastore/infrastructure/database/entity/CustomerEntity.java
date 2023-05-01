package pl.zajavka.zajavkastore.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "customerId")
@ToString(of = {"customerId", "userName", "email"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
//zapytania HQL w springData
// nie można robić updatów
@NamedQueries({
                      @NamedQuery(
                              name = "CustomerEntity.findAllCustomers",
                             query = "FROM CustomerEntity"
                      ),
                      @NamedQuery(
                              name = "CustomerEntity.findCustomerByEmail",
                             query = "FROM CustomerEntity WHERE email = ?1"
                      )
})
//zapytania native SQL w springData
// nie można robić updatów
@NamedNativeQueries({
                      @NamedNativeQuery(
                              name = "CustomerEntity.findAllCustomersNNQ",
                             query = "SELECT * FROM customer",
                               resultClass = CustomerEntity.class
                      ),
                      @NamedNativeQuery(
                              name = "CustomerEntity.findCustomerByEmailNNQ",
                             query = "SELECT * FROM customer WHERE email = ?1",
                              resultClass = CustomerEntity.class
                      )
})

public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customer_id", unique = true, nullable = false)
    private Integer customerId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerEntity")
    private Set<PurchaseEntity> purchaseEntities;

}
