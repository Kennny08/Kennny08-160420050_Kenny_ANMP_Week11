package com.kenny.a160420050_week4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kenny.a160420050_week4.model.Student

class DetailViewModel:ViewModel() {
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val studentLD = MutableLiveData<Student>()

    fun fetch() {

        studentLoadErrorLD.value = false
        loadingLD.value = false

        val student1 = Student("16055","Nonie","1998/03/28","5718444778",
            "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        studentLD.value = student1
    }
}
