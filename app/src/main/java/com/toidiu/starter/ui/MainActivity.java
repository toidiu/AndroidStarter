package com.toidiu.starter.ui;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.edisonwang.ps.annotations.EventListener;
import com.edisonwang.ps.lib.PennStation;
import com.toidiu.starter.R;
import com.toidiu.starter.actions.TestAction;
import com.toidiu.starter.actions.TestActionEventFailure;
import com.toidiu.starter.actions.TestActionEventSuccess;
import com.toidiu.starter.actions.TestAction_.PsTestAction;

import butterknife.Bind;
import butterknife.ButterKnife;


@EventListener(producers = {
        TestAction.class
})
public class MainActivity extends BaseActivity {
    //region Fields----------------------
    @Bind(R.id.text)
    TextView textView;
    @Bind(R.id.progress)
    ProgressBar progress;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    //endregion

    //region EventListener----------------------
    MainActivityEventListener eventListener = new MainActivityEventListener() {
        @Override
        public void onEventMainThread(TestActionEventFailure event) {
            Toast.makeText(MainActivity.this, "handle failure", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onEventMainThread(TestActionEventSuccess event) {
            progress.setVisibility(View.GONE);
            textView.setText(R.string.description);
        }
    };
    //endregion

    //region LifeCycle----------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        PennStation.registerListener(eventListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        PennStation.unRegisterListener(eventListener);
    }
    //endregion

    //region Init----------------------
    private void initData() {
        PennStation.requestAction(PsTestAction.helper());
        progress.setVisibility(View.VISIBLE);
    }

    private void initViews() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "add an action", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
    //endregion

}