package pt.ulusofona.lp2.deisiGreatGame


enum class CommandType{GET, POST}

//Note: Router : obtem uma função que recebe um CommandType --> Função comando
fun router(): (CommandType) -> (GameManager, List<String>) -> String?{return ::callCommandFunction}

fun callCommandFunction(type: CommandType):(GameManager, List<String>) -> String?{
    when(type){
        CommandType.GET -> return::getPlayer
        CommandType.GET -> return::getPlayersByLanguage
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
                    println("yes it match")
                    listNome.add(programmer.name)
                }
            }
          }
       }

        if (listNome.size == 1){
            return listNome.get(0)
        }

        if (listNome.size == 2 ) {
            strNames += listNome.get(0) + "," + listNome.get(1)
            return strNames
        }

        if (listNome.size == 3 ) {
            strNames += listNome.get(0) + "," + listNome.get(1) + "," + listNome.get(2)
            return strNames
        }

        if (listNome.size == 4 ) {
            strNames += listNome.get(0) + "," + listNome.get(1) + "," + listNome.get(2) + "," + listNome.get(3)
            return strNames
        }
           /* for (str in listNome) {
                strNames += "," + str
            }*/

    return "tt"
}

fun postPlayer(manager: GameManager, args: List<String>): String?{return null}

val manager = GameManager()
val routerFn = router()
val commandGetFn = routerFn.invoke(CommandType.GET)
//Note: Chamada da função comando
val getPlayer = commandGetFn.invoke(manager, listOf("PLAYER", "Joshua"))
val postPlayer = commandGetFn.invoke(manager, listOf("PLAYER", "Joshua"))