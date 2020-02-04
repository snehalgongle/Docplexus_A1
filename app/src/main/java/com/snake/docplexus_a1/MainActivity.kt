package com.snake.docplexus_a1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataList = ArrayList<Data>()
        // get the reference of RecyclerView that was created in the MainActivity
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        // set a LinearLayoutManager with default vertical orientation
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager

        try {
            // since we have JSON object, so we are getting the object
            //here we are calling a function and that function is returning the JSON Array
            // fetch JSONArray named users by using getJSONArray
            val userArray = JSONArray(loadJSONFromAsset())
            for (i in 0 until userArray.length()) {
                val data = userArray.getJSONObject(i)
                val user = data.getJSONObject("user")
                dataList.add(
                    Data(
                        data.getString("title"),
                        data.getString("featuredAttachmentUrl"),
                        data.getString("creationDate"),
                        data.getInt("answerCount"),
                        data.getInt("voteCount"),
                        data.getInt("viewCount"),
                        User(user.getString("thumbnailUrl"), user.getString("authorName")),
                        data.getString("shortBodyText"),
                        data.getBoolean("viewed"),
                        data.getBoolean("voted")
                    )
                )
            }
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }

        //  call the constructor of MyAdapter to send the reference and data to Adapter
        val customAdapter = MyAdapter(this@MainActivity, dataList)
        recyclerView.adapter = customAdapter // set the Adapter to RecyclerView

    }

    private fun loadJSONFromAsset(): String? {
        //function to load the JSON from the Asset and return the object
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val `is` = assets.open("posts.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
