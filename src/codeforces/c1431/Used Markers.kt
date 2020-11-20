package codeforces.c1431

import java.util.stream.Collectors

fun main() {
    var t = readLine()!!.toInt()
    while (t-- > 0) {
        val n = readLine()!!.toInt()
        val lectures = readLine()!!
                .split(' ')
                .mapIndexed { i, s -> Lecture(i + 1, s.toInt()) }
                .toMutableList()

        lectures.sortedBy { it.acceptance }
        val ord = mutableListOf<Lecture>()
        var flag = true
        while (lectures.isNotEmpty()) {
            ord.add(if (flag) lectures.removeLast() else lectures.removeFirst())
            flag = !flag
        }
        ord.map { it.pos.toString() }.stream().collect(Collectors.joining(" ")).let { println(it) }
    }
}

data class Lecture(val pos: Int, val acceptance: Int)