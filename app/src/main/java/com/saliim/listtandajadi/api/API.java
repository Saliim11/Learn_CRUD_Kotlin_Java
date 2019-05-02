package com.saliim.listtandajadi.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.saliim.listtandajadi.model.DataTandaJadi;
import com.saliim.listtandajadi.model.InsertTandaJadi;
import com.saliim.listtandajadi.model.UpdateTandaJadi;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class API {

    static Retrofit retrofit;
    public static String baseURL = "http://192.168.18.84/";

    public static Retrofit getInstance() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build();

            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL + "master/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }

    public static Call<InsertTandaJadi> addTandaJadi(String tanda_jadi, String create_by) {
        SupervisiService service = getInstance().create(SupervisiService.class);
        return service.addTandaJadi(tanda_jadi, create_by);
    }

    public static Call<ArrayList<DataTandaJadi>> getDataTandaJadi() {
        SupervisiService service = getInstance().create(SupervisiService.class);
        return service.getDataTandaJadi();
    }

    public static Call<ResponseBody> deleteTandaJadi(String id){
        SupervisiService service = getInstance().create(SupervisiService.class);
        return service.deleteTandaJadi(id);
    }

    public static Call<UpdateTandaJadi> editTandaJadi(String id, String tanda_jadi, String mod_by) {
        SupervisiService service = getInstance().create(SupervisiService.class);
        return service.editTandaJadi(id, tanda_jadi, mod_by);
    }

    public interface SupervisiService {

        @FormUrlEncoded
        @POST("insert_tanda_jadi.php")
        Call<InsertTandaJadi> addTandaJadi(
                @Field("tanda_jadi") String  tanda_jadi,
                @Field("create_by") String create_by);

        @GET("get_tanda_jadi.php")
        Call<ArrayList<DataTandaJadi>> getDataTandaJadi();

        @DELETE("delete_tanda_jadi.php")
        Call<ResponseBody> deleteTandaJadi(
                @Query("id") String id);

        @FormUrlEncoded
        @POST("update_tanda_jadi.php")
        Call<UpdateTandaJadi> editTandaJadi(
                @Field("id") String id,
                @Field("tanda_jadi") String tanda_jadi,
                @Field("mod_by") String mod_by);

    }
}
