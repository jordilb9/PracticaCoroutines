package cat.copernic.practicacoroutines.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cat.copernic.practicacoroutines.R
import cat.copernic.practicacoroutines.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MainFragmentBinding.inflate(inflater)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.mainViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart1.setOnClickListener{
            viewModel.setEstatStart(false)
            viewModel.setEstatPauseResume(true)
            viewModel.setEstatStop(true)
            viewModel.start()
        }
        binding.btnPauseResume.setOnClickListener {

            if(viewModel.estat.value == 0){
                viewModel.pause()
            }else{
                viewModel.resume()
            }
        }
        binding.btnStop1.setOnClickListener {
            viewModel.setEstatStart(true)
            viewModel.setEstatPauseResume(false)
            viewModel.setEstatStop(false)
            viewModel.stop()
        }


        binding.btnStart2.setOnClickListener{
            viewModel.setEstatStart2(false)
            viewModel.setEstatPauseResume2(true)
            viewModel.setEstatStop2(true)
            viewModel.start2()
        }
        binding.btnPauseResume2.setOnClickListener {

            if(viewModel.estat2.value == 0){
                viewModel.pause2()
            }else{
                viewModel.resume2()
            }
        }
        binding.btnStop2.setOnClickListener {
            viewModel.setEstatStart2(true)
            viewModel.setEstatPauseResume2(false)
            viewModel.setEstatStop2(false)
            viewModel.stop2()
        }
    }

}