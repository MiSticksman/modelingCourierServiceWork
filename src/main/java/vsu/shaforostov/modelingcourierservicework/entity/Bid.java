package vsu.shaforostov.modelingcourierservicework.entity;

import jakarta.persistence.*;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bidId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "navigator_id")
    private Navigator navigator;

    private Integer urgency; // срочность

    public Bid(Navigator nav, Integer urgency) {
        this.navigator = nav;
        this.urgency = urgency;
    }

    @ManyToOne()
    @JoinColumn(name = "courier_id")
    private Courier courier;


}
