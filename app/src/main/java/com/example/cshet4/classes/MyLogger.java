package com.example.cshet4.classes;

import android.util.Log;

import androidx.annotation.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MyLogger
{
    public int nextId;
    public List<LogEntry> entries;


    public MyLogger()
    {
        nextId = 0;
        entries = new ArrayList<LogEntry>();

    }

    public LogEntry GetEntry(int i)
    {
        return entries.get(i);
    }

    //=====
    //log methods:

    public void LogGeneralError()
    {
        LogEntry newentry;
        newentry = new LogEntry(Priority.Normal, "General error logged.", "error");
        entries.add(newentry);
        Log.d(newentry.tag, "MyLog:" + newentry.tag + "\t" + newentry.logValue);
    }

    public void Log(String l)
    {
        LogEntry newentry;
        newentry = new LogEntry(Priority.Normal, l);
        entries.add(newentry);
        Log.d(newentry.tag, "MyLog: " + newentry.tag + "\t" + newentry.logValue);
    }

    public void Log(Priority priority, String l)
    {
        LogEntry newentry;
        newentry = new LogEntry(priority, l);
        entries.add(newentry);
        Log.d(newentry.tag, "MyLog: " + newentry.tag + "\t" + newentry.logValue);
    }

    public void Log(String l, String tag)
    {
        LogEntry newentry;
        newentry = new LogEntry(Priority.Normal, l, tag);
        entries.add(newentry);
        Log.d(newentry.tag, "MyLog: " + newentry.tag + "\t" + newentry.logValue);

    }

    public void Log(String l, Priority priority, String tag)
    {
        LogEntry newentry;
        newentry = new LogEntry(priority, l, tag);
        entries.add(newentry);
        Log.d(newentry.tag, "MyLog: " + newentry.tag + "\t" + newentry.logValue);

    }

    //============



    @NonNull
    @Override
    public String toString()
    {
        String so = "";

        for(LogEntry s : entries)
        {
            so += s.toString() + "\n";
        }

        return so;
    }



    //==================
    //logEntry inner class:
    public enum Priority {High, Low, Normal}
    public class LogEntry
    {
        public int id;

        public String tag;

        public LocalDateTime time;

        public Priority priority;
        public String logValue;


        //===
        //constructors:

        public LogEntry(Priority priority, String logValue)
        {
            this.time = LocalDateTime.now();
            this.priority = priority;
            this.logValue = logValue;

            this.tag = "none";
        }

        public LogEntry(Priority priority, String logValue, String tag)
        {
            this.time = LocalDateTime.now();
            this.priority = priority;
            this.logValue = logValue;

            this.tag = tag;
        }

        //===============


        @NonNull
        @Override
        public String toString()
        {
            return  "" + id + "\t" + logValue;
        }
    }
    //==================


}
