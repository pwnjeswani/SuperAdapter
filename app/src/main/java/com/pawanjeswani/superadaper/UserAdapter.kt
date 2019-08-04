package com.pawanjeswani.superadaper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pawanjeswani.superrvadapter.SuperAdapter


class UserAdapter : SuperAdapter {

    constructor(context: Context){
        createOtherItemList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item_view, parent, false)
                return UserViewHolder(view)

            }
            1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.ad_item_view, parent, false)
                return AdViewHolder(view)
            }
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item_view, parent, false)
        return UserViewHolder(view)
    }

    fun setUserList(userList: ArrayList<User>) {
        super.setBaseList(userList)
        notifyDataSetChanged()

    }

    override fun getItemViewType(position: Int): Int {
        val itemViewType = super.getItemViewType(position)
        return if (itemViewType != -1) {
            itemViewType
        } else {
            0
        }
    }

    override fun createOtherItemList() {
        var dummyObject = DummyObject(1, 1)
        var dummyObject2 = DummyObject(1, 3)
        var dummyObject3 = DummyObject(1, 5)
        var dummyObject4 = DummyObject(1, 7)
        super.otherViewPositions.add(dummyObject)
        super.otherViewPositions.add(dummyObject2)
        super.otherViewPositions.add(dummyObject3)
        super.otherViewPositions.add(dummyObject4)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> {
                val holderr = holder as UserViewHolder
                var user = super.baseList[position] as User
                holderr.tv_user_id.text = user.id.toString()
                holderr.tv_user_name.text = user.name
                holderr.tv_user_phone.text = user.phoneNo.toString()

            }
            1 -> {

            }
        }
    }


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tv_user_name: TextView = itemView.findViewById(R.id.tv_user_name)
        internal var tv_user_id: TextView = itemView.findViewById(R.id.tv_user_id)
        internal var tv_user_phone: TextView = itemView.findViewById(R.id.tv_phone_no)

    }

    class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_user_id: TextView = itemView.findViewById(R.id.tv_user_id)
    }

}