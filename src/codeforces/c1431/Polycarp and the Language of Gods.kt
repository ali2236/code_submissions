package codeforces.c1431

fun main(){
    var t = readLine()!!.toInt()
    while (t-->0){
        val note = readLine()!!
        var lines = 0
        var last = 'w'
        var ll = false
        note.toCharArray().forEachIndexed { i, c ->
            when(c){
                'v' -> {
                    if (last=='v'){
                        if (!ll) {
                            lines++
                            ll = true
                        } else {
                            ll = false
                        }
                    }
                }
                'w' ->{
                    lines++
                    ll=false
                }
            }
            last = c
        }
        println(lines)
    }
}