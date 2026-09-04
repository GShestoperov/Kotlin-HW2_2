import java.time.LocalDateTime

data class Post(
    val id: Long,
    val ownerId: Long,
    val fromId: Long,
    val date: LocalDateTime = LocalDateTime.now(),
    val text: String = "",
    val likes: Likes = Likes(),
    val replyPostId: Long? = null,
    val viewsCount: Long = 0,
    val postType: PostType = PostType.POST,
    val attachments: Array<Attachment> = emptyArray<Attachment>(),
    val signerId: Long? = null,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isFavorite: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (fromId != other.fromId) return false
        if (replyPostId != other.replyPostId) return false
        if (viewsCount != other.viewsCount) return false
        if (signerId != other.signerId) return false
        if (canDelete != other.canDelete) return false
        if (canEdit != other.canEdit) return false
        if (isFavorite != other.isFavorite) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (likes != other.likes) return false
        if (postType != other.postType) return false
        if (!attachments.contentEquals(other.attachments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + ownerId.hashCode()
        result = 31 * result + fromId.hashCode()
        result = 31 * result + (replyPostId?.hashCode() ?: 0)
        result = 31 * result + viewsCount.hashCode()
        result = 31 * result + (signerId?.hashCode() ?: 0)
        result = 31 * result + canDelete.hashCode()
        result = 31 * result + canEdit.hashCode()
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + likes.hashCode()
        result = 31 * result + postType.hashCode()
        result = 31 * result + attachments.contentHashCode()
        return result
    }

}

enum class PostType {
    POST, COPY, REPLY
}

data class Likes(
    val count: Long = 0,
    val userLikes: Boolean = false,
    val canLikes: Boolean = true,
    val canPublish: Boolean = true
)