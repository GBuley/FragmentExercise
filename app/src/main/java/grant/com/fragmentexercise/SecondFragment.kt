package grant.com.fragmentexercise

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import grant.com.fragmentexercise.databinding.FragmentSecondBinding
import java.lang.RuntimeException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"


class SecondFragment : Fragment() {

    private var param1: String? = null
    lateinit var binding : FragmentSecondBinding
    private var listener : SecondFragmentListener? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is SecondFragmentListener){
            context
        }else{
            throw RuntimeException("$context must implement SecondFragmentListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSecondBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvSentText.text = param1
        var textArray = param1?.split(" ")
        binding.btnFirstHalf.setOnClickListener {
            listener?.goToThird(textArray?.get(0))
        }
        binding.btnSecondHalf.setOnClickListener {
            listener?.goToThirdSecond(textArray?.get(1))
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}