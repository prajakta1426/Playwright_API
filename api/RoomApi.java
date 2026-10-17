package api;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.RequestOptions;
import config.TestConfig;
import data.RoomExistingData;

public final class RoomApi {
    private final Page page;

    public RoomApi (Page page)
    {
        this.page=page;
    }

    private APIRequestContext api(){
        return this.page.request();
    }

    private RequestOptions json(String body){
        return RequestOptions.create().setHeader("Content-Type", "application/json").setData(body);
    }

    public APIResponse createRoom(RoomExistingData roomExistingData){
        return api().post(TestConfig.BASE_URL +"/api/room", json(roomExistingData.toJson()));
    }

}
