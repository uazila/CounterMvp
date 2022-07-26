package kg.example.countermvp.model.view

import kg.example.countermvp.model.CounterModel
import kg.example.countermvp.model.prezenter.Presenter

class Injector {
    companion object{
        fun getPresenter(): Presenter{
        return Presenter()
        }

        fun getModel(): CounterModel{
            return CounterModel()
        }
    }
}