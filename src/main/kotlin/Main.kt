import interfaces.SoundMaker
import interfaces.Swimmer

//-----------------------------------------------Zoo Application------------------------------------------


class Mammal(name: String, age: Int, private val type : String): Animal(name, age), SoundMaker, Swimmer {
    override fun eat() = println("$name the $type is eating")
    fun run() = println("$name the $type is running")

    override fun makeSound() = println("$name the $type makes a sound")
    override fun swim() = println("$name the $type is swimming")

    fun eat(food : String) = println("$name the $type is eating $food")

}
class Bird(name: String, age: Int, private val feathercolor : String): Animal(name, age), SoundMaker{
    override fun eat() {
        println("$name the bird is eating")
    }
    fun fly() {
        println("$name the bird is flying")
    }

    override fun makeSound() {
        println("$name the bird makes a sound")
    }
}
class Reptile(name: String, age: Int, private val scaleColor: String) : Animal(name, age) {
    override fun eat() {
        println("$name the reptile is eating")
    }

    fun crawl() {
        println("$name the reptile is crawling")
    }
}
class Zoo{
    private val animals: MutableList<Animal> = mutableListOf()

    fun addAnimal(animal: Animal) {
        animals.add(animal)
    }
    fun displayAnimals() {
        for (animal in animals) {
            println("Name: ${animal.fetchName()}, Age: ${animal.fetchAge()}")
            animal.eat()
            if (animal is Mammal) {
                animal.run()
            } else if (animal is Bird) {
                animal.fly()
            } else if (animal is Reptile) {
                animal.crawl()
            }
            if (animal is SoundMaker) {
                animal.makeSound()
            }
            if (animal is Swimmer) {
                animal.swim()
            }
            println()
        }
    }
}


fun main() {
    val zoo = Zoo()

    val human = Mammal("Salman", 51, "Human")
    val canary = Bird("Canary", 2, "Yellow")
    val snake = Reptile("Slytherin", 310, "Green")

    zoo.addAnimal(human)
    zoo.addAnimal(canary)
    zoo.addAnimal(snake)

    zoo.displayAnimals()
    human.eat("chicken")

}

