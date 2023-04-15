package vsu.shaforostov.modelingcourierservicework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column
    private Integer navigatorId;


    @ManyToOne()
    @JoinColumn(name = "from_branch_id")
    @JsonIgnore
    private Branch from;

    @ManyToOne()
    @JoinColumn(name = "to_branch_id")
    @JsonIgnore
    private Branch to;

    @Column
    private Integer timeFromTo;


    @OneToOne(mappedBy = "navigator")
    @JsonIgnore
    private Bid bid;


}
