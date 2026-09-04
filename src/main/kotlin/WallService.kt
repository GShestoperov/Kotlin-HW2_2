import java.util.Arrays.copyOf

object WallService {

    private var posts = emptyArray<Post>()
    private var lastPostId: Long = -1

    private fun copyPostAttachments(attachmentsFrom: Array<Attachment>): Array<Attachment> {
        val newAttachments = attachmentsFrom.copyOf()
        for ((index, data) in attachmentsFrom.withIndex()) {
            newAttachments[index] = data.copy() as Attachment
        }

        return newAttachments
    }

    public fun add(post: Post): Post {
        lastPostId++
        posts += post.copy(
            id = lastPostId,
            likes = post.likes.copy(),
            attachments = copyPostAttachments(post.attachments)
        )

        return posts.last()
    }

    public fun update(post: Post): Boolean {
        for ((index, data) in posts.withIndex()) {
            if (data.id == post.id) {
                posts[index] = post.copy(
                    likes = post.likes.copy(),
                    attachments = copyPostAttachments(post.attachments)
                )
                return true
            }
        }

        return false
    }

    public fun clear() {
        posts = emptyArray<Post>()
        lastPostId = -1
    }
}