package com.example.openweatherapiexercise.util

import android.util.Log
import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import retrofit2.Response

class NeedOnFailure<T>(val single: Single<Response<T>>, val onSuccess: (T) -> Unit)

fun <T> Single<Response<T>>.onSuccess(onSuccess: (T) -> Unit): NeedOnFailure<T> {
    return NeedOnFailure(this, onSuccess)
}

inline fun <T, reified U> NeedOnFailure<T>.onFailure(crossinline onFailure: (U?) -> Unit) {
    var disposable: Disposable? = null
    disposable = single.subscribe(
        {
            if (it.isSuccessful) {
                onSuccess(it.body()!!)
            } else {
                onFailure(Gson().fromJson(it.errorBody()!!.string(), U::class.java))
            }
            disposable?.dispose()
        },
        {
            Log.e("API_ERROR", it.message.toString())
            onFailure(null)
            disposable?.dispose()
        }
    )
}
