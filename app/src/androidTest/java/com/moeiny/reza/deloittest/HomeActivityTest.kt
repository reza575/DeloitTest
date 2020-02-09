package com.moeiny.reza.deloittest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.moeiny.reza.deloittest.view.HomeActivity
import org.junit.Rule
import org.junit.Test

//@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

  @get:Rule
  public val myActivitytest: ActivityTestRule<HomeActivity> = ActivityTestRule<HomeActivity>(HomeActivity::class.java)

  @Test
  fun clickcontinueButton_gotonewPage()  {
    onView(withId(R.id.txt_home_continue)).check(matches(withText("Continue")))
    onView(withId(R.id.txt_home_continue)).perform(ViewActions.click())
    onView(withId(R.id.txt_home_continue)).check(matches(withText("Loading...")))
  }
  }



