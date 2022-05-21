//package net.conferencescheduling.spring.model.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Entity
//@Table(name="keyword")
//public class Keyword {
//
//    @Id
//    @Column(name = "id")
//    //@SequenceGenerator(name="room_seq_gen",sequenceName = "room_gen",initialValue = 100,allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")
//    private Long id;
//
//    @Column(name = "keyword")
//    private String keyword;
//
//    @JsonManagedReference
//    @JsonIgnore
//    @ManyToMany(mappedBy = "keywords",cascade = CascadeType.ALL)
//    private List<Paper> papers= new ArrayList<>();
//
//
//}
