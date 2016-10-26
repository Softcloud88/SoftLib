package data;

/**
 * Created by Softcloud on 16/8/28.
 */
public class Person extends BaseData {
    private String id;
    private Image avatars;
    private String alt;
    private String name;

    public String getId() {
        return id != null ? id : "";
    }

    public Image getAvatars() {
        return avatars != null ? avatars : new Image();
    }

    public String getAlt() {
        return alt != null ? alt : "";
    }

    public String getName() {
        return name != null ? name : "--";
    }
}
