package zhy.scau.com.personalmemo.bussiness.perform.passwordNote.presenter

import android.os.Bundle
import android.view.View
import zhy.scau.com.personalmemo.bussiness.perform.passwordNote.contract.IPasswordNoteContract
import zhy.scau.com.personalmemo.core.mvp.IHostControl
import zhy.scau.com.personalmemo.core.mvp.common.presenter.CommonPresenter
import zhy.scau.com.personalmemo.core.mvp.common.view.CommonView

/**
 * Created by ZhengHy on 2017-08-20.
 */
class PSWNotePresenter(control: IHostControl, view: CommonView<IPasswordNoteContract.IPasswordNotePresenter> ) : CommonPresenter<IPasswordNoteContract.IPasswordNoteView>(control, view), IPasswordNoteContract.IPasswordNotePresenter {

    override fun onCreate(savedInstanceState: Bundle?, root: View?) {
        super.onCreate(savedInstanceState, root)
        view.performInitAnim(100,100)
    }

    override fun addPassword() {

    }

    override fun testPassword(passClss: String, password: String) {
        view.performAnim(15)
    }


}