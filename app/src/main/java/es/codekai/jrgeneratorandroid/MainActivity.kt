package es.codekai.jrgeneratorandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import es.codekai.jrgeneratorandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
    }

    private fun setUI() {
        var clicks = 0
        binding.apply {
            btnMainClick.setOnClickListener {
                clicks++
                txtMainClick.text = clicks.toString()
            }
            btnLongRequest.setOnClickListener {
                longRequest()
            }
            btnLongRequestGood.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    longRequest()
                }
            }
            btnLongRequestUpdateUI.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    longRequestUpdateUI()
                }
            }
            btnParallelDecomposition.setOnClickListener {
//                Opción 1
//                CoroutineScope(Dispatchers.IO).launch {
//                    Log.d("janrax", "empiezo a pedir stock")
//                    val stock1 = async { getStock1() }
//                    val stock2 = async { getStock2() }
//                    val stock3 = async { getStock3() }
//                    val total = stock1.await() + stock2.await() + stock3.await()
//                    withContext(Dispatchers.Main) {
//                        binding.txtParallelResult.text = total.toString()
//                        Log.d("janrax", "acabo de recibir stock")
//                    }
//                }

//              Opción 2 - Combinación de llamadas en paralelo
                CoroutineScope(Dispatchers.Main).launch {
                    binding.txtParallelResult.text = ""
                    Log.d("janrax", "empiezo a pedir stock")

                    val stock1 = async(Dispatchers.IO) { getStock1() }
                    val stock2 = async(Dispatchers.IO) { getStock2() }
                    // Ejemplo alternativo de llamada
                    val stock3 = CoroutineScope(Dispatchers.IO).async {
                        return@async getStock3()
                    }

                    val total = stock1.await() + stock2.await() + stock3.await()

                    binding.txtParallelResult.text = total.toString()

                    Log.d("janrax", "acabo de recibir stock")
                }
            }

            binding.btnStructuredConcurrency.setOnClickListener {
                binding.txtStructuredConcurrency.text = ""
                CoroutineScope(Dispatchers.Main).launch {
                    structuredConcurrencyClick()
                }
            }
        }
    }

    private fun longRequest() {
        for (i in 1..200000) {
            Log.d("janrax", "$i from ${Thread.currentThread().name}")
        }
    }

    private suspend fun longRequestUpdateUI() {
        for (i in 1..200000) {
            withContext(Dispatchers.Main) {
                binding.txtUpdatesUI.text = "$i from ${Thread.currentThread().name}"
            }
        }
    }

    private suspend fun getStock1(): Int {
        delay(1000)
        return 1000
    }

    private suspend fun getStock2(): Int {
        delay(2000)
        return 2000
    }

    // Recommended
    private suspend fun structuredConcurrencyClick() {
        coroutineScope {
            val count1 = async(Dispatchers.IO) { getStock1() }

            val count2 = async(Dispatchers.IO) {
                return@async getStock2()
            }

            val count3 = async(Dispatchers.IO) {
                return@async getStock3()
            }

            binding.txtStructuredConcurrency.text =
                (count1.await() + count2.await() + count3.await()).toString()
        }
    }

    private suspend fun getStock3(): Int {
        delay(3000)
        return 3000
    }
}
