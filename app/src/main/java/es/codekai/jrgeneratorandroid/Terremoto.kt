package es.codekai.jrgeneratorandroid

data class Terremoto(
    val id: String,
    val lugar: String,
    val magnitud: String,
    val time: Long,
    val logitud: Double,
    val latitud: Double
)
