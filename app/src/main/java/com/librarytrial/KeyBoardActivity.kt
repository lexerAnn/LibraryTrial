package com.librarytrial

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.SparseArray
import android.view.View
import com.librarytrial.databinding.ActivityMainBinding

class KeyBoardActivity(): AppCompatActivity(),View.OnClickListener{

    open class Builder(baseActivity: Activity) {
        init {
          baseActivity.baseContext.gotoActivity<KeyBoardActivity>()
        }
    }

    companion object {
        fun Builder(activity: Activity){
            activity.gotoActivity<KeyBoardActivity>()
        }
    }

    private var keyValues = SparseArray<String>()
    var code = StringBuffer()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(Build.VERSION.SDK_INT >= 21){
            binding.pinEditInput.showSoftInputOnFocus = false
        } else if ( Build.VERSION.SDK_INT >= 11){
            binding.pinEditInput.setRawInputType(InputType.TYPE_CLASS_TEXT)
            binding.pinEditInput.setTextIsSelectable(true)
        } else {
            binding.pinEditInput.setRawInputType(InputType.TYPE_NULL)
            binding.pinEditInput.setTextIsSelectable(true)
        }
        binding.button1.setOnClickListener(this)
        keyValues.apply {
            put(R.id.button1, "1")
        }
    }

    override fun onClick(p0: View?) {
        val value: String = keyValues.get(p0!!.id)
        code.append(value)
        binding.pinEditInput.setText(code)
    }

//     open class Builder(activity: Activity){
//       init {
//           activity.baseContext.gotoActivity<Activity>()
//       }
//    }

}