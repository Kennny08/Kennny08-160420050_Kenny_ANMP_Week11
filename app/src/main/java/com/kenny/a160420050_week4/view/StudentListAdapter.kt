package com.kenny.a160420050_week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavInflater
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kenny.a160420050_week4.R
import com.kenny.a160420050_week4.databinding.StudentListItemBinding
import com.kenny.a160420050_week4.model.Student
import com.kenny.a160420050_week4.util.loadImage
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studentlist:ArrayList<Student>): RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener {
    class StudentViewHolder(var view:StudentListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)
        return  StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        holder.view.student = studentlist[position]
        holder.view.listener = this
//        val txtID = holder.view.findViewById<TextView>(R.id.txtID)
//        val txtName = holder.view.findViewById<TextView>(R.id.txtName)
//        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
//
//        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
//        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
//        imageView.loadImage(studentlist[position].photoUrl, progressBar)
//
//
//        txtID.text = studentlist[position].id
//        txtName.text = studentlist[position].name
//
//        btnDetail.setOnClickListener{
//            val action = StudentListFragmentDirections.actionStudentDetail(studentlist[position].id.toString())
//            Navigation.findNavController(it).navigate(action)
//        }

    }

    override fun getItemCount(): Int {
        return studentlist.size
    }

    fun updateStudentList(newStudentList: ArrayList<Student>){
        studentlist.clear()
        studentlist.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtondetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail((v.tag.toString()))
        Navigation.findNavController(v).navigate(action)
    }
}