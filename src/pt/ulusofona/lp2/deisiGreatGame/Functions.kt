package pt.ulusofona.lp2.deisiGreatGame


enum class CommandType{GET, POST}

//Note: Router : obtem uma função que recebe um CommandType --> Função comando
fun router(): (CommandType) -> (GameManager, List<String>) -> String?{return ::callCommandFunction}

fun callCommandFunction(type: CommandType):(GameManager, List<String>) -> String?{
    when(type){
        CommandType.GET -> return::getPlayer
        CommandType.GET -> return::getPlayersByLanguage
        CommandType.GET -> return::getPolyglots



            /*when () {
                0 -> return "inheritance.png"
                1 -> return "functional.png"
                2 -> return "unit-tests.png"
                3 -> return "catch.png"
                4 -> return "IDE.png"
                5 -> return "ajuda-professor.png"
            }*/

        CommandType.POST -> return ::postPlayer
    }
}

//DONE: GET COMMAND
//Note: Função Comando(depende do comando que foi passado)
fun getPlayer(manager: GameManager, args: List<String>): String? {
    var programmers = mutableListOf<Programmer>()
    programmers.addAll(manager.getProgrammers(false))

    for(programmer in programmers){
        var firstName = programmer.name
        var parts = firstName.split(" ")
        if(args[1] == parts[0]){
            return programmer.toString()
        }
    }
    return "Inexistent player"
}

fun getPlayersByLanguage(manager: GameManager, args: List<String>): String?{
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

    for (i in 0 until listNome.size){
        if(i < listNome.size && i > 0){
            strNames += "," + listNome[i]
        }else{
            strNames += listNome[i]
        }
    }
    return strNames





    return ""
}


fun getPolyglots(manager: GameManager, args: List<String>): String?{
    var nameNrLang : HashMap<String, Int> = HashMap<String, Int> ()
    var strNameNrLang = ""


    for (programmer in manager.getProgrammers(false)){
        println(programmer.name + ":" +programmer.getLanguages())
        for (language in programmer.getLanguages()) {
            var tmp = language.nome.split(";")
            //strNameNrLang += "" + programmer.name + ":" + tmp.size + "\n"
            nameNrLang.put(programmer.name, tmp.size)
        }
    }
    val resultMap = nameNrLang.entries.sortedBy { it.value }.associate { it.toPair() }

    for (res in resultMap){
        strNameNrLang += "" + res.key + ":" + res.value + "\n"
    }

    return strNameNrLang
}

fun postPlayer(manager: GameManager, args: List<String>): String?{return null}

val manager = GameManager()
val routerFn = router()
val commandGetFn = routerFn.invoke(CommandType.GET)
//Note: Chamada da função comando
val getPlayer = commandGetFn.invoke(manager, listOf("PLAYER", "Joshua"))
val postPlayer = commandGetFn.invoke(manager, listOf("PLAYER", "Joshua"))