package com.aungpyaesone.mvi_architecutre_android_beginners.extension

fun main(){
//   println(performOperation())
//
//   println(5.isEven())
//
//    val nine = square(9)
//    val add = add(10,10)
//    println(add)

//    val add = returnMeAddFunction()
//    val result = add(10,20)
//    println(result)
//    getHighOrder()

//    val (name,age) = Developer("aung pyae sone","25")
//    println(name)
//    println(age)
//
//    val mMap = mutableMapOf<Int,String>()
//    mMap[0] = "a"
//    mMap[1] = "b"
//    mMap[2] = "c"
//    mMap[3] = "d"
//    mMap[4] = "e"
//
//    for((key,value) in mMap){
//        println(key)
//    }

    print(run{print("Hello World")})

}
fun Int.isEven() : Boolean{
    return this%2 == 0
}

val square : (Int) ->Int = {value -> value * value}
val add : (Int,Int) -> Int = {value,value2 -> value + value2}

private fun performOperation(){
   Person().run {
        name = "Aung Pyae Sone"
        phone = "0989877666776"
        email ="aungpyaesoneice@gmail.com"
        return@run "The details of the person ${displayInfo()}"
    }

}

fun passMeFunction(abc:()->Unit){}

fun returnMeAddFunction(): ((Int, Int) -> Int) {
    // can do something and return function as well
    // returning function
    return ::myAdd
}

fun myAdd(a:Int,b:Int):Int{
    return a+b
}

data class Person(var name:String = "",var phone:String ="",var email:String=""){
    fun displayInfo(){
        println(name)
        println(email)
        println(phone)
    }
}

fun highOrder(a:Int,b:Int,success:(String)->Unit){
    val data = a + b
    if(data == 10){
        success(data.toString())
    }else{
        success("wrong answer")
    }

}

fun getHighOrder(){
    highOrder(5,6,success = {
        println(it)
    })
}


data class Developer(val name:String,val age: String)

