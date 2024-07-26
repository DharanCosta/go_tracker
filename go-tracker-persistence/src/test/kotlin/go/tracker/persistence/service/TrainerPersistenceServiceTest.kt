package go.tracker.persistence.service

import go.tracker.models.user.Trainer
import go.tracker.persistence.entity.user.TrainerEntity
import go.tracker.persistence.repository.TrainerRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class TrainerPersistenceServiceTest {

    @MockK
    private lateinit var repository: TrainerRepository

    @InjectMockKs
    private lateinit var persistenceService: TrainerPersistenceService

    @Test
    @DisplayName("Deve persistir um novo treinador")
    fun `should persist a new trainer`() {
        val trainer = Trainer().apply {
            ign = "Trainer0"
            email = "email@email.com"
        }
        val trainerEntity = TrainerEntity().apply {
            ign = "Trainer0"
            email = "email@email.com"
        }

        every { repository.save(any()) } returns trainerEntity

        val response = persistenceService.createTrainer(trainer)

        assertEquals(trainer.ign, response.ign)
    }

}