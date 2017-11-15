package test.foxsports.foxsdk.network;

import com.google.gson.Gson;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import test.foxsports.foxsdk.network.api.FoxApi;
import test.foxsports.foxsdk.network.api.FoxApiUrl;

/**
 * Created by don.chummar on 15/11/17.
 */
public class NetworkModule {

    private static NetworkModule instance;
    private final Gson gson;
    private final FoxApi foxApi;

    private NetworkModule() {
        gson = new Gson();
        final Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(FoxApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        foxApi = builder.build().create(FoxApi.class);
    }

    public static NetworkModule singleton() {
        if (instance == null) {
            synchronized (NetworkModule.class) {
                if (instance == null) {
                    instance = new NetworkModule();
                }
            }
        }
        return instance;
    }

    public FoxApi getNetworkClient() {
        return foxApi;
    }

    public Gson getParserClient() {
        return gson;
    }
}
