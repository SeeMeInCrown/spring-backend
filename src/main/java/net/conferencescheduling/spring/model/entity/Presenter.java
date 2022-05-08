package net.conferencescheduling.spring.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name="presenter")
public class Presenter {

    @Id
    @Column(name = "id")
    //@SequenceGenerator(name="presenter_seq_gen",sequenceName = "presenter_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @JsonIgnore
    @OneToMany(mappedBy = "presenter")
    private Set<Paper> papers = new HashSet<>();
}
