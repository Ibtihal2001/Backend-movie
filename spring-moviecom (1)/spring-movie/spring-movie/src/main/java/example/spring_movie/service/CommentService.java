public interface CommentService {
    List<Comment> getCommentsByMovieId(Long movieId);

    Comment addComment(Comment comment);

    // Autres méthodes CRUD
}
