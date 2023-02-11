package es.codekai.jrgeneratorandroid.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Ya no lo uso, ahora se provee por DI.
object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
