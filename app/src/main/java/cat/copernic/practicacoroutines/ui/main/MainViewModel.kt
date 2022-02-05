package cat.copernic.practicacoroutines.ui.main

import android.widget.Button
import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {
    private val _jobTime = MutableLiveData<Int>(8000)
    val jobTime: LiveData<Int> get() = _jobTime


    private val _estat = MutableLiveData<Int>(0)
    val estat: LiveData<Int> get() = _estat

    private val _progressMax = MutableLiveData<Int>(100)
    val progressMax: LiveData<Int> get() = _progressMax

    private val _progressStart = MutableLiveData<Int>()
    val progressStart: LiveData<Int> get() = _progressStart

    private val _incrementProgress = MutableLiveData<Int>()
    val incrementProgress: LiveData<Int> get() = _incrementProgress

    private val _buttonStrat = MutableLiveData<Boolean>(true)
    val buttonStart: LiveData<Boolean> get() = _buttonStrat
    fun setEstatStart (buttonStart : Boolean){
        _buttonStrat.value = buttonStart
    }

    private val _buttonPauseResume = MutableLiveData<Boolean>(false)
    val buttonPauseResume: LiveData<Boolean> get() = _buttonPauseResume
    fun setEstatPauseResume (buttonPauseResume : Boolean){
        _buttonPauseResume.value = buttonPauseResume
    }

    private val _buttonStop = MutableLiveData<Boolean>(false)
    val buttonStop: LiveData<Boolean> get() = _buttonStop
    fun setEstatStop (buttonStop : Boolean){
        _buttonStop.value = buttonStop
    }




    private val _estat2 = MutableLiveData<Int>(0)
    val estat2: LiveData<Int> get() = _estat2

    private val _progressMax2 = MutableLiveData<Int>(100)
    val progressMax2: LiveData<Int> get() = _progressMax2

    private val _progressStart2 = MutableLiveData<Int>()
    val progressStart2: LiveData<Int> get() = _progressStart2

    private val _incrementProgress2 = MutableLiveData<Int>()
    val incrementProgress2: LiveData<Int> get() = _incrementProgress2

    private val _buttonStrat2 = MutableLiveData<Boolean>(true)
    val buttonStart2: LiveData<Boolean> get() = _buttonStrat2
    fun setEstatStart2 (buttonStart2 : Boolean){
        _buttonStrat2.value = buttonStart2
    }

    private val _buttonPauseResume2 = MutableLiveData<Boolean>(false)
    val buttonPauseResume2: LiveData<Boolean> get() = _buttonPauseResume2
    fun setEstatPauseResume2 (buttonPauseResume2 : Boolean){
        _buttonPauseResume2.value = buttonPauseResume2
    }

    private val _buttonStop2 = MutableLiveData<Boolean>(false)
    val buttonStop2: LiveData<Boolean> get() = _buttonStop2
    fun setEstatStop2 (buttonStop2 : Boolean){
        _buttonStop2.value = buttonStop2
    }


    var job: Job? = null
    var job2: Job? = null


    fun start() {
        _estat.value = 0
        _progressStart.value = 0
        job = viewModelScope.launch {
            for(i in _progressStart.value!!.._progressMax.value!!){
                delay((_jobTime.value!! / _progressMax.value!!).toLong())
                _incrementProgress.value = i
            }
        }
    }

    fun resume() {
        _progressStart.value = _incrementProgress.value
        _estat.value = 0

        job = viewModelScope.launch {
            for(i in _progressStart.value!!.._progressMax.value!!){
                delay((_jobTime.value!! / _progressMax.value!!).toLong())
                _incrementProgress.value = i
            }
        }
    }

    fun pause(){
        job?.cancel()
        _estat.value = 1
    }

    fun stop(){
        job?.cancel()
        _incrementProgress.value = 0
    }



    fun start2() {
        _estat2.value = 0
        _progressStart2.value = 0
        job2 = viewModelScope.launch {
            for(i in _progressStart2.value!!.._progressMax2.value!!){
                delay((_jobTime.value!! / _progressMax2.value!!).toLong())
                _incrementProgress2.value = i
            }
        }
    }

    fun resume2() {
        _progressStart2.value = _incrementProgress2.value
        _estat2.value = 0

        job2 = viewModelScope.launch {
            for(i in _progressStart2.value!!.._progressMax2.value!!){
                delay((_jobTime.value!! / _progressMax2.value!!).toLong())
                _incrementProgress2.value = i
            }
        }
    }

    fun pause2(){
        job2?.cancel()
        _estat2.value = 1
    }

    fun stop2(){
        job2?.cancel()
        _incrementProgress2.value = 0
    }
}