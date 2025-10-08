package com.elearning.elearning.entity;



import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.List;

// NOTE: You must have Lombok dependency in your pom.xml for this class to compile
// or manually provide all Getters/Setters/NoArgsConstructor.
// Assuming Lombok is used for brevity:
// import lombok.Getter;
// import lombok.Setter;
// import lombok.NoArgsConstructor;
// @Getter @Setter @NoArgsConstructor

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ElementCollection
    @CollectionTable(name = "course_syllabus",
            joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "topic")
    private List<String> syllabus;

    private String imageUrl;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<String> getSyllabus() { return syllabus; }
    public void setSyllabus(List<String> syllabus) { this.syllabus = syllabus; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
