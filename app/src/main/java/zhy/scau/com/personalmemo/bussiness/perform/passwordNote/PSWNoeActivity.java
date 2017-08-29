package zhy.scau.com.personalmemo.bussiness.perform.passwordNote;

import android.os.Bundle;

import zhy.scau.com.personalmemo.R;
import zhy.scau.com.personalmemo.bussiness.perform.passwordNote.view.PSWNoteView;
import zhy.scau.com.personalmemo.core.base.perform.XJBaseActivity;


public class PSWNoeActivity extends XJBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pswnoe);
        getDelegateManager().addItems(new PSWNoteView(this));

    }
}
