package com.example.agecalculator

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) //Forcing Screen Orientation to Portrait Only
        setContentView(R.layout.activity_main)

        val btnDOB = findViewById<Button>(R.id.btnDOB)

        val btnAbout = findViewById<Button>(R.id.btnAbout)

        btnDOB.setOnClickListener{view -> DOBpicker(view)
            Toast.makeText(this, "Selecting Date Of Birth", Toast.LENGTH_LONG).show()  }

        btnAbout.setOnClickListener{Toast.makeText(this, "       @Usaama\n+256 787 441875",Toast.LENGTH_LONG).show()}
    }


    @SuppressLint("SetTextI18n")
    fun DOBpicker(view: View)
    {
        val DOBcalendar: Calendar = Calendar.getInstance()
        var yyyy = DOBcalendar.get(Calendar.YEAR)
        var m = DOBcalendar.get(Calendar.MONTH)
        var dd = DOBcalendar.get(Calendar.DAY_OF_MONTH)
        var tvDOB = findViewById<TextView>(R.id.tvDOB)
        var tvNextBd = findViewById<TextView>(R.id.tvNextBd)
        var tvAge = findViewById<TextView>(R.id.tvAge)
        var ageYear: Int; var ageMonth: Int; var ageDay: Int;
        var age1: String
        var DAY: Int; var months: String; var weeks: String; var hours: Int; var minutes: Int; var seconds: Int;
        var nextBDday: Int; var nextBDmonth: Int;
        var unknown: Boolean= false;

        DatePickerDialog( this, DatePickerDialog.OnDateSetListener { view, YYYY, M, DD ->
            var mm = m + 1;  var MM = M + 1; val selectedDOB = "$DD/$MM/$YYYY";
            tvDOB.setText(selectedDOB)

            //Selected Date Variables DD/MM/YYYY
            //Current Date Variables dd/mm/yyyy
            //Calculating Age
            if(yyyy>YYYY)
            {
                if(mm >= MM && dd >= DD)
                {
                    ageYear = yyyy - YYYY; ageMonth = mm - MM; ageDay = dd - DD;
                    age1 = "${ageYear} Years, ${ageMonth} Months And ${ageDay} Days"
                    DAY = (ageYear * 365) + (ageMonth * 30) + ageDay;
                    months = "${(ageYear * 12) + ageMonth} Months and ${ageDay} Days"
                    weeks = "${DAY/7} Weeks and ${DAY%7} Days"
                    hours = DAY * 24; minutes = DAY * 1440; seconds = DAY * 86400;

                    tvAge.setText("$age1\nOr $months\nOr $weeks\nOr ${DAY} Days\nOr ${hours} Hours\nOr ${minutes} Minutes\nOr ${seconds} Seconds")
                }
                else if(mm < MM && dd >= DD)
                {
                    yyyy -= 1; mm += 12;
                    ageYear = yyyy - YYYY; ageMonth = mm - MM; ageDay = dd - DD;
                    age1 = "${ageYear} Years, ${ageMonth} Months And ${ageDay} Days"
                    DAY = (ageYear * 365) + (ageMonth * 30) + ageDay;
                    months = "${(ageYear * 12) + ageMonth} Months and ${ageDay} Days"
                    weeks = "${DAY/7} Weeks and ${DAY%7} Days"
                    hours = DAY * 24; minutes = DAY * 1440; seconds = DAY * 86400;

                    tvAge.setText("$age1\nOr $months\nOr $weeks\nOr ${DAY} Days\nOr ${hours} Hours\nOr ${minutes} Minutes\nOr ${seconds} Seconds")
                }
                else if(mm > MM && dd < DD)
                {
                    dd += 30; mm -= 1;
                    ageYear = yyyy - YYYY; ageMonth = mm - MM; ageDay = dd - DD;
                    age1 = "${ageYear} Years, ${ageMonth} Months And ${ageDay} Days"
                    DAY = (ageYear * 365) + (ageMonth * 30) + ageDay;
                    months = "${(ageYear * 12) + ageMonth} Months and ${ageDay} Days"
                    weeks = "${DAY/7} Weeks and ${DAY%7} Days"
                    hours = DAY * 24; minutes = DAY * 1440; seconds = DAY * 86400;

                    tvAge.setText("$age1\nOr $months\nOr $weeks\nOr ${DAY} Days\nOr ${hours} Hours\nOr ${minutes} Minutes\nOr ${seconds} Seconds")
                }
                else if(mm == MM && dd < DD)
                {
                    dd += 30; mm += 11; yyyy -= 1;
                    ageYear = yyyy - YYYY; ageMonth = mm - MM; ageDay = dd - DD;
                    age1 = "${ageYear} Years, ${ageMonth} Months And ${ageDay} Days"
                    DAY = (ageYear * 365) + (ageMonth * 30) + ageDay;
                    months = "${(ageYear * 12) + ageMonth} Months and ${ageDay} Days"
                    weeks = "${DAY/7} Weeks and ${DAY%7} Days"
                    hours = DAY * 24; minutes = DAY * 1440; seconds = DAY * 86400;

                    tvAge.setText("$age1\nOr $months\nOr $weeks\nOr ${DAY} Days\nOr ${hours} Hours\nOr ${minutes} Minutes\nOr ${seconds} Seconds")
                }
                else if(mm < MM && dd < DD)
                {
                    yyyy -= 1; mm += 11; dd += 30;
                    ageYear = yyyy - YYYY; ageMonth = mm - MM; ageDay = dd - DD;
                    age1 = "${ageYear} Years, ${ageMonth} Months And ${ageDay} Days"
                    DAY = (ageYear * 365) + (ageMonth * 30) + ageDay;
                    months = "${(ageYear * 12) + ageMonth} Months and ${ageDay} Days"
                    weeks = "${DAY/7} Weeks and ${DAY%7} Days"
                    hours = DAY * 24; minutes = DAY * 1440; seconds = DAY * 86400;

                    tvAge.setText("$age1\nOr $months\nOr $weeks\nOr ${DAY} Days\nOr ${hours} Hours\nOr ${minutes} Minutes\nOr ${seconds} Seconds")
                }
                else{ tvAge.setText("Unknown") }

            }
            else if(yyyy == YYYY)
            {
                if(mm >= MM && dd >= DD)
                {
                    ageYear = yyyy - YYYY; ageMonth = mm - MM; ageDay = dd - DD;
                    age1 = "${ageYear} Years, ${ageMonth} Months And ${ageDay} Days"
                    DAY = (ageYear * 365) + (ageMonth * 30) + ageDay;
                    months = "${(ageYear * 12) + ageMonth} Months and ${ageDay} Days"
                    weeks = "${DAY/7} Weeks and ${DAY%7} Days"
                    hours = DAY * 24; minutes = DAY * 1440; seconds = DAY * 86400;

                    tvAge.setText("$age1\nOr $months\nOr $weeks\nOr ${DAY} Days\nOr ${hours} Hours\nOr ${minutes} Minutes\nOr ${seconds} Seconds")
                }
                else if(mm > MM && dd < DD)
                {
                    mm -= 1; dd += 30;
                    ageYear = yyyy - YYYY; ageMonth = mm - MM; ageDay = dd - DD;
                    age1 = "${ageYear} Years, ${ageMonth} Months And ${ageDay} Days"
                    DAY = (ageYear * 365) + (ageMonth * 30) + ageDay;
                    months = "${(ageYear * 12) + ageMonth} Months and ${ageDay} Days"
                    weeks = "${DAY/7} Weeks and ${DAY%7} Days"
                    hours = DAY * 24; minutes = DAY * 1440; seconds = DAY * 86400;

                    tvAge.setText("$age1\nOr $months\nOr $weeks\nOr ${DAY} Days\nOr ${hours} Hours\nOr ${minutes} Minutes\nOr ${seconds} Seconds")
                }
                else{unknown = true; tvAge.setText("Date Of Birth Needs To Be Earlier Than The Current Date");}
            }
            else{unknown = true; tvAge.setText("Date Of Birth Needs To Be Earlier Than The Current Date");}


            //Next Birthday
            if(unknown){tvNextBd.setText("Invalid Date Of Birth")}
            else if(DD < dd)
            {
                var tvToNextBDtxt = findViewById<TextView>(R.id.tvToNextBDtxt)
                var birthdDay = DD;
                MM += 11;  birthdDay += 30;

                nextBDday = birthdDay - dd; nextBDmonth = MM - mm;

                tvNextBd.setText("${nextBDmonth} Months and ${nextBDday} Days")
                tvToNextBDtxt.setText("To Your Next Birthday")

            }
            else if(DD >= dd)
            {
                var tvToNextBDtxt = findViewById<TextView>(R.id.tvToNextBDtxt)
                var birthdDay = DD;
                MM += 12;

                nextBDday = birthdDay - dd; nextBDmonth = MM - mm;

                tvNextBd.setText("${nextBDmonth} Months and ${nextBDday} Days")
                tvToNextBDtxt.setText("To Your Next Birthday")

            }
            else{}



        }, yyyy, m, dd).show()
    }


}

