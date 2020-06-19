package krzbb.com.androidbasics_navigation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import krzbb.com.androidbasics_navigation.list.dummy.DummyContent

class PhotosViewModel : ViewModel()
{
    val photos = MutableLiveData<List<DummyContent.DummyItem>>()

    init
    {
        photos.value = DummyContent.ITEMS
    }
}
