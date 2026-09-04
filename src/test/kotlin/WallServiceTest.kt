import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WallServiceTest {
    @Before
    fun setUp() {
        WallService.clear()
    }

    @Test
    fun add() {
        val post = Post(0, 0, 0)
        val result = WallService.add(post)
        assertEquals(post.copy(id = result.id),result)
    }

    @Test
    fun update_OK() {
        val post = Post(0, 0, 0)
        var new_result = WallService.add(post)
        new_result = new_result.copy(text = "Новый пост!")
        val result = WallService.update(new_result)
        assertEquals(result, true)
    }

    @Test
    fun update_Post_not_exists() {
        val post = Post(0, 0, 0)
        var new_result = WallService.add(post)
        new_result = new_result.copy(text = "Новый пост!", id = -1)
        val result = WallService.update(new_result)
        assertEquals(false, result)
    }

    @Test
    fun update_OK_AudioAttachments() {
        val post = Post(0, 0, 0)
        var new_result = WallService.add(post)
        new_result = new_result.copy(
            text = "Новый пост!",
            attachments = arrayOf(AudioAttachment(Audio(0, 0, "Scooter",
                "How much is the fish?", "site.com"))
            )
        )
        val result = WallService.update(new_result)
        assertEquals(result, true)
    }

    @Test
    fun update_OK_VideoAttachments() {
        val post = Post(0, 0, 0)
        var new_result = WallService.add(post)
        new_result = new_result.copy(
            text = "Новый пост!",
            attachments = arrayOf(VideoAttachment(Video(0, 0,
                "How much is the fish?", "По чем рыбка?"))
            )
        )
        val result = WallService.update(new_result)
        assertEquals(result, true)
    }

    @Test
    fun update_OK_PhotoAttachments() {
        val post = Post(0, 0, 0)
        var new_result = WallService.add(post)
        new_result = new_result.copy(
            text = "Новый пост!",
            attachments = arrayOf(PhotoAttachment(Photo(0, 0, 0,
                "How much is the fish?", "site.com/photo.jpg"))
            )
        )
        val result = WallService.update(new_result)
        assertEquals(result, true)
    }

    @Test
    fun update_OK_LinkAttachments() {
        val post = Post(0, 0, 0)
        var new_result = WallService.add(post)
        new_result = new_result.copy(
            text = "Новый пост!",
            attachments = arrayOf(LinkAttachment(Link("yandex.ru", "Яндекс", "Компания"))
            )
        )
        val result = WallService.update(new_result)
        assertEquals(result, true)
    }

    @Test
    fun update_OK_DocumentAttachments() {
        val post = Post(0, 0, 0)
        var new_result = WallService.add(post)
        new_result = new_result.copy(
            text = "Новый пост!",
            attachments = arrayOf(DocumentAttachment(Document(0, 0,
                "Служебная записка",
                "docx",
                "site.com/zapiska.docx"))
            )
        )
        val result = WallService.update(new_result)
        assertEquals(result, true)
    }
}