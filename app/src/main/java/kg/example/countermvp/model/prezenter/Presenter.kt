package kg.example.countermvp.model.prezenter

import kg.example.countermvp.model.view.CounterView
import kg.example.countermvp.model.view.Injector

class Presenter {

    lateinit var view: CounterView
    private var model = Injector.getModel()

    fun increment() {
        model.increment()
        view.updateCount(model.count)
    }

    fun decrement() {
        model.decrement()
        view.updateCount(model.count)
    }

    fun attachView(counterView: CounterView) {
        view = counterView
    }

    fun initToast() {
        if (model.count == 10) view.showToast()

    }

    fun initColor() {
        if (model.count >= 15) view.setGreenColor()
        else view.setBlackColor()
    }
}
