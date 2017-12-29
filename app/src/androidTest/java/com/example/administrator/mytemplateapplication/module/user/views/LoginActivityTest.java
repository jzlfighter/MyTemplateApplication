package com.example.administrator.mytemplateapplication.module.user.views;

import android.support.test.rule.ActivityTestRule;

import com.example.administrator.mytemplateapplication.R;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Administrator on 2017/12/28.
 */
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> rule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void login() throws Exception {
        onView(withId(R.id.email)).perform(typeText("15645815333"));
        onView(withId(R.id.password)).perform(typeText("a111111"));
        onView(withId(R.id.email_sign_in_button)).perform(click());
    }

    @After
    public void stay() throws Exception {
        Thread.sleep(1000 * 3);
    }
}