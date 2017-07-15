package viewModal;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Argha on 7/15/2017.
 */

public class BaseResponse {

    @SerializedName("session")
    @Expose
    private Object session;
    @SerializedName("redirect_to")
    @Expose
    private Object redirectTo;
    @SerializedName("message")
    @Expose
    private Object message;
    @SerializedName("result")
    @Expose
    private LocationInfoResonse result;

    public Object getSession() {
        return session;
    }

    public void setSession(Object session) {
        this.session = session;
    }

    public Object getRedirectTo() {
        return redirectTo;
    }

    public void setRedirectTo(Object redirectTo) {
        this.redirectTo = redirectTo;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public LocationInfoResonse getResult() {
        return result;
    }

    public void setResult(LocationInfoResonse result) {
        this.result = result;
    }

}
