plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "GoTracker"
include("go-tracker-api")
include("go-tracker-persistence")
include("go-tracker-domain")
include("go-tracker-models")
include("go-tracker-commons")
