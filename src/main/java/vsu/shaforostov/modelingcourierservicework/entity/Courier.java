package vsu.shaforostov.modelingcourierservicework.entity;


import jakarta.persistence.*;
import lombok.*;
import vsu.shaforostov.modelingcourierservicework.entity.Bid;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courierId;

    @OneToMany(mappedBy = "courier")
    private List<Bid> bids;
}
