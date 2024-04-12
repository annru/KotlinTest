package com.example.kotlintest

class Driver : IDriver {


    override fun driver(car: ICar) {
        car.run()
    }
}