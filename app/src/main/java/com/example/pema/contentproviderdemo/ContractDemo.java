package com.example.pema.contentproviderdemo;

import android.content.Context;
import android.net.Uri;

public class ContractDemo
{
    private ContractDemo(){}
    /*Apps sends request to the content provider using content Uniform Resource
    Identifiers or URIs.A content URI for the content providers has this general form
    scheme://authority/path-to-data/dataset-name
      */
    public static final String Authority="com.example.pema.contentproviderdemo.provider";
    //in Authority first we have to write the package nameand then ".provider"
    public static final String Content_Path="Pema";
    //It can be any name but same as  the name of the string array
    public static final Uri Content_Uri=Uri.parse("content://"+Authority+"/"+Content_Path);
    public static final int All_Item=-2;
    public static final String Id="id";
    //uniquely identifies the data set to search ;such as a file name and table name
    public static final String Single ="vnd.android.cursor.item/vnd.com.example.provider.Pema";
    //MIME Multipurpose Internet Mail Extension) type for single item
    public static final String Multiple ="vnd.android.cursor.dir/vnd.com.example.provider.Pema";
 //   multiple items


}
