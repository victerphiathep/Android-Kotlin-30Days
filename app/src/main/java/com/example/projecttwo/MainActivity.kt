package com.example.projecttwo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    data class Tip(val day: String, val title: String, val description: String, val image: Int)

    class TipsAdapter(private val tips: List<Tip>) : RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

        class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tipDay: TextView = view.findViewById(R.id.tipDay)
            val tipTitle: TextView = view.findViewById(R.id.tipTitle)
            val tipImage: ImageView = view.findViewById(R.id.tipImage)
            val tipDescription: TextView = view.findViewById(R.id.tipDescription)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return TipViewHolder(view)
        }

        override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
            val tip = tips[position]
            holder.tipDay.text = tip.day
            holder.tipTitle.text = tip.title
            holder.tipImage.setImageResource(tip.image)
            holder.tipDescription.text = tip.description
            holder.tipDescription.textSize = 20f // Slightly larger font for the description

            // Initially hide the description
            holder.tipDescription.visibility = View.GONE

            // Set an OnClickListener to toggle visibility of the description
            holder.tipImage.setOnClickListener {
                holder.tipDescription.visibility = if (holder.tipDescription.visibility == View.GONE) View.VISIBLE else View.GONE
            }
        }

        override fun getItemCount() = tips.size
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tips = listOf(
            Tip("Day 1:", "Mindful Morning", "Start your day with a mindfulness meditation.", R.drawable.image1),
            Tip("Day 2:", "Gratitude Journal", "Write down three things you're grateful for.", R.drawable.image2),
            Tip("Day 3:", "Basketball", "Workout and shoot some hoops.", R.drawable.image3),
            Tip("Day 4:", "Study", "Dedicate time to your studies.", R.drawable.image4),
            Tip("Day 5:", "Eat Chicken", "Enjoy a delicious chicken meal.", R.drawable.image5)
            // Add more tips here...
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TipsAdapter(tips)
    }
}
