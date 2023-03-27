package vsu.shaforostov.modelingcourierservicework.entity;

import jakarta.persistence.*;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "navigators")
public class Navigator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer navigatorId;


    @ManyToOne()
    @JoinColumn(name = "from_branch_id")
    private Branch from;

    @ManyToOne()
    @JoinColumn(name = "to_branch_id")
    private Branch to;

    private Integer timeFromTo;


    @OneToOne(mappedBy = "navigator")
    private Bid bid;


}
