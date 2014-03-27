
package org.robovm.bindings.facebook;

import org.robovm.apple.uikit.UITableView;
import org.robovm.objc.annotation.NativeClass;

/** The FBPlacePickerViewController class creates a controller object that manages the user interface for displaying and selecting
 * nearby places.
 * 
 * When the FBPlacePickerViewController view loads it creates a {@link UITableView} object where the places near a given location
 * will be displayed. You can access this view through the `tableView` property.
 * 
 * The place data can be pre-fetched and cached prior to using the view controller. The cache is setup using an
 * {@link FBCacheDescriptor} object that can trigger the data fetch. Any place data requests will first check the cache and use
 * that data. If the place picker is being displayed cached data will initially be shown before a fresh copy is retrieved.
 * 
 * The `delegate` property may be set to an object that conforms to the {@link FBPlacePickerDelegate} protocol. The `delegate`
 * object will receive updates related to place selection and data changes. The delegate can also be used to filter the places to
 * display in the picker. */
@NativeClass
public class FBPlacePickerViewController extends FBViewController {

//
// /*!
// @abstract
// Returns an outlet for the spinner used in the view controller.
// */
// @property (nonatomic, retain) IBOutlet UIActivityIndicatorView *spinner;
//
// /*!
// @abstract
// Returns an outlet for the table view managed by the view controller.
// */
// @property (nonatomic, retain) IBOutlet UITableView *tableView;
//
// /*!
// @abstract
// Addtional fields to fetch when making the Graph API call to get place data.
// */
// @property (nonatomic, copy) NSSet *fieldsForRequest;
//
// /*!
// @abstract
// A Boolean value that indicates whether place profile pictures are displayed.
// */
// @property (nonatomic) BOOL itemPicturesEnabled;
//
// /*!
// @abstract
// The coordinates to use for place discovery.
// */
// @property (nonatomic) CLLocationCoordinate2D locationCoordinate;
//
// /*!
// @abstract
// The radius to use for place discovery.
// */
// @property (nonatomic) NSInteger radiusInMeters;
//
// /*!
// @abstract
// The maximum number of places to fetch.
// */
// @property (nonatomic) NSInteger resultsLimit;
//
// /*!
// @abstract
// The search words used to narrow down the results returned.
// */
// @property (nonatomic, copy) NSString *searchText;
//
// /*!
// @abstract
// The session that is used in the request for place data.
// */
// @property (nonatomic, retain) FBSession *session;
//
// /*!
// @abstract
// The place that is currently selected in the view. This is nil
// if nothing is selected.
// */
// @property (nonatomic, retain, readonly) id<FBGraphPlace> selection;
//
// /*!
// @abstract
// Clears the current selection, so the picker is ready for a fresh use.
// */
// - (void)clearSelection;
//
// /*!
// @abstract
// Initializes a place picker view controller.
// */
// - (id)init;
//
// /*!
// @abstract
// Initializes a place picker view controller.
//
// @param aDecoder An unarchiver object.
// */
// - (id)initWithCoder:(NSCoder *)aDecoder;
//
// /*!
// @abstract
// Initializes a place picker view controller.
//
// @param nibNameOrNil The name of the nib file to associate with the view controller. The nib file name should not contain any
// leading path information. If you specify nil, the nibName property is set to nil.
// @param nibBundleOrNil The bundle in which to search for the nib file. This method looks for the nib file in the bundle's
// language-specific project directories first, followed by the Resources directory. If nil, this method looks for the nib file in
// the main bundle.
// */
// - (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil;
//
// /*!
// @abstract
// Configures the properties used in the caching data queries.
//
// @discussion
// Cache descriptors are used to fetch and cache the data used by the view controller.
// If the view controller finds a cached copy of the data, it will
// first display the cached content then fetch a fresh copy from the server.
//
// @param cacheDescriptor The <FBCacheDescriptor> containing the cache query properties.
// */
// - (void)configureUsingCachedDescriptor:(FBCacheDescriptor*)cacheDescriptor;
//
// /*!
// @abstract
// Initiates a query to get place data the first time or in response to changes in
// the search criteria, filter, or location information.
//
//
// @discussion
// A cached copy will be returned if available. The cached view is temporary until a fresh copy is
// retrieved from the server. It is legal to call this more than once.
// */
// - (void)loadData;
//
// /*!
// @abstract
// Updates the view locally without fetching data from the server or from cache.
//
// @discussion
// Use this if the filter properties change. This may affect the order or
// display of information.
// */
// - (void)updateView;
//
// /*!
// @method
//
// @abstract
// Creates a cache descriptor with additional fields and a profile ID for use with the
// `FBPlacePickerViewController` object.
//
// @discussion
// An `FBCacheDescriptor` object may be used to pre-fetch data before it is used by
// the view controller. It may also be used to configure the `FBPlacePickerViewController`
// object.
//
// @param locationCoordinate The coordinates to use for place discovery.
// @param radiusInMeters The radius to use for place discovery.
// @param searchText The search words used to narrow down the results returned.
// @param resultsLimit The maximum number of places to fetch.
// @param fieldsForRequest Addtional fields to fetch when making the Graph API call to get place data.
// */
// + (FBCacheDescriptor*)cacheDescriptorWithLocationCoordinate:(CLLocationCoordinate2D)locationCoordinate
// radiusInMeters:(NSInteger)radiusInMeters
// searchText:(NSString*)searchText
// resultsLimit:(NSInteger)resultsLimit
// fieldsForRequest:(NSSet*)fieldsForRequest;

}
