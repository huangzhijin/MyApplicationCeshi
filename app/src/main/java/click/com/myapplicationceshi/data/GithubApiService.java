package click.com.myapplicationceshi.data;

import java.util.ArrayList;

import click.com.myapplicationceshi.data.entity.Repo;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2017/2/23 0023.
 */

public interface GithubApiService {
    @GET("/users/{user}/repos")
    Observable<ArrayList<Repo>> getRepoData(@Path("user") String user);
}
