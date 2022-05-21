package net.conferencescheduling.spring.model.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

//    @JsonBackReference
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "paper_author",
//            joinColumns = @JoinColumn(name = "paper_id"),
//            inverseJoinColumns = @JoinColumn(name = "author_id"))
//    private List<Author> authors= new ArrayList<>();
//
//    @JsonBackReference
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "paper_keyword",
//            joinColumns = @JoinColumn(name = "paper_id"),
//            inverseJoinColumns = @JoinColumn(name = "keyword_id"))
//    private List<Keyword> keywords= new ArrayList<>();
//
//    @JsonBackReference
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "presenter_id", referencedColumnName = "id")
//    Presenter presenter;

//    @JsonBackReference
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "const_id", referencedColumnName = "id")
//    Constraint constraint;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "presenter")
    private String presenter;

    @Column(name = "keyword")
    private String keyword;



//    public void assignAuthor(Author author) {
//        authors.add(author);
//    }
//
//    public void assignKeyword(Keyword keyword) {
//        keywords.add(keyword);
//    }
//
//    public void assignPresenter(Presenter presenter) {
//        this.presenter=presenter;
//    }
}
