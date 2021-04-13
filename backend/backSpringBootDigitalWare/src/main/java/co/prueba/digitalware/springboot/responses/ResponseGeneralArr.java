package co.prueba.digitalware.springboot.responses;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseGeneralArr {
    private Integer responseCode;
    private Integer status;
    private List<String> responseDescription;
    private String timestamp;

    public ResponseGeneralArr() {
    }

    public ResponseGeneralArr(Integer responseCode, List<String> responseDescription) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public List<String> getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(List<String> responseDescription) {
        this.responseDescription = responseDescription;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTimestamp() {
        return LocalDateTime.now().toString();
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


}
