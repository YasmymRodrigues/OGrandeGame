package pt.ulusofona.lp2.deisiGreatGame


enum class CommandType{GET, POST}


//Note: Função Comando(depende do comando que foi passado)
fun getPlayer(manager: GameManager, args: List<String>): String? {
    var programmers = mutableListOf<Programmer>()
    programmers.addAll(manager.getProgrammers(false))

    for(i in programmers){
        var firstName = i.name
        var parts = firstName.split(" ")
        if(args[1] == parts[0]){
            return i.toString()
        }
    }
    return "Inexistent player"

}

/*fun getPlayersByLanguage(manager: GameManager, ){

}*/

//Note: Router : obtem uma função que recebe um CommandType --> Função comando
fun router(): (CommandType) -> (GameManager, List<String>) -> String?{return ::teste}


fun teste(type: CommandType):(GameManager, List<String>) -> String?{return ::getPlayer}


val manager = GameManager()
val routerFn = router()
val commandGetFn = routerFn.invoke(CommandType.GET)


//Note: Chamada da função comando
val getPlayer = commandGetFn.invoke(manager, listOf("PLAYER", "Joshua"))



//val getGuido = commandGetFn.invoke(manager, listOf("PLAYER", "Guido"))

