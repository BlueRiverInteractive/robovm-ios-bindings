/* -------------------------------------------------------------------------------------- /
 *  OKUnityHelper.m
 *  OpenKit Unity Plugin
 * 
 *  Created by Lou Zell on 2/14/13.
 *  Copyright 2013 OpenKit. All rights reserved.
 * -------------------------------------------------------------------------------------- */

#import "OKUnityHelper.h"

char *OK_HS(const char *str)
{
	if (str == NULL)
		return NULL;
	
	char *res = (char *)malloc(strlen(str) + 1);
	strcpy(res, str);
	return res;
}
