package net.kiranatos.entities;

import jakarta.persistence.*;
//import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "feedback_table")
public class FeedbackEntity {

    @Id
    @Column(name = "id_feedback")    
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;

    @Column(name = "feedback_text")
    private String feedbackText;

    @Column(name = "nickname")
    private String nickname;

    public FeedbackEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "FeedbackEntity{" + "id=" + id + ", feedbackText=" + feedbackText + ", nickname=" + nickname + '}';
    }   
}
