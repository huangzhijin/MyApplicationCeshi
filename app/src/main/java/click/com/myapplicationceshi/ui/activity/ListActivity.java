package click.com.myapplicationceshi.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import click.com.myapplicationceshi.AppComponent;
import click.com.myapplicationceshi.R;
import click.com.myapplicationceshi.data.GithubApiService;
import click.com.myapplicationceshi.data.entity.Repo;
import click.com.myapplicationceshi.ui.adapter.ListAdapter;
import click.com.myapplicationceshi.uilts.SimpleObserver;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/2/23 0023.
 */
public class ListActivity extends BaseActivity{
    @BindView(R.id.repos_rv_list)
    RecyclerView mRvList;

    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;


    @Inject
    GithubApiService githubApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    @Override
    public int getLayoutId(){
        return R.layout.list_activity;
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent){
        appComponent.inject(this);
    }


    private void initView(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvList.setLayoutManager(manager);

        ListAdapter adapter = new ListAdapter();
        mRvList.setAdapter(adapter);
        loadData(adapter);
    }

    private void loadData(final ListAdapter adapter){
        showLoading(true);
        githubApiService.getRepoData(getUser())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleObserver<ArrayList<Repo>>() {
                    @Override
                    public void onNext(ArrayList<Repo> repos) {
                        showLoading(false);
                        adapter.setRepos(repos);
                    }
                    @Override
                    public void onError(Throwable e){
                        showLoading(false);
                    }
                });
    }

    private String getUser(){
        return "bird1015";
    }

    public void showLoading(boolean loading) {
        Log.i("info",loading + " Repos");
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

}