package net.conferencescheduling.spring.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="session")
public class Session {

    @Id
    //@SequenceGenerator(name="session_seq_gen",sequenceName = "session_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "session_start_time", columnDefinition = "TIME")
    private LocalTime sessionStartTime;

    @Column(name = "session_end_time", columnDefinition = "TIME")
    private LocalTime sessionEndTime;

    @Column(name = "session_duration", columnDefinition = "TIME")
    private LocalTime sessionDuration;

    @Column(name = "session_count")
    private int sessionCount;

    @Column(name = "parallel_session_count")
    private int parallelSessionCount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "const_id")
    Constraint constraint;

    public void assignConstraint(Constraint constraint) {
        this.constraint=constraint;
    }

}
