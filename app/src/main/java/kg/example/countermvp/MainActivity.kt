package kg.example.countermvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kg.example.countermvp.databinding.ActivityMainBinding
import kg.example.countermvp.model.view.CounterView
import kg.example.countermvp.model.view.Injector


class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    private val presenter = Injector.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)

        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.increment()
            }
            decrementBtn.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun updateCount(count: Int) {
        binding.counterTv.text = count.toString()
        presenter.logicCount(this, binding.counterTv)
    }
}
