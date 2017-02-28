package click.com.myapplicationceshi;

import click.com.myapplicationceshi.data.GithubApiModule;
import click.com.myapplicationceshi.ui.activity.ListActivity;
import dagger.Component;

/**
 * Created by Administrator on 2017/2/23 0023.
 */

@Component(modules = { AppModule.class, GithubApiModule.class})
public interface AppComponent {
    // inject what
    void inject(ListActivity activity);
}