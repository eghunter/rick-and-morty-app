package sfg.kmm.api

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}