package go.tracker.domain.service

import go.tracker.models.user.Trainer
import go.tracker.persistence.service.TrainerPersistenceService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals

@ExtendWith(MockKExtension::class)
class TrainerServiceTest {

    @MockK
    private lateinit var userPersistenceService: TrainerPersistenceService

    @InjectMockKs
    private lateinit var service: TrainerService

    @Test
    @DisplayName("Deve criar um novo treinador")
    fun `should create a new trainer`() {
        val trainerModel = Trainer().apply {
            ign = "Trainer0"
            email = "email@email.com"
        }

        every { userPersistenceService.createTrainer(trainerModel) } returns trainerModel

        val created = service.create(trainerModel)

        assertEquals(trainerModel.ign, created.ign)
        assertEquals(trainerModel.email, created.email)
    }
}