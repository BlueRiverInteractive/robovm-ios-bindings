//
//  Apsalar.js
//  Apsalar js/SDK for iPhone/iOS public API
//
//  Created by Frank Ledo on 11/14/11
//  Copyright © 2010-2011 Apsalar Inc. All rights reserved.
//
var Apsalar={
    AP_TRIGGER_RESULT:{
    AP_TRIGGER_SUCCESS: 0,         // An overlay was loaded
    AP_TRIGGER_NOT_SHOWN: 1,       // Overlay not shown, unknown reason
    AP_TRIGGER_NOT_READY: 2,       // Apsalar session not started
    AP_TRIGGER_NO_CONNECTIVITY: 3, // No connectivity needed to do overlay
    AP_TRIGGER_NO_RULE: 4,         // No rules connected to this trigger 
    AP_TRIGGER_UNKNOWN: 5,         // New trigger, not yet registered
    AP_TRIGGER_CURRENTLY_ACTIVE:6  // A trigger is already active
    }
    /* 
     * Read-Only Properties, set after each call to Apsalar.
     * Call Apsalar.update() to update these.
     */
    // version: Apsalar API Version
    ,version:null
    // triggerActive: If an Apsalar trigger is currently active
    ,triggerActive:false
    // lastTriggerResult: The result code of the last Apsalar trigger
    ,lastTriggerResult:null
    // sessionStarted: If an Apsalar session has started
    ,sessionStarted:false
    /* Methods */
    ,event:function(name, withArgs) {
        Apsalar.int_call('event', name, withArgs);
    }
    /* registerCallback:  Register a callback function.   
     * @param  signature  The signature takes the format of:
     *                    funcname(var1,var2,var3), the signature will be 
     *                    viewable in the web interface, and you will be able 
     *                    to define values for these variables.
     * @param  func       function that will be called.  This function should
     *                    expect to receive one parameter, an object whose keys
     *                    will include the variables defined in the signautre as
     *                    well as some Apsalar specific information.
     */ 
    ,registerCallback:function(signature, func) {
        signature='js:'+signature.replace(' ', '');
        Apsalar.int_callbacks[signature]=func;
        Apsalar.int_call('registerCallback', signature);
    }
    /* 
     * trigger:  Initiate a trigger 
     * @param  name       The name of the trigger to initiate.
     */
    ,trigger:function(name) {
        Apsalar.int_call('trigger',name);
    }
    /* update: Update read-only properties */
    ,update:function() {
        Apsalar.int_call('update');
    }
    /* Internal use only */
    ,int_callbacks:{}
    ,int_request:function(url) {
        var iframe = document.createElement("iframe");
        iframe.setAttribute("style", "display:none;");
        iframe.setAttribute("height","0px");
        iframe.setAttribute("width","0px");
        iframe.setAttribute("frameborder","0");
        iframe.src=url;
        document.documentElement.appendChild(iframe);
    }
    ,int_call:function() {
        var arg, uargs=[], aargs=['_rand_='+parseInt(Math.random()*100)], 
        url='apsalar://';
        for (var i=0, val;(val = arguments[i]);i++) {
            if (typeof val == 'object') {
                for (o in val) {
                    arg=o+'='+encodeURIComponent(val[o]);
                    aargs.push(arg)
                }
            }
            else {
                arg=encodeURIComponent(val);
                uargs.push(arg);
            }
        }
        url=url+uargs.join('/')+'?'+aargs.join('&');
        Apsalar.int_request(url);
    }
    ,int_callback:function(signature, dict) {
        if (Apsalar.int_callbacks[signature]) 
            Apsalar.int_callbacks[signature](dict);
    }
};
// Do an initial update to set the value of read-only properties.
Apsalar.update();

