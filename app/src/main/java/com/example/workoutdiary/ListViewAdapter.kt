import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.example.workoutdiary.ListViewItem
import com.example.workoutdiary.RoutineStartActivity
import com.example.workoutdiary.StatusActivity
import com.example.workoutdiary.databinding.ListviewItemBinding

class ListViewAdapter(private val items: MutableList<ListViewItem>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): ListViewItem = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val binding: ListviewItemBinding
        val convertView: View

        if (view == null) {
            binding = ListviewItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
            convertView = binding.root
            convertView.tag = binding
        } else {
            convertView = view
            binding = convertView.tag as ListviewItemBinding
        }

        val item = items[position]
        binding.routineTitle.text = item.routineTitle
        binding.routine.text = item.routine
        binding.count.text = item.count

        // parent.context를 사용하여 Intent 생성
        binding.routineButton.setOnClickListener {
            val intent = Intent(parent?.context, RoutineStartActivity::class.java)
            parent?.context?.startActivity(intent)
        }

        return convertView
    }
}
