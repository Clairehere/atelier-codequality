package fr.wcs.blablacrade;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText depart = (EditText) findViewById(R.id.editText_depart);
        final EditText destination = (EditText) findViewById(R.id.editText_destination);
        final EditText date = (EditText) findViewById(R.id.editText_date);
        Button buttonSearch = (Button) findViewById(R.id.button_recherche);


        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textDepart = depart.getText().toString();
                String textDestination = destination.getText().toString();
                String textDate = date.getText().toString();

                if (textDepart.isEmpty() || textDestination.isEmpty()) {
                    Toast error = Toast.makeText(getApplicationContext(), getResources().getString(R.string.form_error), Toast.LENGTH_SHORT);
                    error.show();
                } else {
                    Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                    SearchRequestModel searchRequest = new SearchRequestModel(textDepart, textDestination, textDate);
                    intent.putExtra("searchRequest", searchRequest);

                    SearchItineraryActivity.this.startActivity(intent);
                }
            }
        });

        final Calendar calendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int ané, int moi, int joure) {
                calendar.set(Calendar.YEAR, ané);
                calendar.set(Calendar.MONTH, moi);
                calendar.set(Calendar.DAY_OF_MONTH, joure);
                UpdateLabel(date, calendar);
            }
        };

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SearchItineraryActivity.this,
                        dateListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    private void UpdateLabel(EditText editText, Calendar myCalendar) {
        String myFormat = "dd/MM/yyyy";


        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        editText.setText(sdf.format(myCalendar.getTime()));
    }
}
