package io.turntabl.Polls.models;

public class UserTO {
  private String creator_id;
  private String creator_email;
  private String creator_name;

  public UserTO() {}

  public UserTO(String creator_id, String creator_email, String creator_name) {
    this.creator_id = creator_id;
    this.creator_email = creator_email;
    this.creator_name = creator_name;
  }

  public String getCreator_id() {
    return creator_id;
  }

  public void setCreator_id(String creator_id) {
    this.creator_id = creator_id;
  }

  public String getCreator_email() {
    return creator_email;
  }

  public void setCreator_email(String creator_email) {
    this.creator_email = creator_email;
  }

  public String getCreator_name() {
    return creator_name;
  }

  public void setCreator_name(String creator_name) {
    this.creator_name = creator_name;
  }

  @Override
  public String toString() {
    return (
      "UserTO{" +
      "creator_id=" +
      creator_id +
      ", creator_email='" +
      creator_email +
      '\'' +
      ", creator_name='" +
      creator_name +
      '\'' +
      '}'
    );
  }
}
