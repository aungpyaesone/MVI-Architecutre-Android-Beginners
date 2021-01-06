package com.aungpyaesone.mvi_architecutre_android_beginners

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val spannable = SpannableString(getString(R.string.my_text))
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            0,3,Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        spannable.setSpan(
            RelativeSizeSpan(2f),36,44,Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        tvMessage.text = spannable

        val bulletSpan = listOf("one","two","three","four","five")
        tvBulletText.text = convertToBulletList(bulletSpan)

    }

    private fun convertToBulletList(stringList:List<String>): CharSequence{
        val spannableStringBuilder = SpannableStringBuilder("Learn Android from \n")
        stringList.forEachIndexed { index, text ->
            val line : CharSequence = text + if(index < stringList.size -1) "\n" else ""
            val spannable: Spannable = SpannableString(line)
            spannable.setSpan(
                BulletSpan(15,Color.BLUE),
                0,
                spannable.length,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE
            )
            spannableStringBuilder.append(spannable)
        }
        return spannableStringBuilder
    }
}