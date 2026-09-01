object WallService {

    private var posts = emptyArray<Post>()
    private var lastPostId: Long = -1

    public fun add(post: Post): Post {
        lastPostId++
        posts += post.copy(id = lastPostId, likes = post.likes.copy())
        return posts.last()
    }

    public fun update(post: Post): Boolean {
        for ((index, data) in posts.withIndex()) {
            if (data.id == post.id) {
                posts[index] = post.copy(likes = post.likes.copy())
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