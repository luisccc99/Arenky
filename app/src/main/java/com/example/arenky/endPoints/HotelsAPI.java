package com.example.arenky.endPoints;

import Hotels.SearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface HotelsAPI {

    @Headers({
            "x-rapidapi-host: hotels4.p.rapidapi.com",
            "x-rapidapi-key: ff019da863mshf678ee125e33941p171d1ejsn8d4b56a328e5",
            "useQueryString: true"})
    @GET("/locations/search")
    Call<SearchResponse> getSuggestions(@Query("locale") String locale, @Query("query")
            String query);


}
