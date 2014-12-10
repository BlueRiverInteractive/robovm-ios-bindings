
package org.robovm.bindings.facebook.manager.sample;

import java.util.List;

import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewCellAccessoryType;
import org.robovm.apple.uikit.UITableViewCellStyle;
import org.robovm.apple.uikit.UITableViewController;
import org.robovm.bindings.facebook.manager.request.GraphUser;

public class UserSelectionViewController extends UITableViewController {
    private List<GraphUser> users;
    private final UserInfoViewController userInfoViewController;

    public UserSelectionViewController () {
        setTitle("Users");

        userInfoViewController = new UserInfoViewController();
    }

    @Override
    public long getNumberOfSections (UITableView tableView) {
        return users == null ? 0 : 1;
    }

    @Override
    public long getNumberOfRowsInSection (UITableView tableView, long section) {
        return users.size();
    }

    public void setUsers (List<GraphUser> users) {
        this.users = users;
        getTableView().reloadData();
    }

    @Override
    public UITableViewCell getCellForRow (UITableView tableView, NSIndexPath indexPath) {
        UITableViewCell cell = new UITableViewCell(UITableViewCellStyle.Default, "cell");

        GraphUser user = users.get((int)indexPath.getRow());

        cell.getTextLabel().setText(user.getName() + ": " + user.getId());
        cell.setAccessoryType(UITableViewCellAccessoryType.DisclosureIndicator);

        return cell;
    }

    @Override
    public void didSelectRow (UITableView tableView, NSIndexPath indexPath) {
        userInfoViewController.setUser(users.get((int)indexPath.getRow()));
        getNavigationController().pushViewController(userInfoViewController, true);

        tableView.deselectRow(indexPath, true);
    }
}
