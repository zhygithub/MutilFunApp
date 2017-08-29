package zhy.scau.com.personalmemo.bussiness.perform.passwordNote.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import zhy.scau.com.personalmemo.R
import zhy.scau.com.personalmemo.bussiness.perform.passwordNote.contract.IPasswordNoteContract
import zhy.scau.com.personalmemo.bussiness.perform.passwordNote.presenter.PSWNotePresenter
import zhy.scau.com.personalmemo.bussiness.perform.widget.chart.TachographView
import zhy.scau.com.personalmemo.core.mvp.IHostControl
import zhy.scau.com.personalmemo.core.mvp.common.presenter.CommonPresenter
import zhy.scau.com.personalmemo.core.mvp.common.view.CommonView

/**
 * Created by ZhengHy on 2017-08-20.
 */
class PSWNoteView(control : IHostControl) : CommonView<IPasswordNoteContract.IPasswordNotePresenter>(control), IPasswordNoteContract.IPasswordNoteView {

    lateinit var mTachView : TachographView

    lateinit var mEdtPassWord : EditText

    lateinit var mBtnTest : Button

    override fun onCreate(savedInstanceState: Bundle?, root: View?) {
        super.onCreate(savedInstanceState, root)

        mTachView = root?.findViewById(R.id.tachview_try_count) as TachographView

        mEdtPassWord = root?.findViewById(R.id.edt_pswnote_password_input) as EditText

        mBtnTest = root?.findViewById(R.id.btn_confirm_password) as Button

        mBtnTest.setOnClickListener {
            view ->
                presenter.testPassword("test",mEdtPassWord.text.toString())

        }

    }

    override fun performInitAnim(maxNum: Int, curNum: Int) {
        mTachView.setMaxNum(maxNum)
        mTachView.setCurNum(curNum)
    }

    override fun performAnim(curNum: Int) {
        mTachView.setCurNum(curNum)
    }

    override fun init(): CommonPresenter<*> {
        return PSWNotePresenter(hostControl, this)
    }




}