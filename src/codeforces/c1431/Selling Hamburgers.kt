package codeforces.c1431

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`);
    var t = scanner.nextInt()
    while (t-->0){
        val n = scanner.nextInt()
        val a = Array(n) {scanner.nextLong()}
        var max = n.toLong()
        for (i in a){
            if (i==1L) continue;
            val c = a.count { it >= i }.toLong()
            max = maxOf(max, c * i)
        }
        println(max)
    }
}