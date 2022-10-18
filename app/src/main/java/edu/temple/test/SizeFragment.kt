package edu.temple.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SizeFragment : Fragment() {

    private lateinit var fragmentViewModel : ViewModel //creating view model
    private val fragmentViewModelData = MutableLiveData(TextFragment())
    //having a hard time figuring out how to even create the view model to replace the interface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_size, container, false)
        //potentially return live data for the view model to replace the interface
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (view.findViewById(R.id.seekBar) as SeekBar) {
            setOnSeekBarChangeListener(object: OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, user: Boolean) {

                    // Inform parent about slider event with updated value
                    (requireActivity() as ValueChangeInterface).onChange(progress)
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {}
                override fun onStopTrackingTouch(p0: SeekBar?) {}

            })
        }
    }

}