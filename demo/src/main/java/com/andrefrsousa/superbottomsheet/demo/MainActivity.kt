
package com.andrefrsousa.superbottomsheet.demo

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.andrefrsousa.superbottomsheet.SuperBottomSheetFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sheet = DemoBottomSheetFragment()
        show_sheet.setOnClickListener {
            sheet.show(supportFragmentManager, "DemoBottomSheetFragment")
        }
    }
}

class DemoBottomSheetFragment : SuperBottomSheetFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_demo_sheet, container, false)
    }

    override fun getCornerRadius() = context!!.resources.getDimension(R.dimen.demo_sheet_rounded_corner)

    override fun getStatusBarColor() = Color.RED
    override fun getPeekHeight(): Int {
        return 400
    }

    override fun changeState(state: Int) {
        super.changeState(state)
        Toast.makeText(context, "BOTTOM_SHEET_STATE = $state", Toast.LENGTH_LONG).show()
    }
}
