package sheetdb;

import okhttp3.*;

import java.io.IOException;

public class SheetDB {

    public static final String API = "https://sheetdb.io/api/v1/c2jr1lhst5mf0";

    public static void main(String[] args) {
        new SheetDB().getAllData();
    }

    private void getAllData() {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    System.out.println(response.body().string());
                }
            }
        });
    }
}
