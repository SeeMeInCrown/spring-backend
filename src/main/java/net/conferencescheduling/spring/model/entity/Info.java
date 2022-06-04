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
@Table(name="info")
public class Info {
    @Id
    //@SequenceGenerator(name="seq_gen",sequenceName = "seq_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "day_no")
    private int dayNo;

    @Column(name = "day_start")
    private String dayStart;

    @Column(name = "day_end")
    private String dayEnd;

    @Column(name = "session_count")
    private int sessionCount;

    @Column(name = "session_duration")
    private int sessionDuration;


}
