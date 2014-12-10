
package org.robovm.bindings.facebook.manager.sample;

import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewCellStyle;
import org.robovm.apple.uikit.UITableViewController;
import org.robovm.bindings.facebook.manager.request.GraphUser;

public class UserInfoViewController extends UITableViewController {
    private GraphUser user;

    public UserInfoViewController () {
        setTitle("User Info");
    }

    @Override
    public long getNumberOfSections (UITableView tableView) {
        return user == null ? 0 : 1;
    }

    @Override
    public long getNumberOfRowsInSection (UITableView tableView, long section) {
        return user.hasInstalled() ? 7 : 6;
    }

    public void setUser (GraphUser user) {
        this.user = user;
        getTableView().reloadData();
    }

    @Override
    public UITableViewCell getCellForRow (UITableView tableView, NSIndexPath indexPath) {
        UITableViewCell cell = new UITableViewCell(UITableViewCellStyle.Value1, "cell");
        String title;
        String value;
        switch ((int)indexPath.getRow()) {
        case 0:
            title = "ID";
            value = user.getId();
            break;
        case 1:
            title = "Name";
            value = user.getName();
            break;
        case 2:
            title = "First Name";
            value = user.getFirstName();
            break;
        case 3:
            title = "Middle Name";
            value = user.getMiddleName();
            break;
        case 4:
            title = "Last Name";
            value = user.getLastName();
            break;
        case 5:
            title = "Username";
            value = user.getUsername();
            break;
        default:
            title = "Installed?";
            value = "YES";
            break;
        }
        cell.getTextLabel().setText(title);
        cell.getDetailTextLabel().setText(value);

        return cell;
    }
}
