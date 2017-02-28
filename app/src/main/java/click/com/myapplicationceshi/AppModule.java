package click.com.myapplicationceshi;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/2/23 0023.
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application=application;
    }

    @Provides
    public Application provideApplication(){
        return application;
    }
}