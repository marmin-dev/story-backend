package com.story.sangboo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Story extends BaseTimeEntity{
    // 사연 정보 클래스

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

    @Column(nullable = false)
    private String song;

    private String emotion;

    @ManyToMany
    @JoinTable(
            name = "post_user_like",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> likedUser;

    @OneToMany(mappedBy = "story")
    private List<Comment> comment;
}