import com.sun.java.accessibility.util.EventID

interface Attachment  {
    val type: String
    fun copy(): Any
}

class AudioAttachment(val audio: Audio): Attachment {
    override val type: String = "audio"
    override fun copy():Any = AudioAttachment(audio.copy())
}

data class Audio(
    val id: Long,
    val ownerId: Long,
    val artist: String,
    val title: String,
    val url: String
)

class VideoAttachment(val video: Video): Attachment {
    override val type: String = "video"
    override fun copy():Any = VideoAttachment(video.copy())
}

data class Video(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val description: String
)

class PhotoAttachment(val photo: Photo): Attachment {
    override val type: String = "photo"
    override fun copy():Any = PhotoAttachment(photo.copy())
}

data class Photo(
    val id: Long,
    val albumId: Long,
    val ownerId: Long,
    val text: String,
    val url: String
)

class LinkAttachment(val link: Link): Attachment {
    override val type: String = "link"
    override fun copy():Any = LinkAttachment(link.copy())
}

data class Link(
    val url: String,
    val title: String,
    val description: String
)

class DocumentAttachment(val document: Document): Attachment {
    override val type: String = "document"
    override fun copy():Any = DocumentAttachment(document.copy())
}

data class Document(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val ext: String,
    val url: String
)
