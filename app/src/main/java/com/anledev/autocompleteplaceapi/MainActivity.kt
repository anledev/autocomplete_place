package com.anledev.autocompleteplaceapi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.AutocompleteActivity
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Places.initialize(applicationContext, getString(R.string.api_key))

        edtLocation.isFocusable = false
        edtLocation.setOnClickListener {
            val fields = listOf(
                Place.Field.NAME,
                Place.Field.ADDRESS,
                Place.Field.LAT_LNG
            )

            val intent = Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fields)
                .setInitialQuery(edtLocation.text.toString())
                .build(this@MainActivity)
            startActivityForResult(intent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            val place = Autocomplete.getPlaceFromIntent(data!!)
            edtLocation.setText(place.address)
            this.e("${place.address} \n Location Name: ${place.name} \n ${place.latLng}")
        } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
            val status = Autocomplete.getStatusFromIntent(data!!)
            this.e("${status.statusMessage}")
        }
    }
}