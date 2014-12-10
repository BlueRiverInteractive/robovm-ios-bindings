
package org.robovm.bindings.facebook.manager.sample;

import java.util.List;

import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.uikit.UIAlertView;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewCellAccessoryType;
import org.robovm.apple.uikit.UITableViewCellStyle;
import org.robovm.apple.uikit.UITableViewController;
import org.robovm.bindings.facebook.manager.FacebookError;
import org.robovm.bindings.facebook.manager.FacebookLoginListener;
import org.robovm.bindings.facebook.manager.FacebookManager;
import org.robovm.bindings.facebook.manager.FacebookPermission;
import org.robovm.bindings.facebook.manager.request.CommonFacebookRequests;
import org.robovm.bindings.facebook.manager.request.GraphUser;

public class SampleViewController extends UITableViewController {
    private GraphUser me;
    private final UserInfoViewController userInfoViewController;
    private final UserSelectionViewController userSelectionViewController;

    public SampleViewController () {
        setTitle("Facebook Sample");

        userInfoViewController = new UserInfoViewController();
        userSelectionViewController = new UserSelectionViewController();
    }

    private void tapOnLoginButton () {
        if (FacebookManager.getInstance().isLoggedIn()) {
            FacebookManager.getInstance().logout();
            // Remove user data.
            me = null;

            // Update UI.
            getTableView().reloadData();
        } else {
            FacebookPermission[] permissions = new FacebookPermission[] {FacebookPermission.PUBLIC_PROFILE,
                FacebookPermission.USER_FRIENDS, FacebookPermission.EMAIL};
            FacebookManager.getInstance().login(permissions, true, new FacebookLoginListener() {
                @Override
                public void onSuccess (GraphUser result) {
                    // Login was successful!

                    // Store the user data.
                    me = result;

                    // Update UI.
                    getTableView().reloadData();
                }

                @Override
                public void onError (FacebookError error) {
                    // Check if we should notify the user.
                    if (error.shouldNotify()) {
                        // So let's alert the user.
                        alertError("Error during login!", error);
                    }
                }

                @Override
                public void onCancel () {
                    // User cancelled, so do nothing.
                }
            });
        }
    }

    /** Shows the cached user info. */
    private void tapOnUserInfoButton () {
        if (me != null) {
            userInfoViewController.setUser(me);
            getNavigationController().pushViewController(userInfoViewController, true);
        }
    }

    /** Request the users friends and shows them in a list. You could cache the friends and only show the data next time. */
    private void tapOnFriendsButton () {
        FacebookManager.getInstance().request(
            CommonFacebookRequests.requestFriends(new CommonFacebookRequests.FacebookFriendsRequestListener() {
                @Override
                public void onSuccess (List<GraphUser> friends) {
                    userSelectionViewController.setUsers(friends);
                    getNavigationController().pushViewController(userSelectionViewController, true);
                }

                @Override
                public void onError (FacebookError error) {
                    // Check if we should notify the user.
                    if (error.shouldNotify()) {
                        // So let's alert the user.
                        alertError("Error while getting a list of your friends!", error);
                    }
                }

                @Override
                public void onCancel () {
                }
            }));
    }

    /** Shows all permissions granted by the user in a list. */
    private void tapOnGrantedPermissionButton () {
        // TODO
    }

    /** First check if the user has granted the publish permission. If not request the permission. Finally display the feed dialog. */
    private void tapOnPublishFeedButton () {

        // TODO
    }

    private void alertError (String title, FacebookError error) {
        UIAlertView alert = new UIAlertView(title, error.getMessage(), null, "OK");
        alert.show();
    }

    @Override
    public void viewWillAppear (boolean animated) {
        getTableView().reloadData();
    }

    @Override
    public long getNumberOfSections (UITableView tableView) {
        return FacebookManager.getInstance().isLoggedIn() ? 2 : 1;
    }

    @Override
    public String getTitleForHeader (UITableView tableView, long section) {
        switch ((int)section) {
        case 0:
            return "Sample";
        default:
            return "Operations";
        }
    }

    @Override
    public long getNumberOfRowsInSection (UITableView tableView, long section) {
        switch ((int)section) {
        case 0:
            return 1;
        default:
            return 4;
        }
    }

    @Override
    public UITableViewCell getCellForRow (UITableView tableView, NSIndexPath indexPath) {
        UITableViewCell cell = new UITableViewCell(UITableViewCellStyle.Default, "cell");
        String title;
        switch ((int)indexPath.getSection()) {
        case 0:
            title = FacebookManager.getInstance().isLoggedIn() ? "Logout" : "Login";
            break;
        default:
            switch ((int)indexPath.getRow()) {
            case 0:
                title = "User info";
                break;
            case 1:
                title = "User friends";
                break;
            case 2:
                title = "Granted permissions";
                break;
            default:
                title = "Publish feed";
                break;
            }
            break;
        }
        cell.getTextLabel().setText(title);
        if (indexPath.getSection() == 1) cell.setAccessoryType(UITableViewCellAccessoryType.DisclosureIndicator);

        return cell;
    }

    @Override
    public void didSelectRow (UITableView tableView, NSIndexPath indexPath) {
        switch ((int)indexPath.getSection()) {
        case 0:
            tapOnLoginButton();
            break;
        default:
            switch ((int)indexPath.getRow()) {
            case 0:
                tapOnUserInfoButton();
                break;
            case 1:
                tapOnFriendsButton();
                break;
            case 2:
                tapOnGrantedPermissionButton();
                break;
            default:
                tapOnPublishFeedButton();
                break;
            }
            break;
        }
        tableView.deselectRow(indexPath, true);
    }

    public void setMe (GraphUser me) {
        this.me = me;
    }
}
