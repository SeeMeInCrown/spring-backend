package net.conferencescheduling.spring.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="room")
public class Room {

    @Id
    @Column(name = "id")
    //@SequenceGenerator(name="room_seq_gen",sequenceName = "room_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")
    private Long id;

    @Column(name = "room_no")
    private int roomNo;

    @Column(name = "room_count")
    private int roomCount;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "const_id")
    Constraint constraint;

    public void assignConstraint(Constraint constraint) {
        this.constraint=constraint;
    }

}
