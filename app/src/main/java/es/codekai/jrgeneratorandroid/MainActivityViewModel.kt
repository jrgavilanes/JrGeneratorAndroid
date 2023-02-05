package es.codekai.jrgeneratorandroid

import androidx.lifecycle.*
import es.codekai.jrgeneratorandroid.data.UserRepository
import es.codekai.jrgeneratorandroid.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> get() = _users

//    Live Data Builder
    var users2 = liveData(Dispatchers.IO) {
        emit(userRepository.getUsers())
    }

    private val userRepository = UserRepository()

    fun getUserData() {
//        Opcion1
//        viewModelScope.launch {
//            var users: List<User>
//            withContext(Dispatchers.IO) {
//                users = userRepository.getUsers()
//            }
//            _users.value = users
//        }

//        Opción 2
        viewModelScope.launch {
            val users = async(Dispatchers.IO) { return@async userRepository.getUsers() }
            _users.value = users.await()
        }
    }
}
