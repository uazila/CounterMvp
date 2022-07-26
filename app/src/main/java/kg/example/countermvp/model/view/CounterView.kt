package kg.example.countermvp.model.view

interface CounterView {
    fun updateCount(count: Int)
    fun showToast()
    fun setGreenColor()
    fun setBlackColor()
}