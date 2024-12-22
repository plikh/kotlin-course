package lesson31.homework

import com.pavel.likholap.lesson31.homework.Cereal
import com.pavel.likholap.lesson31.homework.CerealStorageImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*

class CerealStorageImplTest {

    private lateinit var storage: CerealStorageImpl

    @BeforeEach
    fun setup() {
        storage = CerealStorageImpl(containerCapacity = 10f, storageCapacity = 50f)
    }

    @Test
    fun `add cereal and return correct value`() {
        val leftover = storage.addCereal(Cereal.BUCKWHEAT, 5f)
        assertEquals(5f, leftover)
    }

    @Test
    fun `exception when adding negative amount`() {
        val exception = assertThrows<IllegalArgumentException> {
            storage.addCereal(Cereal.BUCKWHEAT, -1f)
        }
        assertEquals("Amount can not be negative", exception.message)
    }

    @Test
    fun `throw exception no space in container`() {
        storage.addCereal(Cereal.MILLET, 10f)
        val exception = assertThrows<IllegalStateException> {
            storage.addCereal(Cereal.MILLET, 1f)
        }
        assertEquals("No space in container", exception.message)
    }


    @Test
    fun `get correct cereal value`() {
        storage.addCereal(Cereal.PEAS, 8f)
        val retrieved = storage.getCereal(Cereal.PEAS, 5f)
        assertEquals(5f, retrieved)
        assertEquals(3f, storage.getAmount(Cereal.PEAS))
    }

    @Test
    fun `return only available amount when requested more than available`() {
        storage.addCereal(Cereal.RICE, 8f)
        val retrieved = storage.getCereal(Cereal.RICE, 10f)
        assertEquals(8f, retrieved)
    }

    @Test
    fun `throw exception requesting negative amount`() {
        val exception = assertThrows<IllegalArgumentException> {
            storage.getCereal(Cereal.BUCKWHEAT, -1f)
        }
        assertEquals("Amount can not be negative or zero", exception.message)
    }

    @Test
    fun `should remove container if empty`() {
        storage.addCereal(Cereal.BULGUR, 5f)
        storage.getCereal(Cereal.BULGUR, 5f)
        val removed = storage.removeContainer(Cereal.BULGUR)
        assertTrue(removed)
        assertFalse(storage.getAmount(Cereal.BULGUR) > 0)
    }

    @Test
    fun `do not remove not empty container`() {
        storage.addCereal(Cereal.BUCKWHEAT, 5f)
        val removed = storage.removeContainer(Cereal.BUCKWHEAT)
        assertFalse(removed)
    }

    @Test
    fun `return correct space in container`() {
        storage.addCereal(Cereal.BUCKWHEAT, 5f)
        val space = storage.getSpace(Cereal.BUCKWHEAT)
        assertEquals(5f, space)
    }
}