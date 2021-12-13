object Day1 : PuzzleSolver(1) {

    override fun solve1(input: String) = with(input.lines().map { it.toInt() }) {
        this.flatMap { number -> this.map { number to it } }
            .first { (a, b) -> a + b == 2020 }
            .let { (a, b) -> a * b }
    }

    override fun solve2(input: String) = with(input.lines().map { it.toInt() }) {
        this.flatMap { number -> this.map { number to it } }
            .flatMap { (a, b) -> this.map { Triple(a, b, it) } }
            .first { (a, b, c) -> a + b + c == 2020 }
            .let { (a, b, c) -> a * b * c }
    }
}
