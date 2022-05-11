package net.conferencescheduling.spring.model.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="paper")
public class Paper {

    @Id
    @Column(name = "id")
    //@SequenceGenerator(name="paper_seq_gen",sequenceName = "paper_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")
    private Long id;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "paper_author", joinColumns = @JoinColumn(name = "paper_id"),inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors=new HashSet<>();

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "const_id")
    Constraint constraint;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "presenter_id")
    Presenter presenter;

    @Column(name = "title")
    private String title;

    @Column(name = "keyword")
    private String keyword;


    public void assignAuthor(Author author) {
        authors.add(author);
    }

    public void assignConstraint(Constraint constraint) {
        this.constraint=constraint;
    }

    public void assignPresenter(Presenter presenter) {
        this.presenter=presenter;
    }
}
