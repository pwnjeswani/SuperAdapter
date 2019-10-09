package com.pawanjeswani.superadaper

import android.view.View
import android.widget.TextView
import com.pawanjeswani.superrvadapter.SuperViewHolder
import com.pawanjeswani.superrvadapter.SuperAdapter
import com.pawanjeswani.superrvadapter.model.DummyObject


class UserAdapter :
    SuperAdapter<User, UserAdapter.UserViewHolder, Ads, UserAdapter.AdViewHolder>() {

    override fun onBindOtherViewHolder(holder: AdViewHolder, data: Ads) {
        holder.bind(data)
    }

    override fun onBindRealViewHolder(holder: UserViewHolder, data: User) {
        holder.bind(data)
    }

    override fun onCreateViewHolderBetweenElements(view: View): AdViewHolder = AdViewHolder(view)

    override fun onCreateRealViewHolder(view: View): UserViewHolder = UserViewHolder(view)

    override val realViewItemResLayout: Int
        get() = R.layout.user_item_view

    override val itemBetweenElementsResLayout: Int
        get() = R.layout.ad_item_view


    fun setUserList(userList: ArrayList<User>) {
        super.setBaseList(userList)
        notifyDataSetChanged()

    }


    override fun createOtherItemList() {
        this.addDataToPosition(position = 1, data = Ads("Test"))
        this.addDataToPosition(position = 3, data = Ads("Test with position 3"))
        this.addDataToPosition(position = 5, data = Ads("Test with position 5"))
        this.addDataToPosition(position = 7, data = Ads("Test with position 7"))
    }


    class UserViewHolder(itemView: View) : SuperViewHolder<User>(itemView) {

        internal var tv_user_name: TextView = itemView.findViewById(R.id.tv_user_name)
        internal var tv_user_id: TextView = itemView.findViewById(R.id.tv_user_id)
        internal var tv_user_phone: TextView = itemView.findViewById(R.id.tv_phone_no)

        override fun bind(data: User) {
            tv_user_id.text = data.id.toString()
            tv_user_name.text = data.name
            tv_user_phone.text = data.phoneNo.toString()

        }


    }

    class AdViewHolder(itemView: View) : SuperViewHolder<Ads>(itemView) {
        internal var tv_user_id: TextView = itemView.findViewById(R.id.tv_user_id)

        override fun bind(data: Ads) {
            tv_user_id.text = data.name
        }

    }

}