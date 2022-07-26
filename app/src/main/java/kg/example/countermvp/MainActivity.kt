package kg.example.countermvp

import android.os.Bundle
import android.widget.Toast
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
                presenter.initToast()
                presenter.initColor()
            }
            decrementBtn.setOnClickListener {
                presenter.decrement()
                presenter.initToast()
                presenter.initColor()
            }
        }
    }

    override fun updateCount(count: Int) {
        binding.counterTv.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(this, "Поздравляю!", Toast.LENGTH_SHORT).show()
    }

    override fun setGreenColor() {
        binding.counterTv.setTextColor(getColor(R.color.green))
    }

    override fun setBlackColor() {
        binding.counterTv.setTextColor(getColor(R.color.black))
    }
}
