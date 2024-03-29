package com.example.meowsocial.login.data.adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.example.meowsocial.R
import com.example.meowsocial.base.common.LoadRandomImageFromAssets
import com.example.meowsocial.dashboard.data.AlbumItem

class AlbumAdapter(private val getContext: Context,
                   private val AlbumItems: ArrayList<AlbumItem>)
    : ArrayAdapter<AlbumItem>(getContext, 0, AlbumItems){

    override fun areAllItemsEnabled(): Boolean {
        return true
    }

    override fun isEnabled(arg0: Int): Boolean {
        return true
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listLayout = convertView
        var holder = ViewAlbumItem()
        if(listLayout == null) {

            val inflateList = (context as Activity).layoutInflater
            listLayout = inflateList.inflate(R.layout.test_album_layout, parent, false)
            holder.leftImage = listLayout.findViewById(R.id.first)
            holder.rightImage = listLayout.findViewById(R.id.second)
        }
        else {
            holder = listLayout.getTag() as ViewAlbumItem
        }
        LoadRandomImageFromAssets(holder.leftImage!!, context).loadImage()
        LoadRandomImageFromAssets(holder.rightImage!!, context).loadImage()
        return listLayout!!
    }
}


class ViewAlbumItem
{
    internal var leftImage: ImageView? = null
    internal var rightImage: ImageView? = null
}