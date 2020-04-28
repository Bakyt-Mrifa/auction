package kg.mrifa.auction.models.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="statuses")
@NoArgsConstructor
@RequiredArgsConstructor
public class Status {

    @Id
    @GeneratedValue
    @Column(name = "status_id")
    private Long id;
    @NonNull
    private String name;
}
