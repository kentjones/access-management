package me.webhop.apollo.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlRootElement(name = "error")
public class ErrorResponse {

    private int status;
    private int statusCode;
    private String property;
    private String message;
    private String developerMessage;
    private String moreInfo;

    public ErrorResponse(ErrorResponseBuilder builder)
    {
        setStatus(builder.status);
        setStatusCode(builder.statusCode);
        setProperty(builder.property);
        setMessage(builder.message);
        setDeveloperMessage(builder.developerMessage);
        setMoreInfo(builder.moreInfo);
    }

    public int getStatus() {
        return status;
    }

    private void setStatus(int status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    private void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getProperty() {
        return property;
    }

    private void setProperty(String property) {
        this.property = property;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    private void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    private void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("statue", status)
                .append("code", statusCode)
                .append("message", message)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ErrorResponse that = (ErrorResponse) o;

        return new EqualsBuilder().append(status, that.status).append(statusCode, that.statusCode).isEquals();
    }
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(status).append(statusCode).toHashCode();
    }
    public static class ErrorResponseBuilder {
        private int status;
        private int statusCode;
        private String property;
        private String message;
        private String developerMessage;
        private String moreInfo;

        public ErrorResponseBuilder(int status, String message){
            this.status = status;
            this.message = message;
        }
        public ErrorResponseBuilder setStatusCode(int statusCode)
        {
            this.statusCode = statusCode;
            return this;
        }
        public ErrorResponseBuilder setProperty(String property)
        {
            this.property = property;
            return this;
        }
        public ErrorResponseBuilder setDeveloperMessage(String developerMessage)
        {
            this.developerMessage = developerMessage;
            return this;
        }
        public ErrorResponseBuilder setMoreInfo(String moreInfo)
        {
            this.moreInfo = moreInfo;
            return this;
        }
        public ErrorResponse build(){
            return new ErrorResponse(this);
        }
    }
}
