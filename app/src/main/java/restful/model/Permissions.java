package restful.model;

/**
 * Created by CodeKenn on 25/01/2017.
 */

public class Permissions {

    private boolean pull;
    private boolean push;
    private boolean admin;

    public boolean isPull() {
        return pull;
    }

    public void setPull(boolean pull) {
        this.pull = pull;
    }

    public boolean isPush() {
        return push;
    }

    public void setPush(boolean push) {
        this.push = push;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}
