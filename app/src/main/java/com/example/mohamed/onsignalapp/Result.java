package com.example.mohamed.onsignalapp;

/**
 * Created by mohamed mabrouk
 * 0201152644726
 * on 06/12/2017.  time :16:08
 */

public class Result {
    private static  Result ourInstance ;
    interface  resultLisinter{
        void onsucess(String  s);
    }
    private resultLisinter lisinter;
    public static Result getInstance() {
        if (ourInstance==null)
            ourInstance=new Result();
        return ourInstance;
    }

    private Result() {
    }

    public void setLisner(resultLisinter lisner){
        if (lisner!=null)
            lisinter=lisner;
    }

    public void setmsg(String s){
        lisinter.onsucess(s);
    }
}
