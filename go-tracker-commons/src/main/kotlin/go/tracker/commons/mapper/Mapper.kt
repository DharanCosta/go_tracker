package go.tracker.commons.mapper

fun interface Mapper<T, U> {
    fun map(clazz: T):U
}