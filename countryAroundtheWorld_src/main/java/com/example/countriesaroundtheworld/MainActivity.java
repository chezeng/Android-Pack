package com.example.countriesaroundtheworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String[] countryNames = {
            "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
            "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria",
            "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
            "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana",
            "Brazil", "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
            "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Caribbean Netherlands",
            "Cayman Islands", "Central African Republic", "Chad", "Channel Islands", "Chile",
            "China", "Colombia", "Comoros", "Congo", "Cook Islands", "Costa Rica", "Croatia",
            "Cuba", "Curaçao", "Cyprus", "Czech Republic", "Côte d'Ivoire", "Denmark", "Djibouti",
            "Dominica", "Dominican Republic", "DR Congo", "Ecuador", "Egypt", "El Salvador",
            "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Faeroe Islands",
            "Falkland Islands", "Fiji", "Finland", "France", "French Guiana", "French Polynesia",
            "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland",
            "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
            "Haiti", "Holy See", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
            "Indonesia", "Iran", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Jamaica",
            "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
            "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania",
            "Luxembourg", "Macao", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta",
            "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico",
            "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco",
            "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Caledonia",
            "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "North Korea",
            "North Macedonia", "Northern Mariana Islands", "Norway", "Oman", "Pakistan","Palau",
            "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal",
            "Puerto Rico", "Qatar", "Romania", "Russia", "Rwanda", "Réunion", "Saint Barthelemy",
            "Saint Helena", "Saint Kitts & Nevis", "Saint Lucia", "Saint Martin",
            "Saint Pierre & Miquelon", "Samoa", "San Marino", "Sao Tome & Principe",
            "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore",
            "Sint Maarten", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
            "South Korea", "South Sudan", "Spain", "Sri Lanka", "St. Vincent & Grenadines",
            "State of Palestine", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan",
            "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tokelau", "Tonga",
            "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos",
            "Tuvalu", "U.S. Virgin Islands", "Uganda", "Ukraine", "United Arab Emirates",
            "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela",
            "Vietnam", "Wallis & Futuna", "Western Sahara", "Yemen", "Zambia", "Zimbabwe"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Here, String.join() is combining all the names of countries & territories inside
           the array "countryNames" into one string, inserting "\n\n" in between each name. */
        TextView countryList = findViewById(R.id.country_list);
        countryList.setText(String.join("\n\n", countryNames));

        /* Countries Around the World Lab: For every change made inside the text field, capture the
                                           current input in the text field and use it to
                                           display the names of all countries and territories
                                           that start with this input. */

        EditText searchTextView = findViewById(R.id.search_text_field);
        searchTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String prefix = searchTextView.getText().toString();
                String filteredCountryList = searchForCountriesWithPrefix(prefix);
                countryList.setText(filteredCountryList);

            }
        });

    }

    /* Searches through the list of countries and territories to find those that start with
       the given string "prefix".
       The search is case-insensitive, with each country/territory name and "prefix" both
       converted to all lowercase letters when compared to each other. */
    private String searchForCountriesWithPrefix(String prefix) {
        String lowerPrefix = prefix.toLowerCase();
        ArrayList<String> countryNamesList = new ArrayList<>();
        for (String country: countryNames) {
            if (country.toLowerCase().startsWith(lowerPrefix)) {
                countryNamesList.add(country);
            }
        }
        if (countryNamesList.size() > 0) {
            return String.join("\n\n", countryNamesList);
        } else {
            return "No countries found!";
        }
    }


}