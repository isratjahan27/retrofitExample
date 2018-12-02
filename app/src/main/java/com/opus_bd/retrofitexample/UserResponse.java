
package com.opus_bd.retrofitexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

;

public class UserResponse implements Serializable {

    private final static long serialVersionUID = 2170091741045683150L;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("token")
    @Expose
    private String token;

    /**
     * No args constructor for use in serialization
     */
    public UserResponse() {
    }

    /**
     * @param token
     * @param user
     */
    public UserResponse(User user, String token) {
        super();
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
