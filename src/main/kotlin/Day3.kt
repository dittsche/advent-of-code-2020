object Day3 : PuzzleSolver(3) {

    override fun solve1(input: String): Number {
        val lines = input.lines().map { it.toList() }
        val width = lines.first().size

        return countHits(lines, 1, 3, width)
    }

    override fun solve2(input: String): Number {
        val lines = input.lines().map { it.toList() }
        val width = lines.first().size

        return listOf(
            1 to 1,
            3 to 1,
            5 to 1,
            7 to 1,
            1 to 2
        ).map { (right, down) -> countHits(lines, down, right, width) }
            .fold(1L) { acc, curr -> acc * curr }
    }

    private fun countHits(
        lines: List<List<Char>>,
        down: Int,
        right: Int,
        width: Int
    ) = (lines.indices step down)
        .count { lines[it][(right * (it / down)) % width] == '#' }
}
