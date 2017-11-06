import java.util.List;
import java.util.UUID;

public class UserGroup {

    private UUID groupId;
    private String name;
    private List<User> users;
    private List<UserGroup> userGroups;

    public UserGroup(UUID groupId) {
        this.groupId = UUID.randomUUID();
    }

    public UserGroup(UUID groupId, String name, List<User> users, List<UserGroup> userGroups) {
        this.groupId = groupId;
        this.name = name;
        this.users = users;
        this.userGroups = userGroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "groupId=" + groupId +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", userGroups=" + userGroups +
                '}';
    }
}
