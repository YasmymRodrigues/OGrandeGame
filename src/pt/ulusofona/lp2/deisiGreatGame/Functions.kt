package pt.ulusofona.lp2.deisiGreatGame

import com.sun.source.tree.LiteralTree


enum class CommandType{GET, POST}

fun getPlayer(manager: GameManager, args: List<String>): String? {return null}

fun router(): (CommandType) -> (GameManager, List<String>) -> String?{

    return ::teste
}

fun teste(type: CommandType):(GameManager, List<String>) -> String? {

return ::getPlayer
}
val f1 = router()
val f2 = f1.invoke(CommandType.GET)
//val result = f2.invoke(manager, listOf("PLAYER", "Joshua"))

