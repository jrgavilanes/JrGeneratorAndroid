package es.codekai.jrgeneratorandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _num = MutableLiveData<Int>()
    val num: LiveData<Int> get() = _num

    init {
        _num.value = 0
    }

    fun increaseNum(valor: Int) {
        _num.value = (_num.value)?.plus(valor)
    }
}
