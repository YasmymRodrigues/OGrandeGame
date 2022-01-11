package pt.ulusofona.lp2.deisiGreatGame



enum class CommandType{GET, POST}

fun getPlayer(manager: GameManager, args: List<String>): String? {return ""}

fun router(): (CommandType) -> Array<String> {

    return ::teste
}

fun teste(type: CommandType):Array<String>{


}
val f1 = router()
val f2 = f1.invoke(CommandType.GET)
//val result = f2.invoke(manager, listOf("PLAYER", "Joshua"))

