package vsu.shaforostov.modelingcourierservicework.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import vsu.shaforostov.modelingcourierservicework.entity.Bid;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "couriers")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer courierId;
    @Column
    private String name;

    @OneToMany(mappedBy = "courier")
    @JsonIgnore
    private List<Bid> bids;
}
