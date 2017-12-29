package com.example.administrator.mytemplateapplication.module.user.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "users")
public class User {
    /** 刷新token值 */
    @ColumnInfo(name = "refreshToken")
    private String refreshToken;
    /** 用户名 */
    @ColumnInfo(name = "username")
    private String username;
    /** token */
    @ColumnInfo(name = "token")
    private String token;
    /** 用户ID */
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "userId")
    private String userId;
    /** 头像地址 */
    @ColumnInfo(name = "avatarPhoto")
    private String avatarPhoto;
    /** 隐藏用户名 */
    @ColumnInfo(name = "hideUserName")
    private String hideUserName;

    public String getAvatarPhoto() {
        return avatarPhoto;
    }

    public String getHideUserName() {
        return hideUserName;
    }

    public String getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAvatarPhoto(String avatarPhoto) {
        this.avatarPhoto = avatarPhoto;
    }

    public void setHideUserName(String hideUserName) {
        this.hideUserName = hideUserName;
    }

    public User(){}
    public User(@NonNull String userId){
        this.userId=userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "refreshToken='" + refreshToken + '\'' +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", userId='" + userId + '\'' +
                ", avatarPhoto='" + avatarPhoto + '\'' +
                ", hideUserName='" + hideUserName + '\'' +
                '}';
    }
}
