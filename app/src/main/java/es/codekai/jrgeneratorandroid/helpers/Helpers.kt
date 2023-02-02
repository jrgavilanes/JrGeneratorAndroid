package es.codekai.jrgeneratorandroid.helpers

import es.codekai.jrgeneratorandroid.models.Terremoto

object Helpers {

    fun terremotosProvider(): List<Terremoto> {
        val terremotos = mutableListOf<Terremoto>()
        terremotos.add(Terremoto("1", "Valencia", "5.4", 1234L, -380.2, 6.21))
        terremotos.add(Terremoto("2", "Madrid", "6.4", 1235L, -280.2, 33.21))
        terremotos.add(Terremoto("3", "Barcelona", "7.4", 1236L, -180.2, 23.21))
        terremotos.add(Terremoto("4", "Sevilla", "8.4", 1237L, -480.2, 213.21))
        terremotos.add(Terremoto("5", "León", "4.4", 1238L, -780.2, 23.2451))
        terremotos.add(Terremoto("6", "Valencia", "5.4", 1234L, -380.2, 6.21))
        terremotos.add(Terremoto("7", "Madrid", "6.4", 1235L, -280.2, 33.21))
        terremotos.add(Terremoto("8", "Barcelona", "7.4", 1236L, -180.2, 23.21))
        terremotos.add(Terremoto("9", "Sevilla", "8.4", 1237L, -480.2, 213.21))
        terremotos.add(Terremoto("10", "León", "4.4", 1238L, -780.2, 23.2451))
        terremotos.add(Terremoto("11", "Valencia", "5.4", 1234L, -380.2, 6.21))
        terremotos.add(Terremoto("12", "Madrid", "6.4", 1235L, -280.2, 33.21))
        terremotos.add(Terremoto("13", "Barcelona", "7.4", 1236L, -180.2, 23.21))
        terremotos.add(Terremoto("14", "Sevilla", "8.4", 1237L, -480.2, 213.21))
        terremotos.add(Terremoto("15", "León", "4.4", 1238L, -780.2, 23.2451))
        terremotos.add(Terremoto("16", "Valencia", "5.4", 1234L, -380.2, 6.21))
        terremotos.add(Terremoto("17", "Madrid", "6.4", 1235L, -280.2, 33.21))
        terremotos.add(Terremoto("18", "Barcelona", "7.4", 1236L, -180.2, 23.21))
        terremotos.add(Terremoto("19", "Sevilla", "8.4", 1237L, -480.2, 213.21))
        terremotos.add(Terremoto("20", "León", "4.4", 1238L, -780.2, 23.2451))

        return terremotos
    }
}
