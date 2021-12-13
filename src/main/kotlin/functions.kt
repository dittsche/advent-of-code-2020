@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun readInput(day: Int) = object {}.javaClass.getResource("day$day.txt").readText()

fun String.splitToInts(delimiter: String = ",") = split(delimiter).map { it.toInt() }

fun <T> Iterable<T>.print() = onEach { println(it) }
