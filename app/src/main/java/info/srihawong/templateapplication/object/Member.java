package info.srihawong.templateapplication.object;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by demo on 18/9/2557.
 */
public class Member {
    int member_id;
    String email,nickname,avatar,username,firstname,lastname;

    public Member() {
    }
    @Override
    public String toString() {
        return "{" +
                "member_id=" + member_id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public Member(JSONObject member) {
        try {
            this.member_id = member.getInt("member_id");
            this.email = member.getString("email");
            this.nickname = member.getString("nickname");
            this.avatar = member.getString("avatar");
            this.username = member.getString("username");
            this.firstname = member.getString("firstname");
            this.lastname = member.getString("lastname");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
