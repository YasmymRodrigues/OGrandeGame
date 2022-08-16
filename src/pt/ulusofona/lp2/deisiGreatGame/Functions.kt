package pt.ulusofona.lp2.deisiGreatGame

import jdk.swing.interop.SwingInterOpUtils


enum class CommandType{GET, POST}

//Note: Router : obtem uma função que recebe um CommandType --> Função comando
fun router(): (commandType: CommandType) -> (GameManager, List<String>) -> String? {
    return { commandType: CommandType ->
       when(commandType) {
           CommandType.GET -> command()
           CommandType.POST -> postCommand()
       }
    }
}

fun postCommand(): (GameManager, List<String>) -> String? {
    return :: fazerComandoPost
}

fun fazerComandoPost(manager: GameManager, args: List<String>): String? {
    return null
}


fun command():(GameManager, List<String>) -> String? {
    return ::fazerComando
}


fun fazerComando(manager: GameManager, args: List<String>): String? {
    when (args[0]) {
        "PLAYER" -> return getPlayer(manager, args)
        "PLAYERS_BY_LANGUAGE" -> return getPlayersByLanguage(manager, args)
        "POLYGLOTS" -> return getPolyglots(manager, args)
        "POST" -> return null
    }

    return null
}

/*fun callCommandFunction(type: CommandType):(manager: GameManager, args: List<String>) -> String?{
   *//* when(args[0]){
        "PLAYER" -> return::getPlayer
        "PLAYERS_BY_LANGUAGE"-> return ::getPlayersByLanguage
        "POLYGLOTS" -> return ::getPolyglots

        CommandType.GET -> return::getPlayer
        CommandType.GET -> return::getPlayersByLanguage
        CommandType.GET -> return::getPolyglots
       // CommandType.POST -> return ::postPlayer
    }*//*


}*/

/*fun funReceiveStr(manager: GameManager, args: List<String>): String? {
    when (args[0]) {
        "PLAYER" -> return:: getPlayer(manager, args)
        "PLAYERS_BY_LANGUAGE" -> return:: getPlayersByLanguage(manager, args)
        "POLYGLOTS" -> return:: getPolyglots(manager, args)
    }*/

    //DONE: GET COMMAND
//Note: Função Comando(depende do comando que foi passado)
    fun getPlayer(manager: GameManager, args: List<String>): String? {
        var programmers = mutableListOf<Programmer>()
        programmers.addAll(manager.getProgrammers(false))

        for (programmer in programmers) {
            var firstName = programmer.name
            var parts = firstName.split(" ")
            if (args[1] == parts[0]) {
                return programmer.toString()
            }
        }
        return "Inexistent player"
    }

    fun getPlayersByLanguage(manager: GameManager, args: List<String>): String? {
        var listNome = mutableListOf<String>()
        var strNames = ""

        for (programmer in manager.getProgrammers(false)) {
            for (language in programmer.getLanguages()) {
                var tmp = language.nome.split(";")
                for (lng in tmp) {
                    if (lng == args[1]) {
                        listNome += programmer.name
                    }
                }
            }
        }

        for (i in 0 until listNome.size) {
            if (i < listNome.size && i > 0) {
                strNames += "," + listNome[i]
            } else {
                strNames += listNome[i]
            }
        }

        if (strNames.isNotEmpty()) {
            return strNames
        }
        return ""
    }


    fun getPolyglots(manager: GameManager, args: List<String>): String? {
        var nameNrLang: HashMap<String, Int> = HashMap<String, Int>()
        var strNameNrLang = ""


        for (programmer in manager.getProgrammers(false)) {
            println(programmer.name + ":" + programmer.getLanguages())
            for (language in programmer.getLanguages()) {
                var tmp = language.nome.split(";")
                //strNameNrLang += "" + programmer.name + ":" + tmp.size + "\n"
                nameNrLang.put(programmer.name, tmp.size)
            }
        }
        val resultMap = nameNrLang.entries.sortedBy { it.value }.associate { it.toPair() }

        for (res in resultMap) {
            if (res.value > 1) {
                strNameNrLang += "" + res.key + ":" + res.value + "\n"
                println(strNameNrLang)
            }
        }

        return strNameNrLang
    }

    fun postPlayer(manager: GameManager, args: List<String>): String? {
        return null
    }

    val manager = GameManager()
    //val routerFn = router()
    //val commandGetFn = routerFn.invoke(CommandType.GET)

