package net.conferencescheduling.spring.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="presentation")
public class Presentation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paper_id", nullable = false)
    Paper paper;

    @OneToOne
    @JoinColumn(name = "constraintt_id", nullable = false)
    Constraint constraint;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    Room room;

    private int keyword;

}
