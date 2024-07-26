package go.tracker.persistence.entity.user

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime

@MappedSuperclass
open class AuditableEntity (
    @Column(name = "DAT_CREATED", updatable = false, nullable = false, columnDefinition = "DATE")
    open var creationDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "DAT_UPDATED", nullable = false, columnDefinition = "DATE")
    open var updateDate: LocalDateTime = LocalDateTime.now()
) {
    @PreUpdate
    fun onUpdate() {
        this.updateDate = LocalDateTime.now()
    }
}
