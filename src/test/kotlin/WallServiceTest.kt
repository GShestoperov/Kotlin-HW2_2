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

}