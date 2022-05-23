package com.kasun98.android.robolectric_testing

import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RobolectricFragmentTest {

    private var activity: MainActivity? = null
    private var fragment: TestFragment? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        fragment = TestFragment()
        activity = Robolectric.buildActivity(
            MainActivity::class.java
        )
            .create()
            .start()
            .resume()
            .get()

        val fragmentManager: FragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment!!, null)
        fragmentTransaction.commit()
    }

    @Test
    fun validateTextViewContent() {
        val textViewFragment : TextView = activity!!.findViewById<TextView>(R.id.fragment_text)
        Assert.assertNotNull("Text not fount", textViewFragment)
        Assert.assertTrue(
            "Text not matching",
            "Fragment_Text_Value" == textViewFragment.text.toString()
        )
    }
}