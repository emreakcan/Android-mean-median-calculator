package com.mediancalculator

import android.app.Activity
import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.filters.SmallTest
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@SmallTest

class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun array_input_test() {

        onView(withId(R.id.edt_input)).perform(typeText("100,200,4,3,1,2,3,4"))
        onView(withId(R.id.txt_mean)).check(matches(withText("39.6")))
        onView(withId(R.id.txt_median)).check(matches(withText("3.5")))

        onView(withId(R.id.edt_input)).perform(clearText())
        onView(withId(R.id.edt_input)).perform(typeText("3,4,5,100,200,4,3,1,2,3,4"), closeSoftKeyboard())
        onView(withId(R.id.txt_mean)).check(matches(withText("29.9")))
        onView(withId(R.id.txt_median)).check(matches(withText("4.0")))

    }
}
