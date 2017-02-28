package click.com.myapplicationceshi;

import android.app.Application;

/**
 * Created by Administrator on 2017/2/23 0023.
 */

public class AppApplication extends Application{

    private static AppApplication sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        this.sInstance = this;
        setupCompoent();
    }

    private void setupCompoent(){
//        appComponent = DaggerAppComponent.builder().githubApiModule(new GithubApiModule())
//                .appModule(new AppModule(this))
//                .build();
    }

    public static AppApplication getsInstance(){
        return sInstance;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}