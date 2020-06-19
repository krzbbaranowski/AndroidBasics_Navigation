package krzbb.com.androidbasics_navigation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_photos_list.*
import krzbb.com.androidbasics_navigation.R

class PhotosFragment : Fragment()
{
    private lateinit var photosViewModel: PhotosViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_photos_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        photosViewModel = ViewModelProvider(this).get(PhotosViewModel::class.java)

        photosViewModel.photos.observe(viewLifecycleOwner, Observer { items ->
            photos.adapter = PhotosRecyclerViewAdapter(items) {
                // Toast.makeText(requireContext(), "${it.content}, ${it.details}", Toast.LENGTH_SHORT).show()

                findNavController().navigate(PhotosFragmentDirections.actionPhotosFragmentToDetailsFragment())
            }
        })
    }
}
