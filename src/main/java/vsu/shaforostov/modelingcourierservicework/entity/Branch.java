package vsu.shaforostov.modelingcourierservicework.entity;


import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer branchId;

    private String name;

    public Branch(Integer id, String name) {
        this.branchId = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "from")
    private List<Navigator> navigators_from;

    @OneToMany(mappedBy = "to")
    private List<Navigator> navigators_to;

}
