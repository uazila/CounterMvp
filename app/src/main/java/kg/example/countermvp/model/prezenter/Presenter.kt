package kg.example.countermvp.model.prezenter

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import kg.example.countermvp.R
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

    fun logicCount(context: Context, counterTv: TextView) {
        if (model.count == 10) Toast.makeText(context, "Успешно", Toast.LENGTH_SHORT).show()
        if (model.count >= 15) counterTv.setTextColor(context.getColor(R.color.green))
        else counterTv.setTextColor(context.getColor(R.color.black))
    }
}
