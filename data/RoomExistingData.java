package data;

import java.util.UUID;

public class RoomExistingData {
    private final String roomName = UUID.randomUUID().toString().substring(0,8);
    private final String type = "Suite";
    private final boolean accessible = true;
    private final String description = "This is room for PC08 members only";
    private final String image = "https://example.com/existing-room.jpg";
    private final int roomPrice = 200;
    private final String[] features = {"WiFi", "TV"};

    public RoomExistingData() {
    }

    public String getRoomName() {
        return roomName;
    }

    public String toJson() {
        String featureList = "\""+String.join("\",\"", features)+"\"";
        return "{"
                + "\"roomName\":\"" + roomName + "\","
                + "\"type\":\"" + type + "\","
                + "\"accessible\":" + accessible + ","
                + "\"description\":\"" + description + "\","
                + "\"image\":\"" + image + "\","
                + "\"roomPrice\":" + roomPrice + ","
                + "\"features\":[" + featureList + "]"
                + "}";
    }
}