package pt.ulusofona.lp2.deisiGreatGame



enum class CommandType{GET, POST}

fun getPlayer(manager: GameManager, args: List<String>): String? {return ""}

fun router() : (GameManager, List<String>) -> String? { CommandType.GET ; return ::getPlayer}
//val f1 = router()
//val f2 = f1.invoke(GameManager)
//val result = f2.invoke(manager, listOf("PLAYER", "Joshua"))

