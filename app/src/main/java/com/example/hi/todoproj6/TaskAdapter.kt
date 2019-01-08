package com.example.hi.todoproj6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class TaskAdapter(context: Context, taskList: MutableList<Task>) : BaseAdapter() {

    private val _inflater: LayoutInflater = LayoutInflater.from(context)
    private var _taskList = taskList
    private var _rowListener: TaskRowListener = context as TaskRowListener

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val objectId = _taskList.get(position).objectId as String
        val itemText = _taskList.get(position).taskDesc as String
        val done = _taskList.get(position).done as Boolean
        val taskDetails = _taskList.get(position).taskDetails as String
        var duedateIn = _taskList.get(position).taskDueDate as String

        val view: View
        val listRowHolder: ListRowHolder

        if (convertView == null) {
            view = _inflater.inflate(R.layout.task_rows, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }

        listRowHolder.desc.text = itemText
        //listRowHolder.done.isChecked = done

        if (duedateIn == "") {
            duedateIn = "---"
        }
        duedateIn = "Due: " + duedateIn
        listRowHolder.duedate.text = duedateIn



        //listRowHolder.editTask.setOnClickListener {
        //    _rowListener.editItemDialog(objectId, itemText)
        //}

        //listRowHolder.done.setOnClickListener {
            //_rowListener.onTaskChange(objectId, !done) }

        //listRowHolder.remove.setOnClickListener {
        //    _rowListener.onTaskDelete(objectId)
      //      _taskList.clear()

      //      notifyDataSetChanged()
        //}

        return view
    }


    override fun getItem(index: Int): Any {
        return _taskList.get(index)
    }

    override fun getItemId(index: Int): Long {
        return index.toLong()
    }

    override fun getCount(): Int {
        return _taskList.size
    }

    private class ListRowHolder(row: View?) {
        val desc: TextView = row!!.findViewById(R.id.txtTaskDesc) as TextView
        //val done: CheckBox = row!!.findViewById(R.id.chkDone) as CheckBox
        //val remove: ImageButton = row!!.findViewById(R.id.btnRemove) as ImageButton
        //val editTask: Button = row!!.findViewById(R.id.buEdit) as Button
        val duedate: TextView = row!!.findViewById(R.id.dueDateText) as TextView
        //val itemRow: Button = row!!.findViewById(R.id.itemRow) as Button

    }
}