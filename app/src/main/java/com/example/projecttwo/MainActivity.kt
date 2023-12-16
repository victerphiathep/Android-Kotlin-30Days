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
            Tip("Day 5:", "Eat Chicken", "Enjoy a delicious chicken meal.", R.drawable.image5),
            Tip("Day 6:", "Volleyball", "Practice some volleyball.", R.drawable.volleyball),
            Tip("Day 7:", "Rest day", "Rest your body and recharge.", R.drawable.rest_day),
            Tip("Day 8:", "Yoga", "Stretch your muscles out and become flexible.", R.drawable.yoga),
            Tip("Day 9:", "Read A Book", "Read a couple chapters of a book.", R.drawable.book),
            Tip("Day 10:", "Meditate", "Meditate for atleast 30 minutes.", R.drawable.meditate),
            Tip("Day 11:", "Powerlift", "Squat Bench and Deadlift!.", R.drawable.powerlift),
            Tip("Day 12:", "Basketball", "Shoot some hoops.", R.drawable.image3),
            Tip("Day 13:", "Study", "Study some programming concepts.", R.drawable.image4),
            Tip("Day 14:", "Gratitude Journal", "Write down three things you're grateful for.", R.drawable.image2),
            Tip("Day 15:", "Mindful Morning", "Start your day with a mindfulness meditation.", R.drawable.image1),
            Tip("Day 16:", "Study", "Dedicate time to your studies.", R.drawable.image4),
            Tip("Day 17:", "Rest day", "Rest your body up.", R.drawable.rest_day),
            Tip("Day 18:", "Eat Noodles", "Enjoy a delicious noodle soup meal.", R.drawable.noodles),
            Tip("Day 19:", "Volleyball", "Play volleyball with friends.", R.drawable.volleyball),
            Tip("Day 20:", "Leetcode", "Practice some leetcode for interview prep.", R.drawable.lc),
            Tip("Day 21:", "Study", "Dedicate time to your studies.", R.drawable.image4),
            Tip("Day 22:", "Eat Chicken", "Enjoy a delicious chicken meal.", R.drawable.image5),
            Tip("Day 23:", "Tell your mom you love her", "Call your mother and tell her you love her.", R.drawable.mom),
            Tip("Day 24:", "Volleyball", "Practice jumping for spiking.", R.drawable.volleyball),
            Tip("Day 25:", "Basketball", "Play some 2v2 basketball.", R.drawable.image3),
            Tip("Day 26:", "Volleyball", "Play some doubles volleyball.", R.drawable.volleyball),
            Tip("Day 27:", "Go for a jog", "Go for a 3 mile jog outdoors.", R.drawable.jog),
            Tip("Day 28:", "Study", "Dedicate time to your studies.", R.drawable.image4),
            Tip("Day 29:", "Rest day", "Enjoy a delicious chicken meal.", R.drawable.rest_day),
            Tip("Day 30:", "Celebrate 30 Days", "Reward yourself to commiting to 30 days", R.drawable.image1),
            // Add more tips here...
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TipsAdapter(tips)
    }
}
