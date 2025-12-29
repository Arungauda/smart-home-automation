package user;

import java.util.Objects;

public abstract class User {
  protected String id;
  protected  String name;

  public User(String id , String name ){
      this.id = id;
      this.name = name;
  }

  public abstract String getRole();

  public String getId(){
      return id;
  }
  public String getName(){
      return name;
  }

    @Override
    public int hashCode() {
        return name.hashCode() + id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(id , user.id) && Objects.equals(name , user.name);
    }

}
