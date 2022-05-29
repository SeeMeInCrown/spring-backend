package net.conferencescheduling.spring.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="presentation")
public class Presentation {
    @Id
    @Column(name = "id")
    //@SequenceGenerator(name="presenter_seq_gen",sequenceName = "presenter_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")
    private Long id;

    @Column(name = "day_no")
    private int dayNo;

    @Column(name = "session_no")
    private int sessionNo;

    @Column(name = "title")
    private String title;

    @Column(name = "authors")
    private String authors;

    @Column(name = "presenter")
    private String presenter;

    @Column(name = "start_time")
    private String start_time;

    @Column(name = "end_time")
    private String end_time;

    @Column(name = "keywords")
    private String keywords;

    //@JsonBackReference
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "paper_id", referencedColumnName = "id")
//    Paper paper;

}
