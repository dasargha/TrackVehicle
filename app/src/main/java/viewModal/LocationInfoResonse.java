package viewModal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Argha on 7/15/2017.
 */

public class LocationInfoResonse {
    @SerializedName("entry_id")
    @Expose
    private String entryId;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("message_id")
    @Expose
    private String messageId;
    @SerializedName("utc_time_stamp")
    @Expose
    private String utcTimeStamp;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("altitude")
    @Expose
    private String altitude;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUtcTimeStamp() {
        return utcTimeStamp;
    }

    public void setUtcTimeStamp(String utcTimeStamp) {
        this.utcTimeStamp = utcTimeStamp;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
