package click.com.myapplicationceshi.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import click.com.myapplicationceshi.AppApplication;
import click.com.myapplicationceshi.AppComponent;

/**
 * Created by Administrator on 2017/2/23 0023.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setupActivityComponent(AppApplication.getsInstance().getAppComponent());
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);
    protected abstract int getLayoutId();

}