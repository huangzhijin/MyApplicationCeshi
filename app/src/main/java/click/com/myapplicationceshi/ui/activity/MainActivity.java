package click.com.myapplicationceshi.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import click.com.myapplicationceshi.AppComponent;
import click.com.myapplicationceshi.R;

public class MainActivity extends BaseActivity {

    @BindView(R.id.showButton)
    Button showButton;

    @OnClick(R.id.showButton)
    public void onShowRepositoriesClick() {
        startActivity(new Intent(this, ListActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }


}
