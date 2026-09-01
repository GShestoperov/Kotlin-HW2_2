import java.time.LocalDateTime

data class Post(
    val id: Long,
    val ownerId: Long,
    val fromId: Long,
    val date: LocalDateTime = LocalDateTime.now(),
    val text: String = "",
    val likes: Likes = Likes(),
    val replyPostId: Long = -1,
    val viewsCount: Long = 0,
    val postType: PostType = PostType.POST,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isFavorite: Boolean = false
)

enum class PostType {
    POST, COPY, REPLY
}

data class Likes(
    val count: Long = 0,
    val userLikes: Boolean = false,
    val canLikes: Boolean = true,
    val canPublish: Boolean = true
)