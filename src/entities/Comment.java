package entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Comment {
    private final String commentId;
    private final String message;
    private final String author;
    private final int likeCount;
    private final LocalDate commentCreationDate;
    private final ArrayList<Comment> replyIds;


    public Comment(String commentId, String message, String author, int likeCount, LocalDate commentCreationDate, ArrayList<Comment> replyIds) {
        this.commentId = commentId;
        this.message = message;
        this.author = author;
        this.likeCount = likeCount;
        this.commentCreationDate = commentCreationDate;
        this.replyIds = replyIds;
    }
}
