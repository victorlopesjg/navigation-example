package victor.com.br.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {

    lateinit var rootView : View

    fun newInstance(): Fragment {
        return InputFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("APP", "onCreate")

        var campo1 = arguments?.let { ResultFragmentArgs.fromBundle(it).campo1 }
        var campo2 = arguments?.let { ResultFragmentArgs.fromBundle(it).campo2 }

        Log.d("APP", campo1)
        Log.d("APP", campo2)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        super.onCreateView(inflater, container, savedInstanceState)/

        rootView = inflater.inflate(R.layout.fragment_result, container, false)

        return rootView
    }
}