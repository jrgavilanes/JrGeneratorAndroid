package es.codekai.jrgeneratorandroid

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.codekai.jrgeneratorandroid.databinding.MessageItemBinding

class MessageHolder(val binding: MessageItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(message: Message, onclickListener: (Message) -> Unit) {
        binding.txtMessage.text = message.message
        if (message.author == "yo") {
            binding.txtMessage.gravity = Gravity.START
        } else {
            binding.txtMessage.gravity = Gravity.END
        }
        binding.root.setOnClickListener {
            onclickListener(message)
        }
    }
}

class MessageListAdapter(
    private val messages: List<Message>,
    private val onclickListener: (Message) -> Unit
) :
    RecyclerView.Adapter<MessageHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MessageItemBinding.inflate(inflater, parent, false)
        return MessageHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        val message = messages[position]
        holder.bind(message, onclickListener)
    }

    override fun getItemCount() = messages.size
}
