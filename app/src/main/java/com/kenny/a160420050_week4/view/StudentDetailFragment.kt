package com.kenny.a160420050_week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.kenny.a160420050_week4.R
import com.kenny.a160420050_week4.util.loadImage
import com.kenny.a160420050_week4.viewmodel.DetailViewModel
import com.kenny.a160420050_week4.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.student_list_item.*


class StudentDetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        if(arguments != null) {
            val studentId =
                StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
            viewModel.fetch(studentId)
        }


        observeViewModel(view)
    }

    fun observeViewModel(view: View){
        val txtName = view.findViewById<TextInputEditText>(R.id.txtName)
        val txtID = view.findViewById<TextInputEditText>(R.id.txtID)
        val txtBod = view.findViewById<TextInputEditText>(R.id.txtBod)
        val txtPhone = view.findViewById<TextInputEditText>(R.id.txtPhone)
        val imgViewDetailStudent = view.findViewById<ImageView>(R.id.imgViewDetailStudent)
        val progressBarDetailStudent = view.findViewById<ProgressBar>(R.id.progressBarDetailStudent)

        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            txtID.setText(it.id)
            txtName.setText(it.name)
            txtBod.setText(it.dob)
            txtPhone.setText(it.phone)
            imgViewDetailStudent.loadImage(it.photoUrl, progressBarDetailStudent)
        })
    }




}