package net.conferencescheduling.spring.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
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

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "break_time")
    private int breakTime;

    @JsonIgnore
    @OneToMany(mappedBy = "constraint")
    private Set<Paper> papers = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private Set<Room> rooms = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "session")
    private Set<Session> sessions = new HashSet<>();


}
