package net.conferencescheduling.spring.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="constraintt")
public class Constraint {

    @Id
    //@SequenceGenerator(name="constraint_seq_gen",sequenceName = "constraint_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "paper_count")
    private int paperCount;

    @Column(name = "break_count")
    private int breakCount;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private LocalDate endDate;

    @Column(name = "break_time", columnDefinition = "TIME")
    private LocalTime breakTime;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "constraint",cascade = CascadeType.ALL)
    private Set<Paper> papers = new HashSet<>();

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "constraint",cascade = CascadeType.ALL)
    private Set<Room> rooms = new HashSet<>();

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "constraint",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Session> sessions = new HashSet<>();


}
