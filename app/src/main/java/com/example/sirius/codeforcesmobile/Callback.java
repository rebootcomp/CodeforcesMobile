package com.example.sirius.codeforcesmobile;

import com.example.sirius.codeforcesmobile.connectionAPI.UserInterface;
import com.example.sirius.codeforcesmobile.connectionAPI.UserResult;

import java.util.List;

public interface Callback {
    public void call(List<UserResult> user);
}
