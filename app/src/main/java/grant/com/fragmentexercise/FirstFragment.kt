package grant.com.fragmentexercise

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import grant.com.fragmentexercise.databinding.FragmentFirstBinding
import java.lang.RuntimeException


/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    lateinit var binding : FragmentFirstBinding

    private var listener: FirstFragmentListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is FirstFragmentListener){
            context
        }else{
            throw RuntimeException("$context must implement FirstFragmentListener")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentFirstBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFrag1.setOnClickListener {
            val etString = binding.etFragOne.text.toString()
            listener?.goToSecond(etString)
        }
    }

    //Another way to instantiate listener
    fun setListener(listener: FirstFragmentListener) {
        this.listener = listener
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FirstFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}