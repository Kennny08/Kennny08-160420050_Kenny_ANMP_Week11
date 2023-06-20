package com.kenny.a160420050_week4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.kenny.a160420050_week4.R
import com.kenny.a160420050_week4.databinding.FragmentStudentDetailBinding
import com.kenny.a160420050_week4.model.Student
import com.kenny.a160420050_week4.util.loadImage
import com.kenny.a160420050_week4.viewmodel.DetailViewModel
import com.kenny.a160420050_week4.viewmodel.ListViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.student_list_item.*
import java.util.concurrent.TimeUnit


class StudentDetailFragment : Fragment(), ButtonUpdateStudentClickListener, ButtonSendNotificationClickListener {

    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(
            inflater,
            R.layout.fragment_student_detail,
            container,
            false)

        return  dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.listenerNotification = this
        dataBinding.listenerUpdate = this
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        if(arguments != null) {
            val studentId =
                StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
            viewModel.fetch(studentId)
        }


        observeViewModel(view)
    }

    fun observeViewModel(view: View){
//        val txtName = view.findViewById<TextInputEditText>(R.id.txtName)
//        val txtID = view.findViewById<TextInputEditText>(R.id.txtID)
//        val txtBod = view.findViewById<TextInputEditText>(R.id.txtBod)
//        val txtPhone = view.findViewById<TextInputEditText>(R.id.txtPhone)
//        val imgViewDetailStudent = view.findViewById<ImageView>(R.id.imgViewDetailStudent)
//        val progressBarDetailStudent = view.findViewById<ProgressBar>(R.id.progressBarDetailStudent)

        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
//            txtID.setText(it.id)
//            txtName.setText(it.name)
//            txtBod.setText(it.dob)
//            txtPhone.setText(it.phone)
//            imgViewDetailStudent.loadImage(it.photoUrl, progressBarDetailStudent)

            dataBinding.student = it
//            var student = it
//            btnNotif.setOnClickListener{
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        Log.d("Messages", "five seconds")
//                        MainActivity.showNotif(student.name.toString(),
//                            "A new notification created",
//                            R.drawable.ic_baseline_circle_24)
//
//                    }
//            }
        })
    }

    override fun onButtonSendNotifClick(v: View) {
        Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Log.d("Messages", "five seconds")
                        MainActivity.showNotif(dataBinding.student?.name.toString(),
                            "A new notification created",
                            R.drawable.ic_baseline_circle_24)

                    }
    }

    override fun onButtonUpdateStudentClick(v: View) {
        Toast.makeText(this.context, "Berhasil Update " + dataBinding.student?.name, Toast.LENGTH_SHORT).show()

    }


}