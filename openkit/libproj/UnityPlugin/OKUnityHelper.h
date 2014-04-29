/* -------------------------------------------------------------------------------------- /
 *  OKUnityHelper.h
 *  OpenKit Unity Plugin
 *
 *  Created by Lou Zell on 2/14/13.
 *  Copyright 2013 OpenKit. All rights reserved.
 * -------------------------------------------------------------------------------------- /
 *
 *
 *  From Native Code Unity Example:
 *
 *    By default mono string marshaler creates .Net string for returned UTF-8 C string
 *    and calls free for returned value, thus returned strings should be allocated on heap
 *
 *  Use this helper when returning strings.
 *  HS stands for HeapString.
 *
 *  Use this in conjunction with UnitySendMessage.  For example:
 *     char *x = "Whatever";
 *     UnitySendMessage(HS([_gameObject UTF8String]), HS(x), HS([someParam UTF8String]));
 * -------------------------------------------------------------------------------------- */
extern char *OK_HS(const char *str);

