package net.conferencescheduling.spring.model.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="constraintt")
public class Constraint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_count")
    private int roomCount;

    @Column(name = "paper_count")
    private int paperCount;

    @Column(name = "duration")
    private int duration;

}
