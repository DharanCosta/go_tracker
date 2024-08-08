package go.tracker.api.resource

import go.tracker.api.request.trainer.TrainerCreateRequest
import go.tracker.domain.service.TrainerService
import go.tracker.models.user.Trainer
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals

@ExtendWith(MockKExtension::class)
class TrainerResourceTest {

    @MockK
    private lateinit var service: TrainerService


    @InjectMockKs
    private lateinit var resource: TrainerResource

    @Test
    @DisplayName("Deve criar um novo treinador")
    fun `should create a new trainer`() {
        val trainerCreateRequest = TrainerCreateRequest().apply {
            ign = "Trainer0"
            email = "email@email.com"
        }
        val trainer = Trainer().apply {
            ign = "Trainer0"
            email = "email@email.com"
        }

        every { service.create(trainerCreateRequest.toDomain(trainerCreateRequest)) } returns trainer

        val response = resource.create(trainerCreateRequest)

        assertEquals(trainerCreateRequest.ign, response.body?.trainer)
    }
}