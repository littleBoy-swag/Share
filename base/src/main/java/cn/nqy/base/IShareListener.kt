package cn.nqy.base

import java.lang.Exception

interface IShareListener {

    fun onShareStart()

    fun onShareSuccess()

    fun onShareCancel()

    fun onShareError(e: Exception)

}