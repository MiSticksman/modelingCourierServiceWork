package vsu.shaforostov.modelingcourierservicework.entity;


import jakarta.persistence.*;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer branchId;

    @ManyToOne()
    @JoinColumn(name = "branch_id")
    private Bid bid;

}
