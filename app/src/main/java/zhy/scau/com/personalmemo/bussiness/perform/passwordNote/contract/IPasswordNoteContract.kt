package zhy.scau.com.personalmemo.bussiness.perform.passwordNote.contract

import zhy.scau.com.personalmemo.core.mvp.common.contract.ICommonContract

/**
 * Created by ZhengHy on 2017-08-02.
 */
interface IPasswordNoteContract : ICommonContract{

    interface IPasswordNoteView : ICommonContract.ICommonView{

        fun performInitAnim(maxNum : Int , curNum : Int)

        fun performAnim(curNum : Int)


    }

    interface IPasswordNotePresenter : ICommonContract.ICommonPresenter{

        /**
         * 跳转添加密码页面
         */
        fun addPassword();

        fun testPassword(passClss:String, password:String);
    }


}