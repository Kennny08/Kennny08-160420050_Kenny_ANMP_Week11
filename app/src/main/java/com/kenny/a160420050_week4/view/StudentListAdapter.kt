package com.kenny.a160420050_week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavInflater
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kenny.a160420050_week4.R
import com.kenny.a160420050_week4.model.Student
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studentlist:ArrayList<Student>): RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {
    class StudentViewHolder(var view:View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return  StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val txtID = holder.view.findViewById<TextView>(R.id.txtID)
        val txtName = holder.view.findViewById<TextView>(R.id.txtName)
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)

        txtID.text = studentlist[position].id
        txtName.text = studentlist[position].name

        btnDetail.setOnClickListener{
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return studentlist.size
    }

    fun updateStudentList(newStudentList: ArrayList<Student>){
        studentlist.clear()
        studentlist.addAll(newStudentList)
        notifyDataSetChanged()
    }
}