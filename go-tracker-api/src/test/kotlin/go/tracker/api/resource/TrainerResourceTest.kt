package go.tracker.api.resource

import go.tracker.domain.service.TrainerService
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class TrainerResourceTest {

    @MockK
    private lateinit var service: TrainerService


    @InjectMockKs
    private lateinit var resource: TrainerResource
}