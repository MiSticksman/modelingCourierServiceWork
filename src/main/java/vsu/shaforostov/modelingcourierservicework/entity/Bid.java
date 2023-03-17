package vsu.shaforostov.modelingcourierservicework.entity;

import jakarta.persistence.*;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bidId;

    @ManyToOne()
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @OneToMany(mappedBy = "bid")
    private List<Branch> branches;
}
