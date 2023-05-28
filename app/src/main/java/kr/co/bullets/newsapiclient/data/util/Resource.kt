package kr.co.bullets.newsapiclient.data.util

// Inside this Resource class we are going to define 3 classes for Loading, Success and error states
// In Kotlin, sealed classes allow us to represent hierarchies in the same file or as nested classes
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}