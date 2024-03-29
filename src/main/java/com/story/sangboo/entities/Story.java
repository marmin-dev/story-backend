package com.story.sangboo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private String songName;

    @Column(nullable = false)
    private String artist;

    @Column(nullable = false)
    private String uri;

    private String emotion;

    @Column(columnDefinition = "TEXT")
    private String content;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_user_like",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")

    )
    private List<User> likedUser;

    @OneToMany(mappedBy = "story",cascade = CascadeType.ALL)
    private List<Comment> comment;
}
