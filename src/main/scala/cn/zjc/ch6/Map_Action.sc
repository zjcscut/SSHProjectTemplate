val map =Map("book" -> 10,"gun" -> 20,"ipad" -> 2000)

for((k,v) <- map) yield (k,v*0.9)