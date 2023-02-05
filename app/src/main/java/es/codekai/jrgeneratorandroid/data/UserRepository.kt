package es.codekai.jrgeneratorandroid.data

import es.codekai.jrgeneratorandroid.model.User
import kotlinx.coroutines.delay
import kotlin.random.Random

class UserRepository {

    private val fakeDB = mutableListOf<User>()

    init {
        for (i in 1..200000) {
            fakeDB.add(User(id = i, name = "user$i"))
        }
    }

    suspend fun getUsers(): List<User> {
        delay(Random.nextLong(1000, 2000))
        return fakeDB
    }
}
