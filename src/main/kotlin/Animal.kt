abstract class Animal(protected var name : String , protected var age : Int){
    abstract fun eat()
    fun fetchName(): String {
        return name
    }

    fun fetchAge(): Int {
        return age
    }
}