package pl.zajavka.zajavkastore.infrastructure.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = "opinionId")
@ToString(of = {"opinionId", "stars", "comment", "dateTime"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "opinion")
public class OpinionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "opinion_id", unique = true, nullable = false)
    private Integer opinionId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private PurchaseEntity purchaseEntity;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "stars")
    private Stars stars;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date_time")
    private ZonedDateTime dateTime;
}
