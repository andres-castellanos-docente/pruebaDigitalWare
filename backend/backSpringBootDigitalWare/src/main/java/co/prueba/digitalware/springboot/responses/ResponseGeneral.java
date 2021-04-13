package co.prueba.digitalware.springboot.responses;

import java.time.LocalDateTime;

public class ResponseGeneral {
    private Integer responseCode;
    private Integer status;
    private String responseDescription;
    private String timestamp;

    public ResponseGeneral() {
    }

    public ResponseGeneral(Integer responseCode, String responseDescription) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
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
