package net.conferencescheduling.spring.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="constraintt")
public class Constraint {
    @Id
    //@SequenceGenerator(name="seq_gen",sequenceName = "seq_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "day_no")
    private int dayNo;

    @Column(name = "parallel_session_count")
    private int parallelSessionCount;

    @Column(name = "presentation_duration")
    private int presentationDuration;

    @Column(name = "session_duration")
    private int sessionDuration;

    @Column(name = "session_no")
    private int sessionNo;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;


//    @JsonManagedReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "constraint",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Paper> papers= new ArrayList<>();


}
