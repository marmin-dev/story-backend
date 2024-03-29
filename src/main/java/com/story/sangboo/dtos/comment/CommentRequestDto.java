package com.story.sangboo.dtos.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CommentRequestDto {

    public Long userId;

    public String content;

}
