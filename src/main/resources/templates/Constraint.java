//package net.conferencescheduling.spring.model.entity;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import lombok.*;
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.*;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name="constraintt")
//public class Constraint {
//
//    @Id
//    //@SequenceGenerator(name="constraint_seq_gen",sequenceName = "constraint_gen",initialValue = 100,allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "paper_count")
//    private int paperCount;
//
//    @Column(name = "break_count")
//    private int breakCount;
//
//    @Column(name = "room_count")
//    private int roomCount;
//
//    @Column(name = "conference_date", columnDefinition = "DATE")
//    private LocalDate conferenceDate;
//
////    @Column(name = "end_date", columnDefinition = "DATE")
////    private LocalDate endDate;
//
//    @Column(name = "break_time", columnDefinition = "TIME")
//    private LocalTime breakTime;
//
//    @Column(name = "presentationTime", columnDefinition = "TIME")
//    private LocalTime presentationTime;
//
////    @JsonManagedReference
////    @JsonIgnore
////    @OneToMany(mappedBy = "constraint",cascade = CascadeType.ALL)
////    private List<Paper> papers= new ArrayList<>();
//
//    @JsonManagedReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "constraint",cascade = CascadeType.ALL)
//    private List<Keyword> keywords= new ArrayList<>() ;
//
//    @JsonManagedReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "constraint",cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Session> sessions = new ArrayList<>();
//
//
//    @OneToMany(cascade = CascadeType.ALL,mappedBy="constraint")
//    @JoinColumn(name = "paper_id")
//    private List<Paper> papers = new ArrayList<>();
//
//}
