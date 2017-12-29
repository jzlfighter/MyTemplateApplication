package com.example.administrator.mytemplateapplication.module.test.views;

import android.support.test.rule.ActivityTestRule;

import com.example.administrator.mytemplateapplication.R;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Administrator on 2017/12/29.
 */
public class TestActivityTest {
    @Rule
    public ActivityTestRule<TestActivity> rule = new ActivityTestRule<>(TestActivity.class);

    @Test
    public void loadData() throws Exception {
        onView(withId(R.id.btButton)).perform(click());
    }

    @After
    public void stay() throws Exception {
        Thread.sleep(1000 * 3);
    }
}