package com.example.sirius.codeforcesmobile;

import com.example.sirius.codeforcesmobile.connectionAPI.UserInterface;
import com.example.sirius.codeforcesmobile.connectionAPI.UserResult;

import java.util.List;

public interface Callback<T> {
    void call(/*List<UserResult>*/T user);
}
