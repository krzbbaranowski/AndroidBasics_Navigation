package krzbb.com.androidbasics_navigation.list.dummy

import java.util.ArrayList
import java.util.HashMap

object DummyContent
{
    val ITEMS: MutableList<DummyItem> = ArrayList()

    private val COUNT = 25

    init
    {
        for (i in 1..COUNT)
        {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: DummyItem)
    {
        ITEMS.add(item)
    }

    private fun createDummyItem(position: Int): DummyItem
    {
        return DummyItem(position.toString(), "Item " + position, "Details ${position}")
    }

    data class DummyItem(val id: String, val content: String, val details: String)
    {
        override fun toString(): String = content
    }
}
