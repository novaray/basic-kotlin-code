val oneToFive: IntRange = 1..5
val aToE: CharRange = 'a'..'e'
val seekHelp: ClosedRange<String> = "hell".."help"

println(seekHelp.contains("helm"))  //true
println(seekHelp.contains("helq"))  //false

for (i in 1..5) { print("$i, ") }  //1, 2, 3, 4, 5,
for (ch in 'a'..'e') { print(ch) } //abcde

for (word in "hell".."help") { print("$word, ") } //ERROR
//for-loop range must have an 'iterator()' method
