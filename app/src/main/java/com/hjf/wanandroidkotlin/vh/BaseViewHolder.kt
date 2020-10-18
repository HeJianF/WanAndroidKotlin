package com.hjf.wanandroidkotlin.vh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife

/**
 * @author heJianfeng
 * @date 2018/12/14
 */
abstract class BaseViewHolder<E> : RecyclerView.ViewHolder {
    var mListener: View.OnClickListener? = null

    constructor(itemView: View) : super(itemView) {
        ButterKnife.bind(this, itemView)
    }

    @JvmOverloads
    constructor(
        @LayoutRes layoutId: Int,
        parent: ViewGroup,
        listener: View.OnClickListener? = null,
        allClick: Boolean = true
    ) : super(LayoutInflater.from(parent.context).inflate(layoutId, parent, false)) {
        ButterKnife.bind(this, itemView)
        if (listener != null) {
            mListener = listener
            if (allClick) {
                itemView.setOnClickListener(listener)
            }
        }
    }

    /**
     * 绑定数据
     *
     * @param data
     */
    abstract fun bind(data: E, position: Int)
}