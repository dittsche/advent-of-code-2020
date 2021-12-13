object Day2 : PuzzleSolver(2) {

    override fun solve1(input: String) =
        input.lines().map { it.parseLine() }.count { (spec, password) -> spec.match(password) }

    override fun solve2(input: String) =
        input.lines().map { it.parseLine() }.count { (spec, password) -> spec.matchCorrect(password) }

    private fun String.parseLine(): Pair<PasswordSpec, String> =
        split(": ")
            .let { it[0].split(" ").toPasswordSpec() to it[1] }

    private fun List<String>.toPasswordSpec() =
        this[0].split("-")
            .let { it[0].toInt() to it[1].toInt() }
            .let { (first, second) -> PasswordSpec(first, second, this[1].toList().single()) }

    private data class PasswordSpec(val first: Int, val second: Int, val char: Char) {
        fun match(password: String) = IntRange(first, second).contains(password.count { it == char })
        fun matchCorrect(password: String) =
            password.toList().let { (it[first - 1] == char) xor (it[second - 1] == char) }
    }
}
